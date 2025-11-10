package com.madhav.ecomspring.service.impl;

import com.madhav.ecomspring.dto.request.ProductRequestDTO;
import com.madhav.ecomspring.entity.Category;
import com.madhav.ecomspring.entity.Product;
import com.madhav.ecomspring.exception.ResourceNotFoundException;
import com.madhav.ecomspring.mapper.ProductMapper;
import com.madhav.ecomspring.repository.ProductRepository;
import com.madhav.ecomspring.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public ProductService(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Product not found with id %d", id)));
    }

    @Override
    public Product save(ProductRequestDTO productRequestDTO) {
        Category category = categoryService.getById(productRequestDTO.getCategoryId());
        return productRepository.save(ProductMapper.toEntity(productRequestDTO, category));
    }

    @Override
    public List<Product> searchFullText(String keyword) {
        return productRepository.searchFullText(keyword);
    }

    @Override
    public List<Product> getAllByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }
}
