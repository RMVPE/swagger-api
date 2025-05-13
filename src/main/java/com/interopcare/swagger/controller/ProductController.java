package com.interopcare.swagger.controller;

import com.interopcare.swagger.model.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Product Management", description = "Operations for product management")
public class ProductController {

    private final List<Product> products = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public ProductController() {
        // Initialize with sample data
        products.add(new Product(counter.incrementAndGet(), "Laptop", new BigDecimal(999.99), "High-performance laptop"));
        products.add(new Product(counter.incrementAndGet(), "Smartphone", new BigDecimal(699.99), "Latest model smartphone"));
    }

    @GetMapping
    @Operation(summary = "Get all products", description = "Returns a list of all products")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved products")
    public List<Product> getAllProducts() {
        return products;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get product by ID", description = "Returns a single product by its ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Successfully retrieved product"),
        @ApiResponse(responseCode = "404", description = "Product not found")
    })
    public Product getProductById(
            @Parameter(description = "Product ID", required = true, example = "1")
            @PathVariable Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    @Operation(summary = "Create a new product", description = "Creates and returns the new product")
    @ApiResponse(responseCode = "200", description = "Product created successfully")
    public Product createProduct(
            @Parameter(description = "Product object", required = true)
            @RequestBody @Valid Product product) {
        product.setId(counter.incrementAndGet());
        products.add(product);
        return product;
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a product", description = "Updates and returns the modified product")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Product updated successfully"),
        @ApiResponse(responseCode = "404", description = "Product not found")
    })
    public Product updateProduct(
            @Parameter(description = "Product ID", required = true, example = "1")
            @PathVariable Long id,
            @Parameter(description = "Updated product object", required = true)
            @RequestBody @Valid Product productDetails) {
        Product product = products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
        
        if (product != null) {
            product.setName(productDetails.getName());
            product.setPrice(productDetails.getPrice());
            product.setDescription(productDetails.getDescription());
        }
        
        return product;
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a product", description = "Deletes a product by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Product deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Product not found")
    })
    public String deleteProduct(
            @Parameter(description = "Product ID", required = true, example = "1")
            @PathVariable Long id) {
        products.removeIf(product -> product.getId().equals(id));
        return "Product with ID " + id + " deleted successfully";
    }
}