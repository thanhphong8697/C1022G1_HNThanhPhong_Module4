package com.example.ss11_webservice.service;

import com.example.ss11_webservice.dto.BlogDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    Page<BlogDTO> listAll(Pageable pageable);

    BlogDTO findById(int id);
}
