package com.example.codegym.model;

import com.example.codegym.dto.ProductDTO;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
    private Map<ProductDTO, Integer> productDTOIntegerMap = new LinkedHashMap<>();

    public Cart() {
    }

    public Map<ProductDTO, Integer> getProductDTOIntegerMap() {
        return productDTOIntegerMap;
    }

    public void setProductDTOIntegerMap(Map<ProductDTO, Integer> productDTOIntegerMap) {
        this.productDTOIntegerMap = productDTOIntegerMap;
    }

    private boolean checkItemInCart(ProductDTO productDTO){
        for (Map.Entry<ProductDTO, Integer> emtry : productDTOIntegerMap.entrySet()){
            if (emtry.getKey().getId().equals(productDTO.getId())){
                return true;
            }
        }
        return false;
    }
    private Map.Entry<ProductDTO, Integer> selectItemInCart (ProductDTO productDTO){
        for (Map.Entry<ProductDTO, Integer> emtry : productDTOIntegerMap.entrySet()){
            if (emtry.getKey().getId().equals(productDTO.getId())){
                return emtry;
            }
        }
        return null;
    }
    public void addProduct(ProductDTO productDTO){
        if (!checkItemInCart(productDTO)){
            productDTOIntegerMap.put(productDTO,1);
        }else {
            Map.Entry<ProductDTO, Integer> itemEntry = selectItemInCart(productDTO);
            Integer newQuantity = itemEntry.getValue() + 1;
            productDTOIntegerMap.replace(itemEntry.getKey(), newQuantity);
        }
    }
    public void deleteProduct(ProductDTO productDTO){
        if (!checkItemInCart(productDTO)){
            productDTOIntegerMap.put(productDTO, 1);
        }else {
            if (productDTOIntegerMap.get(productDTO) == 0){
                productDTOIntegerMap.remove(productDTO);
            }else {
                Map.Entry<ProductDTO, Integer> itemEntry = selectItemInCart(productDTO);
                Integer newQuantity = itemEntry.getValue() - 1;
                productDTOIntegerMap.replace(itemEntry.getKey(), newQuantity);
            }
        }
    }
    public Integer countProductQuantity(){
        Integer productQuantity = 0;
        for (Map.Entry<ProductDTO, Integer> entry : productDTOIntegerMap.entrySet()){
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }
    public Integer countItemQuantity(){
        return productDTOIntegerMap.size();
    }
    public Float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<ProductDTO, Integer> entry : productDTOIntegerMap.entrySet()){
            payment += entry.getKey().getPrice() * entry.getValue();
        }
        return payment;
    }
}
