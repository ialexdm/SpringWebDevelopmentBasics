package com.geekbrains.geekspringstart.model.dao.repository;


import com.geekbrains.geekspringstart.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
