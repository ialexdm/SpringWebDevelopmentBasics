package com.geekbrains.geekspringstart.model.repository;


import com.geekbrains.geekspringstart.model.entity.Product;

import java.util.Map;

public interface ProductRepository {
    void add(Product product);

    Product getProductById(int id);

    void printProducts();

    Map<Integer, Product> getDb();
}
