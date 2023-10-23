package Turkcellbootcamp.Springstart.controlleres;

import Turkcellbootcamp.Springstart.business.abstracts.OrderService;
import Turkcellbootcamp.Springstart.entities.concretes.Order;
import Turkcellbootcamp.Springstart.entities.dtos.OrderDtos.OrderForAddDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
@RequiredArgsConstructor
public class OrderController {

   private final OrderService orderService;
   private final MessageSource messageSource;
   @GetMapping("getAll")
    public List<Order> getAll(){

       return orderService.getAll();
    }


    @GetMapping("getById")
    public Order getOrderById(@PathVariable short id){
       return orderService.getById(id);

    }
    @DeleteMapping("delete")
    public ResponseEntity delete(@RequestParam("id") short id, Order order){
       orderService.delete(id);
       return new ResponseEntity(messageSource.getMessage("orderDeleted",new Object[]{id}, LocaleContextHolder.getLocale()),HttpStatus.CREATED);

    }
    @PostMapping("add")
    public ResponseEntity add(@RequestBody @Valid OrderForAddDto orderForAddDto){
       orderService.add(orderForAddDto);
       return new ResponseEntity(messageSource.getMessage("orderAdded",null,LocaleContextHolder.getLocale()),HttpStatus.CREATED);

    }
    @PutMapping("update")
    public ResponseEntity update(@RequestParam short id,@RequestBody Order order){
       orderService.update(id,order);
       return new ResponseEntity(messageSource.getMessage("orderUpdated",new Object[]{id},LocaleContextHolder.getLocale()),HttpStatus.CREATED);

    }
    

}
