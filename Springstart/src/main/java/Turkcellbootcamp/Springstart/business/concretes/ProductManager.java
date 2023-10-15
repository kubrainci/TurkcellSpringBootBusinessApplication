package Turkcellbootcamp.Springstart.business.concretes;

import Turkcellbootcamp.Springstart.business.abstracts.ProductService;
import Turkcellbootcamp.Springstart.entities.Product;
import Turkcellbootcamp.Springstart.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.util.List;

@Service
public class ProductManager implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductManager(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    @Override
    public Result add(Product product) {
        productRepository.save(product);
        return null;
    }

    @Override
    public List<Product>getAll(){

        return productRepository.findAll();
    }

    @Override
    public Product getById(short id) {
        Product product=productRepository.findById(id).orElseThrow();
        return product;
    }

    @Override
    public void update(short id, Product product) {
        Product p =productRepository.findById(id).orElseThrow();
        p.setProductName(product.getProductName());
        p.setDiscontinued(product.getDiscontinued());
        productRepository.save(p);

    }

    @Override
    public void delete(short id) {
        productRepository.deleteById(id);

    }


}
