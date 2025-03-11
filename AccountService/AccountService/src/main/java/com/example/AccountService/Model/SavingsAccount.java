package com.example.AccountService.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "savings_account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SavingsAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountNumber;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private double availableBalance;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    @JsonIgnore
    private Customer customer;



}
