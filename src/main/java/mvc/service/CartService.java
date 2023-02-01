package mvc.service;

import mvc.entity.CartEntity;
import mvc.entity.OrderDetailEntity;
import mvc.entity.ProductEntity;

import java.util.Collection;
import java.util.List;

public interface CartService{

    Collection<CartEntity> allCart();


    void addCart(CartEntity cart);

    double getAmount();

    void removeCart (int id);

    void clear();

}
