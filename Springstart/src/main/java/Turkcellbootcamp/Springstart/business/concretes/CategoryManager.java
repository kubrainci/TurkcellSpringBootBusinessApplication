package Turkcellbootcamp.Springstart.business.concretes;

import Turkcellbootcamp.Springstart.business.abstracts.CategoryService;
import Turkcellbootcamp.Springstart.entities.Category;
import Turkcellbootcamp.Springstart.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.util.List;

@Service
public class CategoryManager implements CategoryService {

    private  final CategoryRepository categoryRepository;

    @Autowired
    public CategoryManager(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Result add(Category category) {
        categoryRepository.save(category);
        return null;

    }

    @Override
    public List<Category> getAll() {

        return categoryRepository.findAll();
    }

    @Override
    public Category getById(int id) {
       Category category=categoryRepository.findById(id).orElseThrow();
       return category;

    }

    @Override
    public void update(int id, Category category) {
      Category c=categoryRepository.getReferenceById(id);
      c.setCategoryName(category.getCategoryName());
      c.setDescription(category.getDescription());
      categoryRepository.save(c);

    }

    @Override
    public void delete(int id) {
        categoryRepository.deleteById(id);

    }
}
