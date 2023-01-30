package mvc.main;

import mvc.config.SpringConfig;
import mvc.entity.OrdersEntity;
import mvc.entity.ProductEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import mvc.repository.ProductRepository;

import java.time.LocalDate;

public class Main {
    static ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    static ProductRepository productRepository = context.getBean("productRepository", ProductRepository.class);
    public static void main(String[] args) {
        createProduct ();

    }
        public static void createOrders () {
            OrdersEntity ordersEntity = new OrdersEntity();
            ordersEntity.setCustomerName("ty");
            ordersEntity.setDate(LocalDate.now());
            ordersEntity.setCustomerAddress("92 quang trung");

            OrdersEntity ordersEntity1 = new OrdersEntity();
            ordersEntity1.setCustomerName("tai");
            ordersEntity1.setDate(LocalDate.now());
            ordersEntity1.setCustomerAddress("84 quang trung");

            ProductEntity productEntity = createProduct();
        }

        public static ProductEntity createProduct () {
            ProductEntity productEntity = new ProductEntity();
            productEntity.setName("do hop");
            productEntity.setPrice(20.0);

            productRepository.save(productEntity);
            return productEntity;
        }

}
