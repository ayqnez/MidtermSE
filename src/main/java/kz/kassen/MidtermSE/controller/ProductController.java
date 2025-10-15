package kz.kassen.MidtermSE.controller;

import kz.kassen.MidtermSE.dto.ProductDTO;
import kz.kassen.MidtermSE.service.serviceImpl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImpl productService;

    @GetMapping()
    public List<ProductDTO> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{productId}")
    public ProductDTO findById(@PathVariable Long productId) {
        return productService.findById(productId);
    }

    @PostMapping()
    public void createProduct(@RequestBody ProductDTO productDTO) {
        productService.createProduct(productDTO);
    }
}
