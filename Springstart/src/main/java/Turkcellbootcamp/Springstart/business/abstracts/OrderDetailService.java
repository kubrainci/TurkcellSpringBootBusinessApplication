package Turkcellbootcamp.Springstart.business.abstracts;

import Turkcellbootcamp.Springstart.entities.concretes.Order;
import Turkcellbootcamp.Springstart.entities.dtos.OrderDetailDtos.OrderDetailForAddDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface OrderDetailService {
      void addItemsToOrder(Order order, List<OrderDetailForAddDto> items);
}
