package com.geekbrains.geekspringstart.controllers;

import com.geekbrains.geekspringstart.model.dao.repository.ProductRepository;
import com.geekbrains.geekspringstart.model.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/products")
@RestController
public class ProductRestController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductRestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping
    public Product addProduct(@RequestBody Product product) {

        return productRepository.save(product);
    }

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/{id}")
    public int deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return HttpStatus.OK.value();
    }
}
