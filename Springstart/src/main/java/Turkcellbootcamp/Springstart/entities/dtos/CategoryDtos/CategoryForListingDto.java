package Turkcellbootcamp.Springstart.entities.dtos.CategoryDtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CategoryForListingDto {
    private int categoryId;
    private String categoryName;

}
