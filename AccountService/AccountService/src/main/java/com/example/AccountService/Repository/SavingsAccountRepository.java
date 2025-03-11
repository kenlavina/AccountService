package com.example.AccountService.Repository;

import com.example.AccountService.Model.SavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingsAccountRepository extends JpaRepository<SavingsAccount, Long> {

}
