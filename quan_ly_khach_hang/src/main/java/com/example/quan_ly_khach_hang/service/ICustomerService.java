package com.example.quan_ly_khach_hang.service;

import com.example.quan_ly_khach_hang.model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void addCustomer(Customer customer);

}
