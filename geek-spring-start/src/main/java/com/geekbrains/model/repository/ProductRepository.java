package com.geekbrains.model.repository;


import com.geekbrains.model.entity.Product;

import java.util.Map;

public interface ProductRepository {
    void add(Product product);

    Product getProductById(int id);

    void printProducts();

    Map<Integer, Product> getDb();
}
