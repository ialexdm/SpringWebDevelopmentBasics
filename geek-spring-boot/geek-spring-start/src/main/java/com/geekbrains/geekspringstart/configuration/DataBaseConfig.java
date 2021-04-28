package com.geekbrains.geekspringstart.configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class DataBaseConfig {

    @Bean
    public Session entityManager(){
        SessionFactory sessionFactory =  new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        return (Session) sessionFactory.createEntityManager();
    }
}
