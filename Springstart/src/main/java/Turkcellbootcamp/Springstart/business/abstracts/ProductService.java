package Turkcellbootcamp.Springstart.business.abstracts;

import Turkcellbootcamp.Springstart.entities.Product;
import Turkcellbootcamp.Springstart.entities.dtos.ProductForGetByIdDto;
import Turkcellbootcamp.Springstart.entities.dtos.ProductForListingDto;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.util.List;
@Service
public interface ProductService {
    Result add(Product product);
   // List<Product>getAll();
   List<ProductForListingDto> getAll();
  ;
  //  Product getById(short id);
    ProductForGetByIdDto getById(short id);

    void update(short id, Product product);
    void  delete(short id);

}
