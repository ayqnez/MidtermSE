package kz.kassen.MidtermSE.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String nameDTO;
    private String descriptionDTO;
    private String categoryDTO;
    private Boolean inStockDTO;
}
