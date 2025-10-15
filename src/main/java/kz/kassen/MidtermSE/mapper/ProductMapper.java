package kz.kassen.MidtermSE.mapper;

import kz.kassen.MidtermSE.dto.ProductDTO;
import kz.kassen.MidtermSE.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "nameDTO", source = "name")
    @Mapping(target = "descriptionDTO", source = "description")
    @Mapping(target = "categoryDTO", source = "category")
    @Mapping(target = "inStockDTO", source = "inStock")
    ProductDTO toDto(Product product);

    @Mapping(target = "name", source = "nameDTO")
    @Mapping(target = "description", source = "descriptionDTO")
    @Mapping(target = "category", source = "categoryDTO")
    @Mapping(target = "inStock", source = "inStockDTO")
    Product toEntity(ProductDTO productDTO);

    List<ProductDTO> toDtoList(List<Product> products);
}
