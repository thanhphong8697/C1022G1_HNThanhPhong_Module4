package com.example.ss11_webservice.controller;

import com.example.ss11_webservice.dto.CategoryDTO;
import com.example.ss11_webservice.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Page<CategoryDTO> categoryDTOPage(Pageable pageable){
        return iCategoryService.listAll(pageable);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO categoryDetail(@PathVariable int id){
        return iCategoryService.findById(id);
    }
}
