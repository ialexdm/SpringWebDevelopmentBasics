package com.geekbrains.geekspringstart.model.dao.repository;

import com.geekbrains.geekspringstart.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;




public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
