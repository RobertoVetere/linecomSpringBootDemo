package com.holidevs.demoSpring.dto;

import java.time.LocalDate;
import java.util.Date;
public class ProductDto {

    private final Long id;
    private String name;
    private String description;
    private Double stock;
    private Double price;
    private String status;
    private final LocalDate createAtDto;

    public ProductDto(Long id, String name, String description, Double stock, Double price, String status, LocalDate createAtDto) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.status = status;
        this.createAtDto = createAtDto;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getStock() {
        return stock;
    }

    public void setStock(Double stock) {
        this.stock = stock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getCreateAtDto() {
        return createAtDto;
    }
}
