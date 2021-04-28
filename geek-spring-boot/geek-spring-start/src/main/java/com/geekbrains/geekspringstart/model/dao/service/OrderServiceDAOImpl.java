package com.geekbrains.geekspringstart.model.dao.service;


import com.geekbrains.geekspringstart.model.entity.Customer;
import com.geekbrains.geekspringstart.model.entity.Order;
import com.geekbrains.geekspringstart.model.entity.Product;
import com.geekbrains.geekspringstart.model.dao.repository.CustomerRepository;
import com.geekbrains.geekspringstart.model.dao.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class OrderServiceDAOImpl implements OrderServiceDAO {
    private final CustomerRepository customerRepositoryImpl;
    private final ProductRepository productRepository;

    public OrderServiceDAOImpl(CustomerRepository customerRepositoryImpl, ProductRepository productRepository) {
        this.customerRepositoryImpl = customerRepositoryImpl;
        this.productRepository = productRepository;
    }

    @Override
    public List<Order> getOrdersByProduct(long productId){
        return productRepository.findById(productId).getOrderList();
    }
    @Override
    public List<Order> getOrdersByCustomer(long customerId){
        return customerRepositoryImpl.findById(customerId).getOrders();
    }
    @Override
    public List<Product> getSellingProductsByCustomer(long customerId){
        List<Order> orders = getOrdersByCustomer(customerId);
        HashSet<Product> products = new LinkedHashSet();
        for (Order o: orders)
        {
            products.addAll(o.getProducts());
        }
        return new LinkedList<Product>(products);
    }
    @Override
    public List<Customer> getCustomersByProduct(long productId){
        List<Order> orders = getOrdersByProduct(productId);
        HashSet<Customer> customers = new LinkedHashSet();
        for (Order o: orders)
        {
            customers.add(o.getCustomer());
        }
        return new LinkedList<Customer>(customers);
    }

}
