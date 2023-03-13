package com.example.ss11_webservice.service;

import com.example.ss11_webservice.dto.BlogDTO;
import com.example.ss11_webservice.dto.CategoryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService {
    Page<CategoryDTO> listAll(Pageable pageable);

    CategoryDTO findById(int id);
}
