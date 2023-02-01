package mvc.service;

import mvc.entity.CartEntity;
import mvc.entity.ProductEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@SessionScope
public class CartServiceIml implements CartService{
Map<Integer, CartEntity> list = new HashMap<>();

    @Override
    public Collection<CartEntity> allCart() {
        return list.values();
    }

    @Override
    public void addCart(CartEntity cart) {
        CartEntity cart1 = list.get(cart.getProductEntity().getId());
        if(cart1 != null) {
            cart1.setQuantity(cart1.getQuantity() + 1);
        } else {
            cart.setQuantity(1);
            list.put(cart.getProductEntity().getId(), cart);

        }

    }

    @Override
    public double getAmount() {

        return list.values().stream().mapToDouble(item -> item.getQuantity() * item.getProductEntity().getPrice()).sum();
    }

    @Override
    public void removeCart (int id) {
        list.remove(id);
    }

    @Override
    public void clear() {
        list.clear();
    }

}

