package Turkcellbootcamp.Springstart.repositories;

import Turkcellbootcamp.Springstart.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Short> {
}
