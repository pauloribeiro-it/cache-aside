package com.cache.aside.services;

import com.cache.aside.dto.CategoryDTO;
import com.cache.aside.dto.CategoryForm;
import com.cache.aside.entities.Category;
import com.cache.aside.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@CacheConfig(cacheNames = "categories")
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    @Cacheable(cacheNames = "categories", key = "#id")
    public CategoryDTO getCategoryById(Integer id) {
        return this.repository.findById(id).map(c -> CategoryDTO.builder()
                        .id(c.getId())
                        .description(c.getDescription())
                        .build())
                .orElseThrow(() -> new IllegalArgumentException("Id " + id + " not found."));
    }

    @CachePut(cacheNames = "categories", key = "#id")
    public CategoryDTO updateCategory(Integer id, CategoryForm categoryForm) {
        Optional<Category> categoryOpt = this.repository.findById(id);
        if (categoryOpt.isPresent()) {
            Category category = categoryOpt.get();
            category.setDescription(categoryForm.getDescription());
            this.repository.save(category);
            return CategoryDTO.builder().id(category.getId()).description(category.getDescription()).build();
        }
        throw new IllegalArgumentException("Id " + id + " not found.");
    }

}
