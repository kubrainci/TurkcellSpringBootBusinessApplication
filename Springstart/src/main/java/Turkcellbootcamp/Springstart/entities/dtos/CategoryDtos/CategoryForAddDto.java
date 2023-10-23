package Turkcellbootcamp.Springstart.entities.dtos.CategoryDtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.springframework.context.MessageSource;

@Data
@Builder
public class CategoryForAddDto {


    @NotBlank(message = "{categoryNameCannotBeLeftBlank}")
    @Size(min = 4,message = "{categoryNameCannotBeSmallerThanFourDigits}")
    private String categoryName;
    @NotBlank(message = "{descriptionFieldCannotBeLeftBlank}")
    private String description;
}