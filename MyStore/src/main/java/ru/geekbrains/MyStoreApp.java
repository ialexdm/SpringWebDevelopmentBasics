package ru.geekbrains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import ru.geekbrains.config.AppConfig;

import ru.geekbrains.manager.StoreManager;

import javax.annotation.PostConstruct;


@Component
public class MyStoreApp {
   private final StoreManager storeManager;

    public MyStoreApp(StoreManager storeManager) {
        this.storeManager = storeManager;
    }

    @PostConstruct
    public void start(){
        storeManager.start();
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    }
}
