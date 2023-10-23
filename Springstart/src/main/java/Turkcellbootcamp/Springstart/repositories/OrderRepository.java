package Turkcellbootcamp.Springstart.repositories;


import Turkcellbootcamp.Springstart.entities.concretes.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Short> {
}
