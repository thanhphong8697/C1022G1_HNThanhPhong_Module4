package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> listProduct(String nameSearch);

    void create(Product product);

    Product findById(int id);

    void update(Product product);

    void delete(int id);
}
