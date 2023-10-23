package Turkcellbootcamp.Springstart.repositories;

import Turkcellbootcamp.Springstart.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Short> {
}
