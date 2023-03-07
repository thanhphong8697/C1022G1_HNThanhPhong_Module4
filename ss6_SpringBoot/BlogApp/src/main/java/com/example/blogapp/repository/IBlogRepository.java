package com.example.blogapp.repository;

import com.example.blogapp.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "SELECT * FROM Blog WHERE title LIKE  %:nameSearch%", nativeQuery = true)
    Page<Blog> searchName(@Param("nameSearch") String search, Pageable pageable);
}
