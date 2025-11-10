package com.madhav.ecomspring.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryWithProductsResponseDTO {
    private Long id;
    private String name;
    private List<ProductResponseDTO> products;
}
