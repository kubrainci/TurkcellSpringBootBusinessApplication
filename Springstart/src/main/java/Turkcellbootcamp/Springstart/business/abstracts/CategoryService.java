package Turkcellbootcamp.Springstart.business.abstracts;


import Turkcellbootcamp.Springstart.entities.Category;
import Turkcellbootcamp.Springstart.entities.dtos.CategoryForAddDto;
import Turkcellbootcamp.Springstart.entities.dtos.CategoryForListingDto;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.util.List;

@Service

public interface CategoryService {

    //SERVİSLER DTOLARLA İLİŞKİ KURMALIDIR
    //Result add(Category category);
     void add(CategoryForAddDto categoryForAddDto);
     List<CategoryForListingDto>getAll();


    Category getById(int id);

    void update(int id, Category category);

    void delete(int id);

   // Category findByCategoryName(String categoryName);
}