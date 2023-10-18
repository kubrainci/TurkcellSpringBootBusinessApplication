package Turkcellbootcamp.Springstart.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

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
