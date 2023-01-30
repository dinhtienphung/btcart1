package mvc.service;

import mvc.config.SpringConfig;
import mvc.entity.CartEntity;
import mvc.entity.OrderDetailEntity;
import mvc.repository.OderDetailRepository;
import mvc.repository.OdersRepository;
import mvc.repository.ProductRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@SessionScope
public class CartService {
    static ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    static OdersRepository odersRepository = context.getBean("OdersRepository", OdersRepository.class);
    static OderDetailRepository oderDetailRepository = context.getBean("oderDetailRepository", OderDetailRepository.class);
    static ProductRepository productRepository  = context.getBean("productRepository", ProductRepository.class);

Map<Integer, CartEntity> list = new HashMap<>();
    public static int calTotalAmount (CartEntity cart){
        int totalMount = 0;
        List<OrderDetailEntity> orderDetailEntities = cart.getOrdersEntity().getOrderDetailEntities();
        for (OrderDetailEntity orderDetailEntity : orderDetailEntities)
            totalMount += orderDetailEntity.getQuantity()*orderDetailEntity.getProductEntity().getPrice();

            return totalMount;
    }
    public Collection<CartEntity> allCart () {
        return list.values();
    }
}

