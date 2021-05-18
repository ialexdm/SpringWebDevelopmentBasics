package com.geekbrains.geekspringstart.controllers;


import com.geekbrains.geekspringstart.model.dao.service.Cart;
import com.geekbrains.geekspringstart.model.entity.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/api/v1/cart")
@RestController
public class CartRestController {
    private final Cart cart;

    public CartRestController(Cart cart) {
        this.cart = cart;
    }

    @GetMapping
    public Map<Product, Integer> content() {
        return cart.getContent();
    }

    @DeleteMapping("{id}")
    public int deleteProduct(@PathVariable Long id) {
        cart.deleteProduct(id);
        return HttpStatus.OK.value();
    }

    @PostMapping()
    public Map<Product, Integer> addProduct(@RequestBody Long id) {
        return cart.addProduct(id);
    }
}
