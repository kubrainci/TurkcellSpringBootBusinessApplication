package Turkcellbootcamp.Springstart.entities.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CategoryForAddDto {

    @NotBlank(message = "Kategori ismi boş bırakılamaz.")
    @Size(min = 4,message = "Kategori ismi 4 haneden küçük olamaz.")
    private String categoryName;
    @NotBlank(message = "Açıklama alanı boş bırakılamaz.")
    private String description;
}
