package com.example.AccountService.Controller;

import com.example.AccountService.Model.Customer;
import com.example.AccountService.Service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
public class CustomerController {

    @Autowired
    public CustomerService customerService;
    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.createCustomer(customer);
        if(customer.getCustomerEmail() == null || customer.getCustomerEmail().equals("") ) {
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse( 400, "Email is required field"));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(new PostResponse( savedCustomer.getCustomerNumber() ,201, "Customer account created"));
    }

    @GetMapping("/{customerNumber}")
    public ResponseEntity<?> getCustomer(@PathVariable Long customerNumber) {
        List<Customer> customers = customerService.findByCustomerNumber(customerNumber);
        if(!customers.isEmpty()) {
            return ResponseEntity.status(HttpStatus.FOUND).body(new GetResponse(customers, 302, "Customer account found"));
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse( 401, "Customer not found"));
        }
    }

}

@Data
@AllArgsConstructor
class GetResponse {

    private List<Customer> customers;
    private int transactionStatusCode;
    private String transactionStatusDescription;
}

@Data
@AllArgsConstructor
class PostResponse {
    private Long customerNumber;
    private int transactionStatusCode;
    private String transactionStatusDescription;
}


@Data
@AllArgsConstructor
class ErrorResponse {
    private int transactionStatusCode;
    private String transactionStatusDescription;
}
