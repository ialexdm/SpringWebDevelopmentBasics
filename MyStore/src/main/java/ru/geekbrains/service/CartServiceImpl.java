package ru.geekbrains.service;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;


@Service
public class CartServiceImpl implements CartService {

    @Lookup
    @Override
    public Cart getNewCart(){
        return null;
    }
}
