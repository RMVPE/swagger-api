package com.interopcare.swagger.model;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

@Schema(description = "Product information")
public class Product {
    @Schema(description = "Unique identifier of the product", example = "1")
    private Long id;
    
    @Schema(
        description = "Name of the product", 
        requiredMode = RequiredMode.REQUIRED, 
        example = "Laptop"
    )
    private String name;
    
    @Schema(description = "Price of the product", example = "999.99")
    private Double price;
    
    @Schema(description = "Product description", example = "High-performance laptop")
    private String description;

    // Constructors, getters, and setters remain the same
    public Product() {}
    
    public Product(Long id, String name, Double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}