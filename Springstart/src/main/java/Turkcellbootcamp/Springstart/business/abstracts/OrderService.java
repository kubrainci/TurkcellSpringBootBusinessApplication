package Turkcellbootcamp.Springstart.business.abstracts;

import Turkcellbootcamp.Springstart.entities.Order;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface OrderService {
    void add(Order order);
    List<Order>getAll();
    Order getById(short id);
    void update(short id ,Order order);
    void delete(short id);
}
