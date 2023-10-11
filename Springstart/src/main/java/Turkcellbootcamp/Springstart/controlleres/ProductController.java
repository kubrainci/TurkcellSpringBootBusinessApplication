package Turkcellbootcamp.Springstart.controlleres;

import Turkcellbootcamp.Springstart.business.abstracts.ProductService;
import Turkcellbootcamp.Springstart.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {

        this.productService = productService;
    }

    @GetMapping("getAll")
    public List<Product>getAll(){

        return productService.getAll();
    }

    @GetMapping("getById")
    public Product getProductId (@RequestParam short id){

        return productService.getById(id);
    }

    @PutMapping("update")
    public ResponseEntity update(@RequestParam("id") short id ,@RequestBody Product product){
        productService.update(id,product);
        return new ResponseEntity("Ürün güncellendi.",HttpStatus.CREATED);

    }
    @PostMapping("add")
    public ResponseEntity add(@RequestBody Product product){
        productService.add(product);
        return  new ResponseEntity("Ürün eklendi", HttpStatus.CREATED);

    }
    @DeleteMapping("delete")
    public ResponseEntity delete(@RequestParam short id){
        productService.delete(id);
        return new ResponseEntity("Ürün silindi",HttpStatus.CREATED);
    }


}
