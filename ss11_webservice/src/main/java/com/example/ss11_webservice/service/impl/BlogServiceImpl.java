package com.example.ss11_webservice.service.impl;

import com.example.ss11_webservice.dto.BlogDTO;
import com.example.ss11_webservice.dto.CategoryDTO;
import com.example.ss11_webservice.model.Blog;
import com.example.ss11_webservice.repository.IBlogRepository;
import com.example.ss11_webservice.service.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Page<BlogDTO> listAll(Pageable pageable) {
        Page<Blog> blogPage = iBlogRepository.findAll(pageable);
        List<BlogDTO> blogDTOList = new ArrayList<>();
        BlogDTO blogDTO;
        for (Blog blog : blogPage){
            blogDTO = new BlogDTO();
            blogDTO.setCategoryDTO(new CategoryDTO());
            BeanUtils.copyProperties(blog.getCategory(), blogDTO);
            BeanUtils.copyProperties(blog, blogDTO);
            blogDTOList.add(blogDTO);
        }
        return new PageImpl<>(blogDTOList);
    }

    @Override
    public BlogDTO findById(int id) {
        BlogDTO blogDTO = new BlogDTO();
        Blog blog = iBlogRepository.findById(id).get();
        blogDTO.setCategoryDTO(new CategoryDTO());
        BeanUtils.copyProperties(blog.getCategory(), blogDTO.getCategoryDTO());
        BeanUtils.copyProperties(blog, blogDTO);
        return blogDTO;
    }
}
