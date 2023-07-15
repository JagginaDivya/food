package com.example.food.controller;

import com.example.food.Mapper.MenuMapper;
import com.example.food.Model.MenuModel;
import com.example.food.entity.MenuEntity;
import com.example.food.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/food")
public class MenuController {
    @Autowired
    MenuService menuService;

    @Autowired
    private MenuMapper menuMapper;

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
                .map(menuMapper::toModel)
                .collect(Collectors.toList());

    }
}
