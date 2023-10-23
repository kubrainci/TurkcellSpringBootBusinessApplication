package Turkcellbootcamp.Springstart.business.concretes;

import Turkcellbootcamp.Springstart.business.abstracts.OrderDetailService;
import Turkcellbootcamp.Springstart.business.abstracts.ProductService;
import Turkcellbootcamp.Springstart.entities.Order;
import Turkcellbootcamp.Springstart.entities.OrderDetail;
import Turkcellbootcamp.Springstart.entities.Product;
import Turkcellbootcamp.Springstart.entities.dtos.OrderDetailDtos.OrderDetailForAddDto;
import Turkcellbootcamp.Springstart.repositories.OrderDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor

public class OrderDetailManager implements OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;
    private final ProductService productService;

    @Override
    public void addItemsToOrder(Order order, List<OrderDetailForAddDto> items) {
        for (OrderDetailForAddDto item: items){
            OrderDetail orderDetail=OrderDetail.builder()
                    .product(Product.builder().productId(item.getProductId()).build())
                    .order(Order.builder().orderId(order.getOrderId()).build())
                    .discount(0)
                    .quantity(item.getQuantity())
                    .unitPrice(0)// TODO: Find product and get unit price from productService
                    .build();
            orderDetailRepository.save(orderDetail);
        }

    }
}
