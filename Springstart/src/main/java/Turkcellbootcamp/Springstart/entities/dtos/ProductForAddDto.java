package Turkcellbootcamp.Springstart.entities.dtos;

import lombok.Data;


@Data


public class ProductForAddDto {
    private String productName;
    private String quantityPerUnit;
    private float unitPrice;
    private short unitsInStock;
    private short unitsOnOrder;
    private short reorderLevel;
}
