package Turkcellbootcamp.Springstart.entities.dtos.ProductDtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ProductForListingDto {

    private short productId;
    private String productName;
    private String quantityPerUnit;
    private float unitPrice;
    private short unitsInStock;
    private short unitsOnOrder;
    private int discontinued;
    private short reorderLevel;

    private short quantity;
    private float discount;


}
