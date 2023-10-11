package Turkcellbootcamp.Springstart.business.abstracts;

import Turkcellbootcamp.Springstart.entities.Category;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.util.List;
@Service

public interface CategoryService {
    Result add (Category category);
    List<Category>getAll();
    Category getById(int id);
    void update(int id,Category category);
    void delete(int id);
}
