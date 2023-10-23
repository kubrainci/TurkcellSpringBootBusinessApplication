package Turkcellbootcamp.Springstart.entities.dtos.ProductDtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class ProductForDeleteDto {
    private short productId;
}
