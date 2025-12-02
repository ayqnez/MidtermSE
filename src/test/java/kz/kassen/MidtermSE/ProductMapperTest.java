package kz.kassen.MidtermSE;

import kz.kassen.MidtermSE.dto.ProductDTO;
import kz.kassen.MidtermSE.entity.Product;
import kz.kassen.MidtermSE.mapper.ProductMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

public class ProductMapperTest {

    private final ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

    @Test
    void convertEntityToDto() {
        Product product = new Product(1L, "Iphone", "Iphone 15 Pro", "Phones", true);
        ProductDTO productDTO = productMapper.toDto(product);

        Assertions.assertNotNull(productDTO);

        Assertions.assertEquals(product.getId(), productDTO.getId());
        Assertions.assertEquals(product.getName(), productDTO.getNameDTO());
        Assertions.assertEquals(product.getDescription(), productDTO.getDescriptionDTO());
        Assertions.assertEquals(product.getCategory(), productDTO.getCategoryDTO());
        Assertions.assertEquals(product.getInStock(), productDTO.getInStockDTO());
    }

    @Test
    void convertDtoToEntity() {
        ProductDTO productDTO = new ProductDTO(1L, "IphoneDTO", "Iphone 15 Pro Dto", "Phones DTO", false);
        Product product = productMapper.toEntity(productDTO);

        Assertions.assertNotNull(product);

        Assertions.assertEquals(productDTO.getId(), product.getId());
        Assertions.assertEquals(productDTO.getNameDTO(), product.getName());
        Assertions.assertEquals(productDTO.getDescriptionDTO(), product.getDescription());
        Assertions.assertEquals(productDTO.getCategoryDTO(), product.getCategory());
        Assertions.assertEquals(productDTO.getInStockDTO(), product.getInStock());
    }

    @Test
    void convertListEntityItemToListDtoItemTest(){

        // part 1
        List<Product> entityList = new ArrayList<>();

        entityList.add(new Product(1L, "Phone", "Phone", "Phone", true)); // 0
        entityList.add(new Product(2L, "TV", "TV", "TV", false));    // 1
        entityList.add(new Product(3L, "laptop", "laptop", "laptop", true)); // 2

        List<ProductDTO> dtoList = productMapper.toDtoList(entityList); // -> size = 0

        // part 2
        Assertions.assertNotNull(dtoList);

        // part 3
        Assertions.assertNotEquals(0, dtoList.size());

        // part 4
        Assertions.assertEquals(entityList.size(), dtoList.size());

        // part 5
        for (int i = 0; i < entityList.size(); i++) {

            Product entityItem = entityList.get(i);
            ProductDTO dtoItem = productMapper.toDto(entityItem);

            Assertions.assertNotNull(dtoItem);

            Assertions.assertNotNull(dtoItem.getId());
            Assertions.assertNotNull(dtoItem.getNameDTO());
            Assertions.assertNotNull(dtoItem.getDescriptionDTO());
            Assertions.assertNotNull(dtoItem.getCategoryDTO());
            Assertions.assertNotNull(dtoItem.getInStockDTO());

            Assertions.assertEquals(entityItem.getId(), dtoItem.getId());
            Assertions.assertEquals(entityItem.getName(), dtoItem.getNameDTO());
            Assertions.assertEquals(entityItem.getDescription(), dtoItem.getDescriptionDTO());
            Assertions.assertEquals(entityItem.getCategory(), dtoItem.getCategoryDTO());
            Assertions.assertEquals(entityItem.getInStock(), dtoItem.getInStockDTO());

        }

    }
}
