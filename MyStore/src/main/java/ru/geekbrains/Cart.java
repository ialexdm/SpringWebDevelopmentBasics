package ru.geekbrains;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component("cart")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)

public class Cart {

    ProductRepository productRepository;

    List<Product> products;
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

    public void putProduct(int id){
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
            if (p.getId().equals(id)){
                products.remove(p);
            }
            else
                System.out.println("Неверный id!");
        }

    }


    public boolean isCartOpen() {
        return isCartOpen;
    }

    public void setCartOpen(boolean cartOpen) {
        isCartOpen = cartOpen;
    }
    public ProductRepository getProductRepository() {
        return productRepository;
    }
    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
