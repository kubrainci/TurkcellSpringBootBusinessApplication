package Turkcellbootcamp.Springstart.business.concretes;

import Turkcellbootcamp.Springstart.business.abstracts.ProductService;
import Turkcellbootcamp.Springstart.entities.Product;
import Turkcellbootcamp.Springstart.entities.dtos.ProductForGetByIdDto;
import Turkcellbootcamp.Springstart.entities.dtos.ProductForListingDto;
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
    public List<ProductForListingDto> getAll() {

        return productRepository.getForListing();
    }

    @Override
    public ProductForGetByIdDto getById(short id) {
        ProductForGetByIdDto productForGetByIdDto=productRepository.getByIdDto(id);
        return productForGetByIdDto;
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
