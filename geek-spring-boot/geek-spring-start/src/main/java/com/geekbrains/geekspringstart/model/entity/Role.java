package com.geekbrains.geekspringstart.model.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


public enum Role{
    ROLE_USER,ROLE_ADMIN;

}