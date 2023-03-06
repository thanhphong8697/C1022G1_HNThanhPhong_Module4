package com.example.blogapp.service;

import com.example.blogapp.model.Blog;
import com.example.blogapp.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> listAll();
}
