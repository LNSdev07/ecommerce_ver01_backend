package com.t3h.ecommerce.service;


public interface ProductService {
         String findProductWithFilter(String sorts, String colors, String sizes, String page);
}
