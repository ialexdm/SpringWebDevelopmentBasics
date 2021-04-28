package com.geekbrains.geekspringstart.model.repository;

import com.geekbrains.geekspringstart.model.entity.Customer;

public interface CustomerRepository {
    Customer findById(long id);
}
