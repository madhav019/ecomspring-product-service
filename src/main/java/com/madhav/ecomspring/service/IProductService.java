package com.madhav.ecomspring.service;

import com.madhav.ecomspring.dto.request.ProductRequestDTO;
import com.madhav.ecomspring.entity.Product;

import java.util.List;

public interface IProductService {

    List<Product> getAll();

    Product getById(Long id);

    Product save(ProductRequestDTO productRequestDTO);

    List<Product> searchFullText(String keyword);

    List<Product> getAllByCategory(Long categoryId);

}
