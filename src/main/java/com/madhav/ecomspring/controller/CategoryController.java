package com.madhav.ecomspring.controller;

import com.madhav.ecomspring.dto.request.CategoryRequestDTO;
import com.madhav.ecomspring.dto.response.CategoryResponseDTO;
import com.madhav.ecomspring.dto.response.CategoryWithProductsResponseDTO;
import com.madhav.ecomspring.entity.Category;
import com.madhav.ecomspring.mapper.CategoryMapper;
import com.madhav.ecomspring.service.impl.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryResponseDTO> getAll() {
        List<Category> categories = categoryService.getAll();
        return categories.stream()
                .map(CategoryMapper::toDTO)
                .toList();
    }

    @GetMapping("{id}")
    public CategoryResponseDTO getById(@PathVariable Long id) {
        Category category = categoryService.getById(id);
        return CategoryMapper.toDTO(category);
    }

    @PostMapping
    public CategoryResponseDTO save(@RequestBody CategoryRequestDTO categoryRequestDTO) {
        Category category = categoryService.save(categoryRequestDTO);
        return CategoryMapper.toDTO(category);
    }

    @GetMapping("/{categoryId}/products")
    public CategoryWithProductsResponseDTO getAllByCategory(@PathVariable Long categoryId) {
        return categoryService.getCategoryWithProducts(categoryId);
    }
}
