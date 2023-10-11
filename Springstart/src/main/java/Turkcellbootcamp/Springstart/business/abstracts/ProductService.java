package Turkcellbootcamp.Springstart.business.abstracts;

import Turkcellbootcamp.Springstart.entities.Product;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.util.List;
@Service
public interface ProductService {
    Result add(Product product);
    List<Product>getAll();
    Product getById(short id);
    void update(short id, Product product);
    void  delete(short id);
}
