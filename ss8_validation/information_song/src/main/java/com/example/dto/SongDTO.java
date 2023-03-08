package com.example.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDTO implements Validator {
    private Integer id;
    @NotBlank(message = "can not be blank or space")
    @Size(max = 800, message = "Do not enter more than 800 characters")
    @Pattern(regexp = "[a-zA-Z0-9]*",  message = "Do not enter more than 800 characters")
    private String name;
    @NotBlank(message = "can not be blank or space")
    @Size(max = 300, message = "Do not enter more than 300 characters")
    @Pattern(regexp = "[a-zA-Z0-9]*",  message = "Do not enter more than 800 characters")
    private String singer;
    @NotBlank(message = "can not be blank or space")
    @Size(max = 1000, message = "Do not enter more than 1000 characters")
    @Pattern(regexp = "[a-zA-Z0-9]*",  message = "Do not enter more than 800 characters")
    private String type;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
