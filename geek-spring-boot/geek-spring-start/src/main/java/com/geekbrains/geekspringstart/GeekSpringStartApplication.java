package com.geekbrains.geekspringstart;
import com.geekbrains.geekspringstart.model.dao.repository.CustomerRepository;
import com.geekbrains.geekspringstart.model.dao.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication()

public class GeekSpringStartApplication {
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    public GeekSpringStartApplication(ProductRepository productRepository, CustomerRepository customerRepository) {
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(GeekSpringStartApplication.class, args);
    }
}
