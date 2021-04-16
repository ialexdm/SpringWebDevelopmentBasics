package ru.geekbrains.model.repository;

import ru.geekbrains.model.entity.Product;

public interface ProductRepository {
    Product getProductById(int id);

    void printProducts();
}
