package Turkcellbootcamp.Springstart.entities.dtos.CategoryDtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryForAddDto {

    @NotBlank(message = "Kategori ismi boş bırakılamaz.")
    @Size(min = 4,message = "Kategori ismi 4 haneden küçük olamaz.")
    private String categoryName;
    @NotBlank(message = "Açıklama alanı boş bırakılamaz.")
    private String description;
}
