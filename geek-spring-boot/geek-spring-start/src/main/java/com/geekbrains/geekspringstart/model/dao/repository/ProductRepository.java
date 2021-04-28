package com.geekbrains.geekspringstart.model.dao.repository;


import com.geekbrains.geekspringstart.model.entity.Product;

import java.util.List;

public interface ProductRepository {

    Product findById(long id);

    Product findByTitle(String title);

    List<Product> findAll();

    void deleteById(Long id);

    Product saveOrUpdate(Product product);
}
