package com.geekbrains.geekspringstart.controllers;

import com.geekbrains.geekspringstart.model.entity.Product;
import com.geekbrains.geekspringstart.model.dao.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

//получение всех товаров [ GET .../app/products ]
    @GetMapping(value = "products")
    public String products(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("cards", generateProductList());
        return "products";
    }
    //получение товара по id [ GET .../app/products/{id} ]
    @GetMapping(value="products/{id}")
    public String product(Model model, @PathVariable(value = "id") String id) {
        System.out.println(id);
        Product product = productRepository.findById(Long.parseLong(id)).get();
        model.addAttribute("id", " #id:"+product.getId());
        model.addAttribute("title", product.getTitle());
        model.addAttribute("cost", product.getCost()+"RUB");
        return "id"; //TODO HTML Form
    }

//создание нового товара [ POST .../app/products ]
    @PostMapping(value ="products")
    public String create(Product product) {
        productRepository.save(product);
        return "redirect:products";
    }
    //удаление товара по id.[ GET .../app/products/delete/{id} ]удаление товара по id.[ GET .../app/products/delete/{id} ]
    @GetMapping(value = "products/delete/{id}")
    public String deleteProducts(Model model, @PathVariable(value = "id") String id) {
        productRepository.deleteById(Long.parseLong(id));
        return "redirect:/products";//TODO HTML form
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

    public String generateProductCard(Long id){
        ResourceBundle bundle = ResourceBundle.getBundle("patterns") ;
        String card = bundle.getString("card");
        StringBuilder cards = new StringBuilder();
        Product p = productRepository.findById(id).get();
        cards.append(MessageFormat.format(card,p.getTitle(), p.getId(), p.getCost()));
        return cards.toString();
    }

}
