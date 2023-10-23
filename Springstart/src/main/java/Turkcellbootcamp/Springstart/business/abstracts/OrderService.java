package Turkcellbootcamp.Springstart.business.abstracts;

import Turkcellbootcamp.Springstart.entities.concretes.Order;
import Turkcellbootcamp.Springstart.entities.dtos.OrderDtos.OrderForAddDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface OrderService {
    void add(OrderForAddDto orderForAddDto);
    List<Order>getAll();
    Order getById(short id);
    void update(short id ,Order order);
    void delete(short id);
}
