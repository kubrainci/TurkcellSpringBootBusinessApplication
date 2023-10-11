package Turkcellbootcamp.Springstart.controlleres;

import Turkcellbootcamp.Springstart.business.abstracts.CategoryService;
import Turkcellbootcamp.Springstart.entities.Category;
import Turkcellbootcamp.Springstart.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")

public class CategoryController {
    private  final  CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {

        this.categoryService = categoryService;
    }
    //İSTEKLER
    @GetMapping("getAll")
    public List<Category> getAll(){

        return categoryService.getAll();
    }
     @GetMapping("getById")
    public Category getCategoryById(@RequestParam ("id") int id){

        return categoryService.getById(id);
    }

     @PostMapping("add")
     public ResponseEntity add(@RequestBody Category category){
        this.categoryService.add(category);
        return new ResponseEntity("Kategori eklendi ", HttpStatus.CREATED);
     }
     @DeleteMapping("delete")
     public ResponseEntity delete(@RequestParam ("id")int id){
        categoryService.delete(id);
        return new ResponseEntity("Kategori silindi.",HttpStatus.CREATED);
     }


     @PutMapping("update")
     public  ResponseEntity update(@RequestParam("id") int id,@RequestBody Category category){
        categoryService.update(id, category);
        return new ResponseEntity("Kategori güncellendi.",HttpStatus.CREATED);
     }
}
