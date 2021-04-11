package ru.geekbrains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.config.AppConfig;

public class MyStoreApp {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CartController cartController = context.getBean("cartController", CartController.class);
        cartController.start();


    }
}
