package com.geekbrains.geekspringstart.controllers;

import com.geekbrains.geekspringstart.model.dao.repository.UserRepository;
import com.geekbrains.geekspringstart.model.entity.Product;
import com.geekbrains.geekspringstart.model.dao.repository.ProductRepository;
import com.geekbrains.geekspringstart.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class MainController {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @GetMapping
    public String greeting(Map<String, Object> model){
        return "home";
    }

    @GetMapping(value = "/index")
        public String index(Model model) {
            model.addAttribute("message", "Hello World");
            return "index";
        }

    @GetMapping(value = "products")
    public String products(Model model) {

        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }
    @Secured({"ROLE_ADMIN"})
    @GetMapping(value = "users")
    public String users(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }

    @GetMapping(value="products/{id}")
    public String product(Model model, @PathVariable(value = "id") String id) {
        System.out.println(id);
        Product product = productRepository.findById(Long.parseLong(id)).get();
        model.addAttribute("id", " #id:"+product.getId());
        model.addAttribute("title", product.getTitle());
        model.addAttribute("cost", product.getCost()+"RUB");
        return "id";
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping(value ="products")
    public String create(Product product) {
        productRepository.save(product);
        return "redirect:products";
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping(value = "products/delete/{id}")
    public String deleteProducts(Model model, @PathVariable(value = "id") String id) {
        productRepository.deleteById(Long.parseLong(id));
        return "redirect:/products";
    }
    @GetMapping("/login")
    public String showMyLoginPage() {
        return "login";
    }


}
