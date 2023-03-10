package com.example.codegym.service;

import com.example.codegym.dto.ProductDTO;
import com.example.codegym.dto.ProductImgDTO;
import com.example.codegym.model.Product;
import com.example.codegym.repository.IProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
    private IProductRepository iProductRepository;
    @Override
    public List<ProductDTO> listAll() {
        List<Product> productList = iProductRepository.findAll();
        List<ProductDTO> productDTOList = new ArrayList<>();
        ProductDTO productDTO;
        for (Product products : productList){
            productDTO = new ProductDTO();
            BeanUtils.copyProperties(products, productDTO);
        }
        return productDTOList;
    }

    @Override
    public List<ProductImgDTO> listImg() {
        List<Product> productList = iProductRepository.findAll();
        List<ProductImgDTO> productImgDTOList = new ArrayList<>();
        ProductImgDTO productImgDTO;
        for (Product products : productList){
            productImgDTO = new ProductImgDTO();
            BeanUtils.copyProperties(products, productImgDTO);
        }
        return productImgDTOList;
    }

    @Override
    public ProductDTO findById(int id) {
        ProductDTO productDTO =new ProductDTO();
        BeanUtils.copyProperties(iProductRepository.findById(id).get(), productDTO);
        return productDTO;
    }
}
