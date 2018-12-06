package lk.ijse.dep.dto;

import lk.ijse.dep.entity.Customer;
import lk.ijse.dep.entity.OrderDetail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDTO {

    private String id;
    private Date date;
    private CustomerDTO customer;
    private List<OrderDetailDTO> orderDetails = new ArrayList<>();

//    public OrderDTO(String id, Date date, Customer customer, List<OrderDetail> orderDetails) {
//        this.setId(id);
//        this.setDate(date);
//        this.setCustomer(customer);
//        this.setOrderDetails(orderDetails);
//    }

    public OrderDTO(String id, Date date, CustomerDTO customer) {
        this.setId(id);
        this.setDate(date);
        this.setCustomer(customer);
    }

    public OrderDTO() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public List<OrderDetailDTO> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailDTO> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", customer=" + customer +
//                ", orderDetails=" + orderDetails +
                '}';
    }
}
