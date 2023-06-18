package com.example.food.controller;

import com.example.food.Mapper.MenuMapper;
import com.example.food.Model.MenuModel;
import com.example.food.entity.MenuEntity;
import com.example.food.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MenuController {
    @Autowired
    MenuService menuService;

    @PostMapping("/addMenu/")
    public MenuEntity addItemIntoMenu(@RequestBody MenuEntity menu)
    {
        return menuService.addItemIntoMenu(menu);
    }

    @GetMapping("/displayMenu/")
    public List<MenuModel> displayMenu()
    {
        List<MenuEntity> resultInEntityList = menuService.displayMenu();
        return resultInEntityList.stream()
                .map(MenuMapper.menuMapper::convertEntityToModel)
                .collect(Collectors.toList());

    }
}
