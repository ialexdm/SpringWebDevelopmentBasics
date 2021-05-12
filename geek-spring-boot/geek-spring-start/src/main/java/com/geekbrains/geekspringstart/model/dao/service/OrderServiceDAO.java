package com.geekbrains.geekspringstart.model.dao.service;

import com.geekbrains.geekspringstart.model.entity.Customer;
import com.geekbrains.geekspringstart.model.entity.Order;
import com.geekbrains.geekspringstart.model.entity.Product;

import java.util.List;

public interface OrderServiceDAO {
    List<Order> getOrdersByProduct(long productId);

    List<Order> getOrdersByCustomer(long customerId);

    List<Product> getSellingProductsByCustomer(long customerId);

    List<Customer> getCustomersByProduct(long productId);
}
