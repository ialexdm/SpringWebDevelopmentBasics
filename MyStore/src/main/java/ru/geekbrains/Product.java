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
        double random = Math.round(Math.random()*10000);
        this.id = count++;
        this.title = "Product "+ id;
        this.cost = (double) random/100;
    }
    public Product(String title){
        this.id = count++;
        this.title = title;
        double random = Math.round(Math.random()*10000);
        this.cost = (double) random/100;
    }

    private Integer id;

    private String title;

    private double cost;

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Product.count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                '}';
    }
}
