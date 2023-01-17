package com.t3h.ecommerce.controller;


import com.t3h.ecommerce.dto.request.SignInForm;
import com.t3h.ecommerce.dto.request.SignUpForm;
import com.t3h.ecommerce.dto.response.JwtResponse;
import com.t3h.ecommerce.dto.response.ResponseMessage;
import com.t3h.ecommerce.entities.core.Role;
import com.t3h.ecommerce.entities.core.RoleName;
import com.t3h.ecommerce.entities.core.User;
import com.t3h.ecommerce.security.jwt.JwtProvider;
import com.t3h.ecommerce.security.userprincal.UserPrinciple;
import com.t3h.ecommerce.service.Impl.RoleServiceImpl;
import com.t3h.ecommerce.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/auth")
public class AuthController {

   @Autowired
   UserServiceImpl userService;

   @Autowired
   RoleServiceImpl roleService;

   @Autowired
   PasswordEncoder passwordEncoder;

   @Autowired
   AuthenticationManager authenticationManager;

   @Autowired
   JwtProvider jwtProvider;

   @PostMapping("/signup")
   public ResponseEntity<?> register(@Valid @RequestBody SignUpForm signUpForm){
      if(userService.existsByUsername(signUpForm.getUserName())){
         return new ResponseEntity<>(new ResponseMessage("the username is exsited"), HttpStatus.OK);
      }
      else if(userService.existsByEmail(signUpForm.getEmail())){
         return new ResponseEntity<>(new ResponseMessage("the email is existed"), HttpStatus.OK);
      }

      User user = new User(signUpForm.getUserName(),
              passwordEncoder.encode(signUpForm.getPassword()),
              signUpForm.getEmail()
      );
      List<Role> roles = new ArrayList<>();
      Role userRole = roleService.findByRoleName(RoleName.USER).orElseThrow(() -> new RuntimeException("Role not found"));
      roles.add(userRole);
      user.setRoles(roles);

      userService.save(user);
      return new ResponseEntity<>(new ResponseMessage("create user success"), HttpStatus.OK);
   }

   @PostMapping("/signin")
   public ResponseEntity<?> signIn(@Valid @RequestBody SignInForm signInForm){
      Authentication authentication = authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(
                      signInForm.getUsername(), signInForm.getPassword()
              )
      );
      SecurityContextHolder.getContext().setAuthentication(authentication);
      String token = jwtProvider.createToken(authentication);

      UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
      return new ResponseEntity<>(new JwtResponse(token,
              userPrinciple.getFullName(),
              userPrinciple.getAuthorities()), HttpStatus.OK);
   }
}
