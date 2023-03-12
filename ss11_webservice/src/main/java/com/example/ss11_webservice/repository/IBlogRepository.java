package com.example.ss11_webservice.repository;

import com.example.ss11_webservice.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
}
