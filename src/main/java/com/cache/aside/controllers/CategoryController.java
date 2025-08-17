package com.cache.aside.controllers;

import com.cache.aside.dto.CategoryDTO;
import com.cache.aside.dto.CategoryForm;
import com.cache.aside.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.getCategoryById(id));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryDTO> updateProduct(@PathVariable Integer id, @RequestBody CategoryForm category){
        return ResponseEntity.ok(service.updateCategory(id, category));
    }
}
