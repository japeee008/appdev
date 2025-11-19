package com.appdev.altf4.seloteriog5.service;

import com.appdev.altf4.seloteriog5.entity.Category;
import com.appdev.altf4.seloteriog5.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // CREATE
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    // READ ALL
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // READ ONE
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id " + id));
    }

    // UPDATE
    public Category updateCategory(Long id, Category updatedCategory) {
        Category existing = getCategoryById(id);

        if (updatedCategory.getCategoryName() != null) {
            existing.setCategoryName(updatedCategory.getCategoryName());
        }
        if (updatedCategory.getDescription() != null) {
            existing.setDescription(updatedCategory.getDescription());
        }
        // updatedAt is handled by @PreUpdate in the entity
        return categoryRepository.save(existing);
    }

    // DELETE
    public void deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("Category not found with id " + id);
        }
        categoryRepository.deleteById(id);
    }
}
