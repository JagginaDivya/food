package com.example.food.Mapper;

import com.example.food.Model.MenuModel;
import com.example.food.entity.MenuEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MenuMapper {
    MenuMapper menuMapper = Mappers.getMapper(MenuMapper.class);

    MenuModel convertEntityToModel(MenuEntity menuEntity);
}
