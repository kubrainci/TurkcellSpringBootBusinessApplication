package Turkcellbootcamp.Springstart.business.abstracts;


import Turkcellbootcamp.Springstart.entities.concretes.Category;
import Turkcellbootcamp.Springstart.entities.dtos.CategoryDtos.CategoryForAddDto;
import Turkcellbootcamp.Springstart.entities.dtos.CategoryDtos.CategoryForListingDto;
import Turkcellbootcamp.Springstart.entities.dtos.CategoryDtos.CategoryForUpdateDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface CategoryService {

    //SERVİSLER DTOLARLA İLİŞKİ KURMALIDIR

     void add(CategoryForAddDto categoryForAddDto);
     void update(CategoryForUpdateDto categoryForUpdateDto);
     void delete(int id);
     List<CategoryForListingDto>getAll();
     Category getById(int id);
    // Category findByCategoryName(String categoryName);
}