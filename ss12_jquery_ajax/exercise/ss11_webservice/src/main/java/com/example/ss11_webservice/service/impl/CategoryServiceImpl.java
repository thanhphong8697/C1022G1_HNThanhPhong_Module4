package com.example.ss11_webservice.service.impl;

import com.example.ss11_webservice.dto.BlogDTO;
import com.example.ss11_webservice.dto.CategoryDTO;
import com.example.ss11_webservice.model.Blog;
import com.example.ss11_webservice.model.Category;
import com.example.ss11_webservice.repository.ICategoryRepository;
import com.example.ss11_webservice.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    public ICategoryRepository iCategoryRepository;
    public void setValueOfBlogDTO(Category category, CategoryDTO categoryDTO){
        Set<Blog> blogSet = category.getBlogSet();
        Set<BlogDTO> blogDTOSet = new HashSet<>();
        BlogDTO blogDTO;
        for (Blog blog : blogSet){
            blogDTO = new BlogDTO();
            BeanUtils.copyProperties(category, categoryDTO);
            blogDTOSet.add(blogDTO);
        }
        BeanUtils.copyProperties(category, categoryDTO);
        categoryDTO.setBlogDTOSet(blogDTOSet);
    }
    @Override
    public Page<CategoryDTO> listAll(Pageable pageable) {
        Page<Category> categoryPage = iCategoryRepository.findAll(pageable);
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        CategoryDTO categoryDTO;
        for (Category category : categoryPage){
            categoryDTO = new CategoryDTO();
            setValueOfBlogDTO(category, categoryDTO);
            BeanUtils.copyProperties(category, categoryDTO);
            categoryDTOList.add(categoryDTO);
        }
        return new PageImpl<>(categoryDTOList);
    }

    @Override
    public CategoryDTO findById(int id) {
        CategoryDTO categoryDTO = new CategoryDTO();
        Category category = iCategoryRepository.findById(id).get();
        setValueOfBlogDTO(category,categoryDTO);
        return categoryDTO;
    }
}
