package ru.geekbrains;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {

    @Getter
    List<Product> productList;

    @Getter
    private final int LIST_START_QTY = 5;

    public ProductRepository(){
        productList = new ArrayList<>();
    }
    public void setProduct(Product product){
        productList.add(product);
    }

    public Product getProductById(int id){
        for (Product p:productList
             ) {
            if (p.getId().equals(id)){
                return p;
            }
        }
        return null;
    }
    public void printProducts(){
        for (Product p:productList
        ) {
            System.out.println(p.toString());
        }
    }
}
