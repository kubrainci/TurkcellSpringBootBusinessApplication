package Turkcellbootcamp.Springstart.business.concretes;

import Turkcellbootcamp.Springstart.business.abstracts.OrderService;
import Turkcellbootcamp.Springstart.entities.Order;
import Turkcellbootcamp.Springstart.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class OrderManager implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderManager(OrderRepository orderRepository) {

        this.orderRepository = orderRepository;
    }


    @Override
    public void add(Order order) {
        orderRepository.save(order);

    }

    @Override
    public List<Order> getAll() {

        return orderRepository.findAll();
    }

    @Override
    public Order getById(short id) {
        Order order=orderRepository.findById(id).orElseThrow();
        return order ;
    }

    @Override
    public void update(short id, Order order) {
        Order o =orderRepository.getReferenceById(id);
        o.setShipName(order.getShipName());
        o.setShipCity(order.getShipCity());
        orderRepository.save(o);
    }

    @Override
    public void delete(short id) {
        orderRepository.deleteById(id);

    }
}
