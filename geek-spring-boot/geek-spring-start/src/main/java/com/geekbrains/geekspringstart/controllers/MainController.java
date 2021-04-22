package com.geekbrains.geekspringstart.controllers;

import com.geekbrains.geekspringstart.model.entity.Product;
import com.geekbrains.geekspringstart.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.MessageFormat;
import java.util.ResourceBundle;

@Controller
@RequestMapping("/")
public class MainController {

    private final ProductRepository productRepository;

    @Autowired
    public MainController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @GetMapping(value = "index")
        public String index(Model model) {
            model.addAttribute("message", "Hello World");
            return "index";
        }

    @GetMapping(value = "products")
    public String products(Model model) {
        model.addAttribute("cards", generateProductList());
        return "products";
    }


    @GetMapping(value ="add")
    public String add(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "add";
    }

    @PostMapping(value ="add")
    public String create(Product product) {
        productRepository.saveOrUpdate(product);
        return "redirect:add";
    }


    public String generateProductList(){

        ResourceBundle bundle = ResourceBundle.getBundle("patterns") ;
        String card = bundle.getString("card");
        StringBuilder cards = new StringBuilder();
        for (Product p: productRepository.findAll())
        {
            cards.append(MessageFormat.format(card,p.getTitle(), p.getId(), p.getCost()));
        }
        return cards.toString();
    }

}
