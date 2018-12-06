package lk.ijse.dep.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    @Id
    private String id;
    private String name;
    private String address;
    private String test;
    @OneToMany(mappedBy = "customer",cascade = {CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.EAGER)
    private List<Order> orderList = new ArrayList<>();

//    public Customer(String id, String name, String address, List<Order> orderList) {
//        this.id = id;
//        this.name = name;
//        this.address = address;
//        this.setOrderList(orderList);
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public Customer() {
    }

    public Customer(String id, String name, String address) {

        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
