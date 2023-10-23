package Turkcellbootcamp.Springstart.business.concretes;

import Turkcellbootcamp.Springstart.business.abstracts.OrderDetailService;
import Turkcellbootcamp.Springstart.business.abstracts.OrderService;
import Turkcellbootcamp.Springstart.entities.Category;
import Turkcellbootcamp.Springstart.entities.Order;
import Turkcellbootcamp.Springstart.entities.dtos.CategoryDtos.CategoryForAddDto;
import Turkcellbootcamp.Springstart.entities.dtos.OrderDtos.OrderForAddDto;
import Turkcellbootcamp.Springstart.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class OrderManager implements OrderService {

    private final OrderRepository orderRepository;
    private OrderDetailService orderDetailService;
    private final ModelMapper modelMapper;

    @Autowired
    public OrderManager(OrderRepository orderRepository, ModelMapper modelMapper) {

        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

    @Override
   @Transactional
    public void add(OrderForAddDto orderForAddDto) {
        //Order'ı db'ye kaydet ki order'ın id'si oluşsun.
        //Oluşan id'yi ve itemları orderDetailService'e gönder. O da id'ye detay eklmelerini yapsın.
       /*                .customer(Customer.builder().customerId(orderForAddDto.getCustomerId()).build())
                .employee(Employee.builder().employeeId(orderForAddDto.getEmployeeId()).build())
                .shippedDate(orderForAddDto.getShippedDate())
                .orderDate(LocalDate.now())
                .shipCity(orderForAddDto.getShipCity())
                .shipAddress(orderForAddDto.getShipAddress())
                .shipName(orderForAddDto.getShipName())
                .shipRegion(orderForAddDto.getShipRegion())
                .requiredDate(orderForAddDto.getRequiredDate())
                .shipPostalCode(orderForAddDto.getShipPostalCode())
                .build();
        order=orderRepository.save(order);
        orderDetailService.addItemsToOrder(order, request.getItems());*/
        //--->OTOMATİK MAPLEME
        Order orderFromAutoMapping=modelMapper.map(orderForAddDto,Order.class);
        orderFromAutoMapping=orderRepository.save(orderFromAutoMapping);
        //Bu satırdan sonra order'ın id alanı oluşmuş olacak.Yani artık order_details tablosuna order_id verebilecek haldeyiz.
        orderDetailService.addItemsToOrder(orderFromAutoMapping,orderForAddDto.getItems());
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
