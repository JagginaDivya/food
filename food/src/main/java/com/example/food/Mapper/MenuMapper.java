package com.example.food.Mapper;

import com.example.food.Model.MenuModel;
import com.example.food.entity.MenuEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MenuMapper {

     //void toModel(MenuEntity menuEntity, @MappingTarget MenuModel menuModel);

     MenuModel toModel(MenuEntity menuEntity);
}
