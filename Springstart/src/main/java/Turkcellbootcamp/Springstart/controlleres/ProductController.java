package Turkcellbootcamp.Springstart.controlleres;

import Turkcellbootcamp.Springstart.business.abstracts.ProductService;
import Turkcellbootcamp.Springstart.entities.concretes.Product;
import Turkcellbootcamp.Springstart.entities.dtos.ProductDtos.*;
import Turkcellbootcamp.Springstart.repositories.ProductRepository;
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
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductRepository productRepository;
    private final MessageSource messageSource;

    @GetMapping("getAll")
    public List<ProductForListingDto> getAll() {

        return productService.getAll();
    }



    @GetMapping("getById")
  public ProductForGetByIdDto getById(@RequestParam short id){

      return productService.getById(id);
  }


    @PutMapping("update")
    public ResponseEntity update(@RequestParam("id") short id , @RequestBody @Valid ProductForUpdateDto productForUpdateDto){
        Product product=new Product();
        product.setProductName(productForUpdateDto.getProductName());
        product.setQuantityPerUnit(productForUpdateDto.getQuantityPerUnit());
        product.setUnitPrice(productForUpdateDto.getUnitPrice());
        product.setUnitsInStock(productForUpdateDto.getUnitsInStock());
        product.setUnitsOnOrder(productForUpdateDto.getUnitsOnOrder());
        product.setDiscontinued(0);
        productService.update(id,productForUpdateDto);
        return new ResponseEntity(messageSource.getMessage("productUpdated",new Object[]{id}, LocaleContextHolder.getLocale()),HttpStatus.CREATED);

    }


    @PostMapping("add")
    public ResponseEntity<String> addProductDto(@RequestBody @Valid ProductForAddDto productForAddDtoDto) {
        productService.add(productForAddDtoDto);
        return ResponseEntity.ok(messageSource.getMessage("productAdded",null,LocaleContextHolder.getLocale()));
    }
    @DeleteMapping("delete")
    public ResponseEntity delete(@RequestBody ProductForDeleteDto productForDeleteDto){
        short id=productForDeleteDto.getProductId();
        productService.delete(id);
        return new ResponseEntity(messageSource.getMessage("productDeleted",new Object[]{id},LocaleContextHolder.getLocale()),HttpStatus.CREATED);
    }

    //DERİVED QUERY METHODS
    @GetMapping("getByProductNameContaining")
    public List<Product> findByProductNameContaining(String name) {
        return productRepository.findByProductNameContaining(name);
    }
    /* @GetMapping("getByCategoryName")
    public Category getCategoriesByName(@RequestParam("name") String name) {
        Category categories =categoryRepository.findByCategoryName(name);
        return categories;
    }*/
    @GetMapping("getByProductName")
    public Product getProductsByName(@RequestParam("name")String name){
        Product products=productRepository.findByProductName(name);
        return products;
    }

    @GetMapping("getByUnitPriceLessThan")
    public List<Product>findByUnitPriceLessThan(float unitPrice){
        List<Product>products= productRepository.findByUnitPriceLessThan(unitPrice);
        return products;
    }
    @GetMapping("getByUnitsInStockGreaterThan")
    public List<Product>findByUnitsInStockGreaterThan(short unitsInStock){
        List<Product>products=productRepository.findByUnitsInStockGreaterThan(unitsInStock);
        return products;

    }

    //JPQL
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

    //NATİVE SQL
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
