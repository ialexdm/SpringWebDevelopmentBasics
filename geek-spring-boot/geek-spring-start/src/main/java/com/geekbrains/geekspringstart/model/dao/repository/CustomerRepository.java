package com.geekbrains.geekspringstart.model.dao.repository;

import com.geekbrains.geekspringstart.model.entity.Customer;

import java.util.List;

public interface CustomerRepository {

    Customer findById(long id);

    List<Customer> findAll();

    void save(Customer customer);
}
