package com.example.food.service;

import com.example.food.Model.MenuModel;
import com.example.food.entity.MenuEntity;
import com.example.food.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    MenuRepository menuRepository;
    public MenuEntity addItemIntoMenu(MenuEntity menu)
    {
        return menuRepository.save(menu);
    }


    public List<MenuEntity> displayMenu() {
        return menuRepository.findAll();
    }
}
