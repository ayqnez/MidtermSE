package kz.kassen.MidtermSE.service.serviceImpl;

import kz.kassen.MidtermSE.dto.ProductDTO;
import kz.kassen.MidtermSE.mapper.ProductMapper;
import kz.kassen.MidtermSE.repo.ProductRepo;
import kz.kassen.MidtermSE.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDTO> findAll() {
        return productMapper.toDtoList(productRepo.findAll());
    }

    @Override
    public ProductDTO findById(Long productId) {
        return productMapper.toDto(productRepo.findById(productId).orElseThrow());
    }

    @Override
    public void createProduct(ProductDTO productDTO) {
        productRepo.save(productMapper.toEntity(productDTO));
    }
}
