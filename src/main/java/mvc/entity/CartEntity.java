package mvc.entity;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CartEntity {
    private OrderDetailEntity orderDetailEntity;
    private ProductEntity productEntity;
    private OrdersEntity ordersEntity;

    private int quantity;

    public CartEntity() {
    }

    public CartEntity(OrderDetailEntity orderDetailEntity, ProductEntity productEntity, int quantity) {
        this.orderDetailEntity = orderDetailEntity;
        this.productEntity = productEntity;
        this.quantity = quantity;
    }

    public OrderDetailEntity getOrderDetailEntity() {
        return orderDetailEntity;
    }

    public void setOrderDetailEntity(OrderDetailEntity orderDetailEntity) {
        this.orderDetailEntity = orderDetailEntity;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrdersEntity getOrdersEntity() {
        return ordersEntity;
    }

    public void setOrdersEntity(OrdersEntity ordersEntity) {
        this.ordersEntity = ordersEntity;
    }
}
