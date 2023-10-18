package Turkcellbootcamp.Springstart.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CategoryForListingDto {
    private int categoryId;
    private String categoryName;

}
