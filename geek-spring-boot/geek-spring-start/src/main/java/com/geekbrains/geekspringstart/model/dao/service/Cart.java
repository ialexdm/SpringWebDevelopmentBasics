package com.geekbrains.geekspringstart.model.dao.service;


import com.geekbrains.geekspringstart.model.dao.repository.ProductRepository;
import com.geekbrains.geekspringstart.model.entity.Product;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION,
proxyMode = ScopedProxyMode.TARGET_CLASS)
@Getter
public class Cart {
    private static final AtomicInteger COUNTER = new AtomicInteger(0);
    private final int cartID = COUNTER.incrementAndGet();
    public final Map<Product, Integer> content = new HashMap<>();
    private final ProductRepository productRepository;

    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Map<Product, Integer> addProduct(Long id){
        Product product = productRepository.getOne(id);
        for (Product p: content.keySet()
             ) {
            if (p.getId() == id) {
                content.replace(p, content.get(p) + 1);
                return content;
            }
        }
        content.put(product, 1);
        return content;
    }
    public Map<Product, Integer> deleteProduct(Long id){
        for (Product p: content.keySet()
        ) {
            if (p.getId() == id) {
                content.replace(p,content.get(p) -1);
                if (content.get(p)==0){
                    content.remove(p);
                }
                return content;
            }

        }
        return content;
    }
}
