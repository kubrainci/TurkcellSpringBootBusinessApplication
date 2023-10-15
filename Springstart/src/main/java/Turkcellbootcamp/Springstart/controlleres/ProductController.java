package Turkcellbootcamp.Springstart.controlleres;

import Turkcellbootcamp.Springstart.business.abstracts.ProductService;
import Turkcellbootcamp.Springstart.entities.Product;
import Turkcellbootcamp.Springstart.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;
    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductService productService, ProductRepository productRepository) {

        this.productService = productService;
        this.productRepository = productRepository;
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

    @GetMapping("findByProductNameContaining")
    public List<Product> findByProductNameContaining(String name) {
        return productRepository.findByProductNameContaining(name);
    }

    @GetMapping("findByUnitPriceLessThan")
    public List<Product>findByUnitPriceLessThan(float unitPrice){
      List<Product>products= productRepository.findByUnitPriceLessThan(unitPrice);
         return products;
    }
    @GetMapping("findByUnitsInStockGreaterThan")
    public List<Product>findByUnitsInStockGreaterThan(short unitsInStock){
        List<Product>products=productRepository.findByUnitsInStockGreaterThan(unitsInStock);
        return products;

    }


    @GetMapping("getByProductOrderByProductNameAsc")
    public List<Product>findByProductOrderByProductNameAsc(String productName){
        List<Product>products=productRepository.findByProductOrderByProductNameAsc(productName);
        return products;

    }

    @GetMapping("getProductsByUnitsOnOrder")
    public  List<Product>findProductsByUnitsOnOrder(short unitsOnOrder){
        List<Product>products=productRepository.findProductsByUnitsOnOrder(unitsOnOrder);
        return products;
    }
    @GetMapping("getProductsByUnitsOnOrderZero")
    public  List<Product> findProductsByUnitsOnOrderZero(short unitsOnOrder){
        List<Product> products=productRepository.findProductsByUnitsOnOrderZero(unitsOnOrder);
        return products;
    }
    @GetMapping("searchProductName")
    public  List<Product>searchProductName(String productName){
        List<Product>products=productRepository.searchProductName( productName);
        return products;
    }
    @GetMapping("getProductsByUnitsInStockTrueNativeSql")
    public List<Product>findProductsByUnitsInStockTrueNativeSql(short unitsInStock){
        List<Product>products=productRepository.findProductsByUnitsInStockTrueNativeSql ( unitsInStock);
        return products;
    }


}
