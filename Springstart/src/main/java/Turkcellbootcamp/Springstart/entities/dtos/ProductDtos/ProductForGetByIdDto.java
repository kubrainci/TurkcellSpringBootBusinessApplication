package Turkcellbootcamp.Springstart.entities.dtos.ProductDtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductForGetByIdDto {

    private short productId;
    private float unitPrice;
    private String productName;
    private String quantityPerUnit;
    private short unitsInStock;
    private short unitsOnOrder;
    private short reorderLevel;
}
