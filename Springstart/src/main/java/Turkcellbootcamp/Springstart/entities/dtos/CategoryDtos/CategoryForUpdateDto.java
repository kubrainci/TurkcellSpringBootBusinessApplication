package Turkcellbootcamp.Springstart.entities.dtos.CategoryDtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class CategoryForUpdateDto {

    @NotNull
    private int categoryId;
    @NotBlank(message = "{categoryNameCannotBeLeftBlank}")
    @Size(min = 5,message = "{updatingTheCategoryNameItCannotBeLessThanFiveDigits}")
    private String categoryName;
    @NotBlank(message = "{descriptionFieldCannotBeLeftBlank}")
    private String description;
}
