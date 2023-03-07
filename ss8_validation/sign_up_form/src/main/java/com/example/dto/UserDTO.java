package com.example.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDTO implements Validator {
    @NotBlank(message = "Can not blank or space")
    @Size(min = 5, max = 45)
    private String firstName;
    @NotBlank(message = "Can not blank or space")
    @Size(min = 5, max = 45)
    private String lastName;
    @NotBlank(message = "Can not blank or space")
    private String phoneNumber;
    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[\\d]{7}$")
    @NotBlank(message = "Can not blank or space")
    @Min(value = 18)
    private String age;
    @NotBlank(message = "Can not blank or space")
    @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")
    private String email;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
