package com.appdev.altf4.seloteriog5.controller;

import com.appdev.altf4.seloteriog5.entity.Category;
import com.appdev.altf4.seloteriog5.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "http://localhost:8080") // change port to your React dev port
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // CREATE
    @PostMapping
    public Category addCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    // READ ALL
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Category getCategory(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category category) {
        return categoryService.updateCategory(id, category);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
