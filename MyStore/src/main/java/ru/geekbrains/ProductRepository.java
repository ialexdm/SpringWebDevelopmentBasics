package ru.geekbrains;

import lombok.Getter;
import java.util.List;

public class ProductRepository {

    @Getter
    List<Product> productList;

    public Product getProductById(int id){
        for (Product p:productList
             ) {
            if (p.getId().equals(id)){
                return p;
            }
        }
        return null;
    }
}
