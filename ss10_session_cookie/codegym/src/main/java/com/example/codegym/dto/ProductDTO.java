package com.example.codegym.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class ProductDTO {
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private double price;
    @NotBlank
    private String imgURL;

    public ProductDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
}
