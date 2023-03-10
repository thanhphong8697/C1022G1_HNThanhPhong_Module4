package com.example.codegym.service;

import com.example.codegym.dto.ProductDTO;
import com.example.codegym.dto.ProductImgDTO;

import java.util.List;

public interface IProductService {
    List<ProductDTO> listAll();

    List<ProductImgDTO> listImg();

    ProductDTO findById(int id);
}
