package Turkcellbootcamp.Springstart.business.abstracts;

import Turkcellbootcamp.Springstart.entities.Order;
import Turkcellbootcamp.Springstart.entities.dtos.OrderDetailDtos.OrderDetailForAddDto;
import Turkcellbootcamp.Springstart.entities.dtos.OrderDtos.OrderForAddDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface OrderDetailService {
      void addItemsToOrder(Order order, List<OrderDetailForAddDto> items);
}
