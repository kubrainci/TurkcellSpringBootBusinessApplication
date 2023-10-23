package Turkcellbootcamp.Springstart.business.concretes;

import Turkcellbootcamp.Springstart.business.abstracts.CategoryService;
import Turkcellbootcamp.Springstart.core.exceptions.BusinessException;
import Turkcellbootcamp.Springstart.entities.concretes.Category;
import Turkcellbootcamp.Springstart.entities.dtos.CategoryDtos.CategoryForAddDto;
import Turkcellbootcamp.Springstart.entities.dtos.CategoryDtos.CategoryForListingDto;
import Turkcellbootcamp.Springstart.entities.dtos.CategoryDtos.CategoryForUpdateDto;
import Turkcellbootcamp.Springstart.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CategoryManager implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final MessageSource messageSource;

    @Autowired


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
    public void delete(int id) {
        categoryRepository.deleteById(id);

    }

    // Business Rule => Aynı isimde iki kategori olmamalı

    @Override
    public void add(CategoryForAddDto categoryForAddDto) {

        categoryWithSameNameShouldNotExist(categoryForAddDto.getCategoryName());
        categoryNameLengthExceeded(categoryForAddDto.getCategoryName(),50);
        Category category = Category.builder()
                .categoryName(categoryForAddDto.getCategoryName())
                .description(categoryForAddDto.getDescription())
                .build();
        categoryRepository.save(category);

        // Mapleme işlemi business içerisinde olmalıdır
    }


    private void categoryNameLengthExceeded(String categoryName, int maxLength) {
        if (categoryName.length()>=maxLength){
            throw new BusinessException(messageSource.getMessage("categoryNameLengthExceeded",new Object[]{maxLength},LocaleContextHolder.getLocale()));
        }

    }
    private void categoryWithSameNameShouldNotExist(String categoryName) {
        Category categoryWithSameName = categoryRepository.findByCategoryName(categoryName);
        if(categoryWithSameName != null){
            throw new BusinessException(messageSource.getMessage("categoryWithSameNameShouldNotExist",null, LocaleContextHolder.getLocale()));
        }
    }

    @Override
    public void update(CategoryForUpdateDto categoryForUpdateDto) {
        Category categoryToUpdate=returnCategoryByIdIfExist(categoryForUpdateDto.getCategoryId());
        categoryToUpdate.setCategoryName(categoryToUpdate.getCategoryName());
        categoryToUpdate.setDescription(categoryToUpdate.getDescription());
        categoryRepository.save(categoryToUpdate);
    }

    private Category returnCategoryByIdIfExist(int categoryId) {
        Category category=categoryRepository.findById(categoryId).orElse(null);
        if (category==null)
            throw new BusinessException(messageSource.getMessage("returnCategoryByIdIfExist",null,LocaleContextHolder.getLocale()));
        return category;
    }


}
