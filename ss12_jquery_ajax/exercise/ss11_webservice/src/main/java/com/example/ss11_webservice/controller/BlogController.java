package com.example.ss11_webservice.controller;

import com.example.ss11_webservice.dto.BlogDTO;
import com.example.ss11_webservice.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog")
@CrossOrigin("*")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Page<BlogDTO> blogDTOPage(@PageableDefault(size = 3)Pageable pageable){
        return iBlogService.listAll(pageable);
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/detail/{id}")
    public BlogDTO blogDetail(@PathVariable int id){
        return iBlogService.findById(id);
    }
}
