package com.t3h.ecommerce.entities.voucher;

import com.t3h.ecommerce.entities.BaseEntity;
import com.t3h.ecommerce.entities.order.Customer;
import com.t3h.ecommerce.entities.product.Product;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "voucher")
public class Voucher extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "voucher_code")
    private String voucherCode;

    @Column(name = "voucher_name")
    private String voucherName;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "start_date")
    private Long startDate;

    @Column(name = "end_date")
    private Long endDate;

   @ManyToMany( mappedBy = "vouchers",fetch = FetchType.LAZY)
    private List<Customer> customerList;

   @ManyToMany(mappedBy = "vouchers", fetch = FetchType.LAZY)
    private List<Product> products;

}
