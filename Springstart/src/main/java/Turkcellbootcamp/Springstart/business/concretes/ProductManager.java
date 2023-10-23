package Turkcellbootcamp.Springstart.business.concretes;

import Turkcellbootcamp.Springstart.business.abstracts.ProductService;
import Turkcellbootcamp.Springstart.core.exceptions.BusinessException;
import Turkcellbootcamp.Springstart.entities.concretes.Product;
import Turkcellbootcamp.Springstart.entities.dtos.ProductDtos.ProductForAddDto;
import Turkcellbootcamp.Springstart.entities.dtos.ProductDtos.ProductForGetByIdDto;
import Turkcellbootcamp.Springstart.entities.dtos.ProductDtos.ProductForListingDto;
import Turkcellbootcamp.Springstart.entities.dtos.ProductDtos.ProductForUpdateDto;
import Turkcellbootcamp.Springstart.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductManager implements ProductService {

    private final ProductRepository productRepository;
    private final MessageSource messageSource;

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
    public void update(short id, ProductForUpdateDto productForUpdateDto) {
        Product p =productRepository.findById(id).orElseThrow();
        p.setProductName(productForUpdateDto.getProductName());
        p.setUnitPrice(productForUpdateDto.getUnitPrice());
        p.setQuantityPerUnit(productForUpdateDto.getQuantityPerUnit());
        productRepository.save(p);

    }

    @Override
    public void delete(short id) {
        productRepository.deleteById(id);

    }

    @Override
    public void add(ProductForAddDto productForAddDto) {
       productNameMustBeUnique(productForAddDto.getProductName());
       Product product=Product.builder()
               .productName(productForAddDto.getProductName())
               .quantityPerUnit(productForAddDto.getQuantityPerUnit())
               .build();
        productRepository.save(product);

    }
   
    private void productNameMustBeUnique(String productName) {
        Product productNameMustBeUnique=productRepository.findByProductName(productName);
        if (productNameMustBeUnique != null){
            throw new BusinessException(messageSource.getMessage("productNameMustBeUnique", null, LocaleContextHolder.getLocale()));
        }
    }


}
