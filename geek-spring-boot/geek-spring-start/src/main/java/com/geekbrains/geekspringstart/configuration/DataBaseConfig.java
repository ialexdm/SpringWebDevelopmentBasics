package com.geekbrains.geekspringstart.configuration;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class DataBaseConfig {

    @Bean
    public EntityManager entityManager(){
        SessionFactory sessionFactory =  new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        return sessionFactory.createEntityManager();
    }
}
