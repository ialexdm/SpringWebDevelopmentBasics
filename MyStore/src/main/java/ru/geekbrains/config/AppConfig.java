package ru.geekbrains.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.geekbrains.Product;
import ru.geekbrains.ProductRepository;

@Configuration
@ComponentScan
public class AppConfig {

    @Bean(name = "product")
    public Product product(){
        return new Product();
    }

    @Bean(name = "productRepository")
    public ProductRepository productRepository(){
        ProductRepository productRepository = new ProductRepository();
        productRepository.setProduct(new Product("Couch"));
        productRepository.setProduct(new Product("Chair"));
        productRepository.setProduct(new Product("Table"));
        productRepository.setProduct(new Product("Bed"));
        productRepository.setProduct(new Product("Rack"));
        return productRepository;
    }


}
