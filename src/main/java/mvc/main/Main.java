package mvc.main;

import mvc.config.SpringConfig;
import mvc.entity.OrderDetailEntity;
import mvc.entity.OrdersEntity;
import mvc.entity.ProductEntity;
import mvc.repository.OrderDetailRepository;
import mvc.repository.OrdersRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import mvc.repository.ProductRepository;

import java.time.LocalDate;

public class Main {
    static ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    static ProductRepository productRepository = context.getBean("productRepository", ProductRepository.class);
    static OrderDetailRepository orderDetailRepository = context.getBean("oderDetailRepository", OrderDetailRepository.class);
    static OrdersRepository ordersRepository = context.getBean("odersRepository", OrdersRepository.class);
    public static void main(String[] args) {
//        createOrders ();
//        createOrderDetail();
//        createProduct();

    }
        public static OrdersEntity createOrders () {
            OrdersEntity ordersEntity = new OrdersEntity();
            ordersEntity.setCustomerName("ty");
            ordersEntity.setDate(LocalDate.now());
            ordersEntity.setCustomerAddress("92 quang trung");
            ordersRepository.save(ordersEntity);
            return ordersEntity;
        }

        public static OrderDetailEntity createOrderDetail () {
            OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
            orderDetailEntity.setQuantity(15);

            orderDetailRepository.save(orderDetailEntity);
            return orderDetailEntity;
        }

        public static ProductEntity createProduct () {
            ProductEntity productEntity = new ProductEntity();
            productEntity.setName("do hop");
            productEntity.setPrice(20.0);
            productEntity.setProductDescription("su dung 1 lan");

            productRepository.save(productEntity);
            return productEntity;
        }

}
