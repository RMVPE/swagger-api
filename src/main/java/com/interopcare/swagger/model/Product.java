package com.interopcare.swagger.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive; 

@Schema(description = "Product information")
public class Product {
    @Schema(description = "Unique identifier of the product", example = "1")
    private Long id;
    
    @Schema(
        description = "Name of the product", 
        requiredMode = RequiredMode.REQUIRED, 
        example = "Laptop"
    )
    @NotBlank(message = "Product name cannot be empty")
    @Size(min = 2, max = 100, message = "Name must be 2-100 characters")


    private String name;
    
    @Schema(
        description = "Price in USD", 
        requiredMode = RequiredMode.REQUIRED,
        example = "999.99"
    )
    @Positive(message = "Price must be positive")
    @DecimalMin(value = "0.01", message = "Price must be ≥ $0.01")

    private BigDecimal price;
    
    @Schema(description = "Product description", example = "High-performance laptop")
    private String description;

    // Constructors, getters, and setters remain the same
    public Product() {}
    
    public Product(Long id, String name, BigDecimal price, String description) {
        this.id = id;
        this.name = name;
        this.price = price.setScale(2, RoundingMode.HALF_UP);
        this.description = description;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public @Positive(message = "Price must be positive") @DecimalMin(value = "0.01", message = "Price must be ≥ $0.01") BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price.setScale(2, RoundingMode.HALF_UP);; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}