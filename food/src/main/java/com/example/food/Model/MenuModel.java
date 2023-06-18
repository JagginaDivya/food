package com.example.food.Model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class MenuModel {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("price")
    private double price;

    @JsonProperty("availability")
    private boolean availability;

    @JsonProperty("category")
    private String category;

    @JsonProperty("ingredients")
    private String ingredients;

    @JsonProperty("image")
    private String image;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("updated_at")
    private Date updatedAt;

    // Constructors, Getters, and Setters
    // ...
}
