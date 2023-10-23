package Turkcellbootcamp.Springstart.entities.dtos.ProductDtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class ProductForUpdateDto {

    private short productId;
    @NotBlank(message = "Ürün ismi boş bırakılamaz ")
    private String productName;
    private String quantityPerUnit;
    @Min(value = 1,message = "Ürün fiyatı minumum 1 olacaktır.")
    private float unitPrice;
    private short unitsInStock;
    private short unitsOnOrder;
    private short reorderLevel;
}
