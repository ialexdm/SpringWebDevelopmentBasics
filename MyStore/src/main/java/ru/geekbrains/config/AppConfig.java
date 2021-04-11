package ru.geekbrains.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.geekbrains.Cart;
import ru.geekbrains.CartController;
import ru.geekbrains.Product;
import ru.geekbrains.ProductRepository;

@Configuration
@ComponentScan
public class AppConfig {

    @Bean(name = "product")
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Product product(){
        return new Product();
    }

    @Bean(name = "productRepository")
    public ProductRepository productRepository(){
        ProductRepository productRepository = new ProductRepository();
        productRepository.setProduct(new Product());
        productRepository.setProduct(new Product());
        productRepository.setProduct(new Product("Couch"));
        productRepository.setProduct(new Product("Chair"));
        productRepository.setProduct(new Product("Table"));
        productRepository.setProduct(new Product("Bed"));
        productRepository.setProduct(new Product("Rack"));
        return productRepository;
    }

    @Bean(name = "cart")
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Cart cart(){
        Cart cart = new Cart();
        ProductRepository productRepository = new ProductRepository();
        return cart;
    }

    @Bean(name = "cartController")
    public CartController cartController(){
        CartController cartController = new CartController();
        ProductRepository productRepository = new ProductRepository();
        Cart cart = new Cart();
        cartController.setCart(cart);
        cartController.setProductRepository(productRepository);
        return cartController;
    }


}
