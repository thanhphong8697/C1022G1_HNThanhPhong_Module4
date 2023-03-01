package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    public static  List<Product> productList;
    static {
        productList = new ArrayList<Product>(){{
            add(new Product(1, "Iphone 14", 25000000, "64G", "Apple"));
            add(new Product(2, "Galaxy S11", 20000000, "32G", "Samsung"));
            add(new Product(3, "Iphone 13", 18000000, "16G", "Apple"));
        }};
    }
    @Override
    public List<Product> listProduct(String nameSearch) {
        if (nameSearch == null){
            return productList;
        }
        List<Product> products = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().contains(nameSearch)){
                products.add(product);
            }
        }
        return products;
    }

    @Override
    public void create(Product product) {

    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(int id) {

    }
}
