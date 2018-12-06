package lk.ijse.dep.dto;

import lk.ijse.dep.entity.Item;
import lk.ijse.dep.entity.Order;

public class OrderDetailDTO {

    private String itemcode;
    private String orderID;
    private int qty;
    private double unitPrice;
    private OrderDTO order;
    private ItemDTO item;

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
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

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    public ItemDTO getItem() {
        return item;
    }

    public void setItem(ItemDTO item) {
        this.item = item;
    }

    public OrderDetailDTO(String itemcode, String orderID, int qty, double unitPrice) {
        this.itemcode = itemcode;
        this.orderID = orderID;
        this.qty = qty;
        this.unitPrice = unitPrice;

    }

    public OrderDetailDTO() {
    }

    @Override
    public String toString() {
        return "OrderDetailDTO{" +
                "itemcode='" + itemcode + '\'' +
                ", orderID='" + orderID + '\'' +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                ", order=" + order +
                ", item=" + item +
                '}';
    }


}
