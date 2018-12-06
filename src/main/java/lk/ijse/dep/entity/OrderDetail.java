package lk.ijse.dep.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;
@Entity
public class OrderDetail {

    @EmbeddedId
    private OrderDetailPK orderDetailPK;
    private int qty;
    private double unitPrice;

    @ManyToOne
    @JoinColumn(name ="orderId",referencedColumnName = "id",updatable = false,insertable = false)
    private Order order;
    @ManyToOne
    @JoinColumn(name = "itemCode",referencedColumnName = "code",updatable = false,insertable = false)
    private Item item;

    public OrderDetailPK getOrderDetailPK() {
        return orderDetailPK;
    }

    public void setOrderDetailPK(OrderDetailPK orderDetailPK) {
        this.orderDetailPK = orderDetailPK;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public OrderDetail(OrderDetailPK orderDetailPK, int qty, double unitPrice) {
        this.orderDetailPK = orderDetailPK;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public OrderDetail() {
    }

    public OrderDetail(String orderid,String itemcode,int qty, double unitPrice){
        this.orderDetailPK = new OrderDetailPK(itemcode,orderid);
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderDetailPK=" + orderDetailPK +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                '}';
    }

    public OrderDetail(OrderDetailPK orderDetailPK, int qty, double unitPrice, Order order, Item item) {
        this.orderDetailPK = orderDetailPK;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.order = order;
        this.item = item;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
