package com.example.book_app.modelDTO;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
