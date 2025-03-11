package com.example.AccountService.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerNumber;

    @Size(max = 50)
    @NotBlank(message = "Customer name is Required")
    private String customerName;

    @Size(max = 20)
    private String customerMobile;

    @Size(max = 50)
    @Email
    private String customerEmail;

    @Size(max = 100)
    @NotBlank(message = "Customer address1 is Required")
    private String address1;

    @Size(max = 100)
    private String address2;

    @Enumerated(EnumType.STRING)
    public AccountType accountType;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    private List<SavingsAccount> savings;

    public Customer(Long customerNumber, String customerName, String customerMobile, String customerEmail, String address1, String address2, AccountType accountType, List<SavingsAccount> savings) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.customerMobile = customerMobile;
        this.customerEmail = customerEmail;
        this.address1 = address1;
        this.address2 = address2;
        this.accountType = accountType;
        this.savings = savings;
    }
}
