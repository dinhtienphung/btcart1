package mvc.entity;

import javax.persistence.*;

@Entity
@Table(name = "orderdetail")

public class OrderDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;

    @Column (name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private OrdersEntity ordersEntity;

    @ManyToOne
    @JoinColumn(name = "productId")
    private ProductEntity productEntity;


    public OrderDetailEntity() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }


    @Override
    public String toString() {
        return "OrderDetailEntity{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}
