package com.geekbrains.geekspringstart.model.dao.repository;

import com.geekbrains.geekspringstart.model.entity.Product;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;


import java.util.*;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final Session entityManager;

    public ProductRepositoryImpl(Session entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public Product saveOrUpdate(Product newProduct){
        List<Product> productList;
        productList = findAll();
        Product product = null;
        for (Product p:productList
             ) {
            if (p.getTitle().equals(newProduct.getTitle())){
                product = p;
            }
        }
        if (product!=null){
            return update(product, newProduct.getCost());
        }


        return save(newProduct);
    }
    private Product update(Product product,int newCost){
        product.setCost(newCost);
        entityManager.getTransaction().begin();
        entityManager.merge(product);
        entityManager.getTransaction().commit();
        return product;
    }

    private Product save(Product product){
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
        return product;
    }

    @Override
    public Product findById(long id){
        return entityManager
                .createNamedQuery(
                        "Product.findById", Product.class)
                .setParameter("id", id)
                .getSingleResult();
    }
    @Override
    public Product findByTitle(String title){
        return entityManager
                .createNamedQuery(
                        "Product.findByTitle", Product.class)
                .setParameter("title", title)
                .getSingleResult();
    }

    @Override
    public List<Product> findAll() {
        return entityManager.createNamedQuery("Product.findAll", Product.class).getResultList();
    }

    @Override
    public void deleteById(Long id) {
        entityManager
                .createNamedQuery("Product.deleteById", Product.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
