package lk.ijse.dep.service.impl;

import lk.ijse.dep.dto.CustomerDTO;
import lk.ijse.dep.dto.OrderDTO;
import lk.ijse.dep.dto.OrderDetailDTO;
import lk.ijse.dep.entity.Customer;
import lk.ijse.dep.entity.Order;
import lk.ijse.dep.entity.OrderDetail;
import lk.ijse.dep.repository.OrderRepository;
import lk.ijse.dep.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Override
    public List<OrderDTO> getAllOrders() {
        var orderlist = orderRepository.findAll();
        var orderDTOList = new ArrayList<OrderDTO>();

        for (Order order : orderlist) {
            List<OrderDetail> orderDetails = order.getOrderDetails();

            orderDTOList.add(new OrderDTO(order.getOrderID(),order.getDate(),new CustomerDTO(order.getCustomer().getId(),order.getCustomer().getName(),order.getCustomer().getAddress())));




        }


//        System.out.println(orderDTOList);
        return orderDTOList;

    }

    @Override
    public void saveOrder(String oId,@RequestBody OrderDTO orderDTO) {

        if(!oId.equals(orderDTO.getId())){
            throw new RuntimeException("Not Same");
        }
//        orderRepository.save(new Order(orderDTO.getId(),orderDTO.getDate(),orderDTO.getCustomer(),orderDTO.getOrderDetails()));


    }

    @Override
    public void deleteOrder(String orderID) {

    }
}
