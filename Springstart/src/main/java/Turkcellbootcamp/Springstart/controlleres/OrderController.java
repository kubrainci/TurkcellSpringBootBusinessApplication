package Turkcellbootcamp.Springstart.controlleres;

import Turkcellbootcamp.Springstart.business.abstracts.OrderService;
import Turkcellbootcamp.Springstart.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

   private final OrderService orderService;

   @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

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
       return new ResponseEntity("Şipariş silindi", HttpStatus.CREATED);

    }
    @PostMapping("add")
    public ResponseEntity add(@RequestBody Order order){
       orderService.add(order);
       return new ResponseEntity("Şipariş eklendi",HttpStatus.CREATED);

    }
    @PutMapping("update")
    public ResponseEntity update(@RequestParam short id,@RequestBody Order order){
       orderService.update(id,order);
       return new ResponseEntity("Şipariş güncellendi.",HttpStatus.CREATED);

    }

}
