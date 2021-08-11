package com.suk.market.controller;

import com.suk.market.domain.Category;
import com.suk.market.dto.CategoryDTO;
import com.suk.market.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public Iterable<Category> findAllCategory(){
        return categoryService.findAllCategory();
    }

    @GetMapping("/{id}")
    public Optional<Category> findCategoryById(@PathVariable("id") long id){
        return categoryService.findCategoryById(id);
    }

    @PostMapping
    public void save(@RequestBody CategoryDTO categoryDTO){
        Category category = new Category();
        category.setCategoryName(categoryDTO.getCategoryName());
        categoryService.save(category);
    }

    @PutMapping
    public void updateCategory(@RequestBody CategoryDTO categoryDTO){
        Category category = new Category();
        category.setCategoryName(categoryDTO.getCategoryName());
        categoryService.save(category);
    }
    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable("id") long id){
        categoryService.deleteCategoryById(id);
    }
}
