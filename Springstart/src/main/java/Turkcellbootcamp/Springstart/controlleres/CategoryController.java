package Turkcellbootcamp.Springstart.controlleres;

import Turkcellbootcamp.Springstart.business.abstracts.CategoryService;
import Turkcellbootcamp.Springstart.entities.concretes.Category;
import Turkcellbootcamp.Springstart.entities.dtos.CategoryDtos.CategoryForAddDto;
import Turkcellbootcamp.Springstart.entities.dtos.CategoryDtos.CategoryForListingDto;
import Turkcellbootcamp.Springstart.entities.dtos.CategoryDtos.CategoryForUpdateDto;
import Turkcellbootcamp.Springstart.repositories.CategoryRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
@RequiredArgsConstructor

public class CategoryController {
    private  final  CategoryService categoryService;
    private final CategoryRepository categoryRepository;
    private final MessageSource messageSource;

    //İSTEKLER
    @GetMapping("getAll")
    public List<CategoryForListingDto> getAll(){

        return categoryService.getAll();
    }


     @GetMapping("getById")
    public Category getCategoryById(@RequestParam ("id") int id){

        return categoryService.getById(id);
    }

     @PostMapping("add")
     public ResponseEntity add(@RequestBody @Valid CategoryForAddDto categoryForAddDto){

             categoryService.add(categoryForAddDto);

        return new ResponseEntity(messageSource.getMessage("categoryAdded",new Object[]{ categoryForAddDto.getCategoryName()}, LocaleContextHolder.getLocale()),HttpStatus.CREATED);
     }
     /*"Kategori eklendi ", HttpStatus.CREATED*/
     @DeleteMapping("delete")
     public ResponseEntity delete(@RequestParam ("id")int id){
        categoryService.delete(id);
        return new ResponseEntity(messageSource.getMessage("categoryDeleted",new Object[]{id},LocaleContextHolder.getLocale()),HttpStatus.CREATED);
     }

     @PutMapping("update")
     public  ResponseEntity update(@RequestParam("id") int id, @RequestBody @Valid CategoryForUpdateDto categoryForUpdateDto){
        categoryService.update(categoryForUpdateDto);
        return new ResponseEntity(messageSource.getMessage("categoryUpdated",new Object[]{id},LocaleContextHolder.getLocale()),HttpStatus.CREATED);
     }


    //  DERİVED QUERY METHODS

    @GetMapping("getByCategoryName")
    public Category getCategoriesByName(@RequestParam("name") String name) {
        Category categories =categoryRepository.findByCategoryName(name);
        return categories;
    }
    @GetMapping("getByName")
    public List<Category> getCategoriesByNameContaining(@RequestParam("name") String name) {
        List<Category> categories =categoryRepository.findByCategoryNameContaining(name);
        return categories;

    }

    //JPQL
    @GetMapping("search")
    public List<Category>search (@RequestParam("name") String name){
        List<Category>category=categoryRepository.search(name);
        return category;
    }
    @GetMapping("getByOrderByCategoryNameAsc")
    public List<Category>findByOrderByCategoryNameAsc(String categoryName){
        List<Category>categories=categoryRepository.findByOrderByCategoryNameAsc(categoryName);
        return categories;
    }

    //NATİVE SQL
    @GetMapping("searchNative")
    public List<Category>searchNative (@RequestParam("name") String name){
        List<Category>category=categoryRepository.searchNative(name);
        return category;
    }
    @GetMapping("getCountCategories")
    public Integer getCountCategories(){
        Integer countCategories=categoryRepository.countCategories();
        return countCategories;
    }



}
