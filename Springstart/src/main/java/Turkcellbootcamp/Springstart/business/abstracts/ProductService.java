package Turkcellbootcamp.Springstart.business.abstracts;

import Turkcellbootcamp.Springstart.entities.Product;
import Turkcellbootcamp.Springstart.entities.dtos.ProductDtos.ProductForAddDto;
import Turkcellbootcamp.Springstart.entities.dtos.ProductDtos.ProductForGetByIdDto;
import Turkcellbootcamp.Springstart.entities.dtos.ProductDtos.ProductForListingDto;
import Turkcellbootcamp.Springstart.entities.dtos.ProductDtos.ProductForUpdateDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductService {
   // Result add(Product product);
    void add(ProductForAddDto productForAddDto);
   // List<Product>getAll();
   List<ProductForListingDto> getAll();
  ;
  //  Product getById(short id);
    ProductForGetByIdDto getById(short id);

    void update(short id, ProductForUpdateDto productForUpdateDto);
    void  delete(short id);

}
