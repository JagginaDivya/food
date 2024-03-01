package com.example.food.controller;

import static org.mockito.Mockito.when;

import com.example.food.Mapper.MenuMapper;
import com.example.food.entity.MenuEntity;
import com.example.food.service.MenuService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {MenuController.class})
@ExtendWith(SpringExtension.class)
class MenuControllerTest {
    @Autowired
    private MenuController menuController;

    @MockBean
    private MenuMapper menuMapper;

    @MockBean
    private MenuService menuService;

    /**
     * Method under test: {@link MenuController#addItemIntoMenu(MenuEntity)}
     */
    @Test
    void testAddItemIntoMenu() throws Exception {
        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setAvailability(true);
        menuEntity.setCategory("Category");
        menuEntity.setCreatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        menuEntity.setDescription("The characteristics of someone or something");
        menuEntity.setId(1L);
        menuEntity.setImage("Image");
        menuEntity.setIngredients("Ingredients");
        menuEntity.setName("Name");
        menuEntity.setPrice(10.0d);
        menuEntity.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        when(menuService.addItemIntoMenu(Mockito.<MenuEntity>any())).thenReturn(menuEntity);

        MenuEntity menuEntity2 = new MenuEntity();
        menuEntity2.setAvailability(true);
        menuEntity2.setCategory("Category");
        menuEntity2.setCreatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        menuEntity2.setDescription("The characteristics of someone or something");
        menuEntity2.setId(1L);
        menuEntity2.setImage("Image");
        menuEntity2.setIngredients("Ingredients");
        menuEntity2.setName("Name");
        menuEntity2.setPrice(10.0d);
        menuEntity2.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        String content = (new ObjectMapper()).writeValueAsString(menuEntity2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/food/addMenu/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(menuController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"name\":\"Name\",\"description\":\"The characteristics of someone or something\",\"price\":10.0,"
                                        + "\"availability\":true,\"category\":\"Category\",\"ingredients\":\"Ingredients\",\"image\":\"Image\",\"createdAt\":0"
                                        + ",\"updatedAt\":0}"));
    }

    /**
     * Method under test: {@link MenuController#displayMenu()}
     */
    @Test
    void testDisplayMenu() throws Exception {
        when(menuService.displayMenu()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/food/displayMenu/");
        MockMvcBuilders.standaloneSetup(menuController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link MenuController#displayMenu()}
     */
    @Test
    void testDisplayMenu2() throws Exception {
        when(menuService.displayMenu()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/food/displayMenu/");
        requestBuilder.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(menuController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

