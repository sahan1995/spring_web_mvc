package lk.ijse.dep.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderDetailPK implements Serializable {

    private String itemCode;
    private String orderId;

    public OrderDetailPK(String itemCode, String orderId) {
        this.setItemCode(itemCode);
        this.setOrderId(orderId);
    }

    public OrderDetailPK() {
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderDetailPK{" +
                "itemCode='" + itemCode + '\'' +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
