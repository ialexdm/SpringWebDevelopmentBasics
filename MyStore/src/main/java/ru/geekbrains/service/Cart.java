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

    private List<Product> products;
    private boolean isCartOpen = true;

    public Cart(){
        products = new LinkedList<>();
    }

    public void printCart(){
        if (products.isEmpty()){
            System.out.println("Ваша корзина пуста!");
            return;
        }
        for (Product p: products
             ) {
            System.out.println(p.toString());
        }
    }
    public Product getProductById(int id){
        for (Product p:products
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
            products.add(product);
        }
        else {
            System.out.println("Неверный id!");
        }
    }
    public void removeProduct(int id){
        for (Product p:products
             ) {
            if (p.getId()==id){
                products.remove(p);
            }
            else
                System.out.println("Неверный id!");
        }

    }

}
