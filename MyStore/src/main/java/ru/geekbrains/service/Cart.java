package ru.geekbrains.service;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.geekbrains.model.entity.Product;
import ru.geekbrains.model.repository.ProductRepository;


import java.util.LinkedList;
import java.util.List;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Cart {

    final private List<Product> PRODUCTS = new LinkedList<>();
    private boolean isCartOpen = true;


    public void printCart(){
        if (PRODUCTS.isEmpty()){
            System.out.println("Ваша корзина пуста!");
            return;
        }
        for (Product p: PRODUCTS
             ) {
            System.out.println(p.toString());
        }
    }
    public Product getProductById(int id){
        for (Product p: PRODUCTS
        ) {
            if (p.getId()==id){
                return p;
            }
        }
        return null;
    }

    public void putProduct(ProductRepository productRepository, int id){
        Product product = productRepository.getProductById(id);
        if (product!=null){
            PRODUCTS.add(product);
        }
        else {
            System.out.println("Неверный id!");
        }
    }
    public void removeProduct(int id){
        for (Product p: PRODUCTS
             ) {
            if (p.getId()==id){
                PRODUCTS.remove(p);
            }
            else
                System.out.println("Неверный id!");
        }

    }

}
