package Turkcellbootcamp.Springstart.business.concretes;

import Turkcellbootcamp.Springstart.business.abstracts.CategoryService;
import Turkcellbootcamp.Springstart.business.exceptions.BusinessException;
import Turkcellbootcamp.Springstart.entities.Category;
import Turkcellbootcamp.Springstart.entities.dtos.CategoryForAddDto;
import Turkcellbootcamp.Springstart.entities.dtos.CategoryForListingDto;
import Turkcellbootcamp.Springstart.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class CategoryManager implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired

    public CategoryManager(CategoryRepository categoryRepository) {

        this.categoryRepository = categoryRepository;
    }

   /* @Override
    public Result add(Category category) {
        categoryRepository.save(category);
        return null;

    }*/

    @Override
    public List<CategoryForListingDto>getAll(){

        return categoryRepository.getForListing();
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

    // Business Rule => Aynı isimde iki kategori olmamalı

    @Override
    public void add(CategoryForAddDto categoryForAddDto) {

        categoryWithSameNameShouldNotExist(categoryForAddDto.getCategoryName());
        categoryNameLengthExceeded(categoryForAddDto.getCategoryName(),50);
        Category category = new Category();
        category.setCategoryName(categoryForAddDto.getCategoryName());
        category.setDescription(categoryForAddDto.getDescription());
        categoryRepository.save(category);

        // Mapleme işlemi business içerisinde olmalıdır
    }

    private void categoryNameLengthExceeded(String categoryName, int maxLength) {
        if (categoryName.length()>=maxLength){
            throw new BusinessException("Kategori adı en fazla"+maxLength+"karakter uzunluğunda olmalıdır.");
        }

    }
    private void categoryWithSameNameShouldNotExist(String categoryName) {
        Category categoryWithSameName = categoryRepository.findByCategoryName(categoryName);
        if(categoryWithSameName != null){
            throw new BusinessException("Aynı kategori isminden iki kategori bulunamaz.Kategori isimleri benzersiz olmalıdır.");
        }
    }




}
