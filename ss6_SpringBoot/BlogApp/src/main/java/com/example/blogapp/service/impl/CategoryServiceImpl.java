package com.example.blogapp.service.impl;

import com.example.blogapp.model.Category;
import com.example.blogapp.repository.IBlogRepository;
import com.example.blogapp.repository.ICategoryRepository;
import com.example.blogapp.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> listAll() {
        return iCategoryRepository.findAll();
    }
}
