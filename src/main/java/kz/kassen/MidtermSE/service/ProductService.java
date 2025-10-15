package kz.kassen.MidtermSE.service;

import kz.kassen.MidtermSE.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAll();
    ProductDTO findById(Long productId);
    void createProduct(ProductDTO productDTO);
}
