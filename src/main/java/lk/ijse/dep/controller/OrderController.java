package lk.ijse.dep.controller;

import lk.ijse.dep.dto.OrderDTO;
import lk.ijse.dep.entity.Order;
import lk.ijse.dep.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public String handleMyExeception(RuntimeException ex){
        ex.printStackTrace();
        return ex.getMessage();
    }
    @Autowired
    private OrderService orderService;


    @GetMapping
    public List<OrderDTO> getAllOrders(){
        System.out.println(orderService.getAllOrders());
        return orderService.getAllOrders();
    }



}
