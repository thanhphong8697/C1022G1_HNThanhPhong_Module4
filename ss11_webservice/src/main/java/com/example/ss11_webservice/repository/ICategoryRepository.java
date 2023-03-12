package com.example.ss11_webservice.repository;

import com.example.ss11_webservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
