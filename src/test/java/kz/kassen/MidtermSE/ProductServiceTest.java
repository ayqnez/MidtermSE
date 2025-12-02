package kz.kassen.MidtermSE;


import kz.kassen.MidtermSE.dto.ProductDTO;
import kz.kassen.MidtermSE.service.serviceImpl.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    void getAllItemService(){

        List<ProductDTO> productDTOS = productService.findAll();

        Assertions.assertNotNull(productDTOS);
        Assertions.assertNotEquals(0, productDTOS.size());

        for (int i = 0; i < productDTOS.size(); i++) {
            ProductDTO productDTO = productDTOS.get(i);

            Assertions.assertNotNull(productDTO);

            Assertions.assertNotNull(productDTO.getId());
            Assertions.assertNotNull(productDTO.getNameDTO());
            Assertions.assertNotNull(productDTO.getDescriptionDTO());
            Assertions.assertNotNull(productDTO.getCategoryDTO());
            Assertions.assertNotNull(productDTO.getInStockDTO());
        }
    }
}