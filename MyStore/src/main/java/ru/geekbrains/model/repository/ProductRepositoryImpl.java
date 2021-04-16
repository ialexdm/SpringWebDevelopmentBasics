package ru.geekbrains.model.repository;

import org.springframework.stereotype.Component;
import ru.geekbrains.model.entity.Product;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Component
public class ProductRepositoryImpl implements ProductRepository {


    private final Map<Integer, Product> db = new HashMap<>();

    {
        Product egg = new Product();
        egg.setId(Product.count++);
        egg.setTitle("Egg");
        egg.setCost(10);
        db.put(egg.getId(),egg);
        Product milk = new Product();
        milk.setId(Product.count++);
        milk.setTitle("Milk");
        milk.setCost(10);
        db.put(milk.getId(),milk);
        Product meat = new Product();
        meat.setId(Product.count++);
        meat.setTitle("Meat");
        meat.setCost(10);
        db.put(meat.getId(),meat);
        Product bread = new Product();
        bread.setId(Product.count++);
        bread.setTitle("Bread");
        bread.setCost(10);
        db.put(bread.getId(),bread);
        Product apple = new Product();
        apple.setId(Product.count++);
        apple.setTitle("Apple");
        apple.setCost(10);
        db.put(apple.getId(),apple);
    }

    @Override
    public Product getProductById(int id){
        return db.get(id);
    }

    @Override
    public void printProducts() {
        Iterator<Map.Entry<Integer, Product>> iterator = db.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Product> productEntry = iterator.next();
            System.out.println(productEntry.getValue());
        }
    }
}
