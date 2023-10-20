package Turkcellbootcamp.Springstart.entities.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data


public class ProductForAddDto {
    @NotBlank(message = "Ürün ismi boş bırakılamaz")
    private String productName;
    private String quantityPerUnit;
    @NotNull(message = "Ürün fiyatı boş bırakılamaz.")
    @Min(value = 1,message = "Ürün fiyatı minimum 1 olmalıdır.")
    private float unitPrice;
    private short unitsInStock;
    private short unitsOnOrder;
    private short reorderLevel;
}
