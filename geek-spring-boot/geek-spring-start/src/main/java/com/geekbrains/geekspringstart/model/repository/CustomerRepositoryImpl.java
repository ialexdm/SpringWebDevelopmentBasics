package com.geekbrains.geekspringstart.model.repository;

import com.geekbrains.geekspringstart.model.entity.Customer;
import com.geekbrains.geekspringstart.model.entity.Product;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{

    private final Session entityManager;

    public CustomerRepositoryImpl(Session entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Customer findById(long id){
        return entityManager
                .createNamedQuery(
                        "Customer.findById", Customer.class)
                .setParameter("id", id)
                .getSingleResult();
    }
    public List<Customer> findAll(){
        return entityManager.createNamedQuery("Customer.findAll", Customer.class).getResultList();
    }
    public void save(Customer customer){
        entityManager.beginTransaction();
        entityManager.saveOrUpdate(customer);
        entityManager.getTransaction().commit();
    }
}
