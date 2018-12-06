package lk.ijse.dep.service;

import lk.ijse.dep.dto.OrderDTO;
import lk.ijse.dep.dto.OrderDetailDTO;
import lk.ijse.dep.entity.Order;

import java.util.List;

public interface OrderService {

    List<OrderDTO> getAllOrders();

    void saveOrder(String oId,OrderDTO orderDTO);

    void deleteOrder(String orderID);



}
