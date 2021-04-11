package ru.geekbrains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Product {
    public static int count;
    public Product(){
        Random random = new Random(100);
        this.id = count++;
        this.title = "Product "+ id;
        this.cost = (double) Math.round(random.nextDouble()*100)/100;
    }
    public Product(String title){
        this.id = count++;
        this.title = title;
        Random random = new Random(100);
        this.cost = (double) Math.round(random.nextDouble()*100)/100;
    }

    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    private double cost;
}
