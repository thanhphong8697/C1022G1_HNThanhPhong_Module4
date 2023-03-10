package com.example.book_app.modelDTO;

import com.example.book_app.exception.WrongCodeException;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
public class BookDTO implements Validator {
    private Integer id;
    @NotBlank
    private String title;
    @NotBlank
    private Integer quantity;
    @NotBlank
    private Integer price;
    @NotBlank
    private String code;

    public BookDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String borrow(){
        this.quantity = quantity - 1;
        this.code = Math.floor(Math.random() * (99999 - 10000 + 1) + 10000) + "";
        return this.code;
    }
    public void giveBack(String code) throws WrongCodeException {
        if (this.code.equals(code)){
            this.quantity = quantity +1;
        }else {
            throw new WrongCodeException();
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
