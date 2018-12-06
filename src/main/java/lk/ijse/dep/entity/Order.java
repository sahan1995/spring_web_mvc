package lk.ijse.dep.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "`Order`")
public class Order {
    @Id
    private String 	id;
    private Date date;
    @ManyToOne(cascade = {CascadeType.PERSIST},fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId",referencedColumnName = "id")
    private Customer customer;

    @OneToMany(mappedBy = "order",cascade = {CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.EAGER)
    private List<OrderDetail> orderDetails = new ArrayList<>();


    public String getOrderID() {
        return id;
    }

    public void setOrderID(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Order(String orderID, Date date, Customer customer) {
        this.id = orderID;
        this.date = date;
        this.setCustomer(customer);
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "OrderService{" +
                "orderID='" + id + '\'' +
                ", date=" + date +
                ", customer=" + getCustomer() +
                '}';
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }



}
