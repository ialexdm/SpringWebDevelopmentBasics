package com.geekbrains.geekspringstart.model.dao.repository;

import com.geekbrains.geekspringstart.model.entity.Customer;
import org.springframework.data.repository.CrudRepository;



public interface CustomerRepository extends CrudRepository<Customer,Long> {

}
