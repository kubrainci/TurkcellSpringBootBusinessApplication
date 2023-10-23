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
    @NotBlank(message = "Kategori ismi boş bırakılamaz.")
    @Size(min = 5,message = "Kategori ismi güncellenirken 5 haneden küçük olmaz.")
    private String categoryName;
    @NotBlank(message = "Açıklama boş bırakılamaz,lütfen açıklama yapınız.")
    private String description;
}
