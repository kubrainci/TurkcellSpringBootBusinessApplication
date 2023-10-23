package Turkcellbootcamp.Springstart.entities.dtos.ProductDtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;


@Data
@Builder


public class ProductForAddDto {
    @NotBlank(message = "{productNameCannotBeLeftBlank}")
    private String productName;
    private String quantityPerUnit;
    @NotNull(message = "{productUnitPriceCannotBeLeftBlank}")
    @Min(value = 1,message = "{productUnitPriceMinimumShouldBeOne.}")
    private float unitPrice;
    private short unitsInStock;
    private short unitsOnOrder;
    private short reorderLevel;
}
