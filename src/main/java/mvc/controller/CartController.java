package mvc.controller;

import mvc.entity.CartEntity;
import mvc.entity.OrderDetailEntity;
import mvc.entity.OrdersEntity;
import mvc.entity.ProductEntity;
import mvc.repository.OrderDetailRepository;
import mvc.repository.OrdersRepository;
import mvc.repository.ProductRepository;
import mvc.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping(value="/cart")
public class CartController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartService cartService;
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String showCart(Model model){


        model.addAttribute("allCart", cartService.allCart());
        double amount =cartService.getAmount();

        model.addAttribute("cartAmount", amount);
        return "cart";
    }

    @RequestMapping(value="/add/{id}",method = RequestMethod.GET)
    public String addCart (Model model, @PathVariable int id) {
        ProductEntity product = productRepository.findById(id).get();
        CartEntity cart = new CartEntity();
        cart.setProductEntity(product);
        cartService.addCart(cart);
        System.out.println("success");
        return "redirect:/cart";
    }

    @RequestMapping(value="/remove/{id}",method = RequestMethod.GET)
    public String remove ( @PathVariable int id) {
            cartService.removeCart(id);
        return "redirect:/cart";
    }

    @RequestMapping(value="/checkout",method = RequestMethod.GET)
    public String checkout (Model model) {
        model.addAttribute("order", new OrdersEntity());
                return "checkout";
    }

    @RequestMapping(value="/checkout",method = RequestMethod.POST)
    public String user (OrdersEntity ordersEntity) {
        OrdersEntity ordersEntity1 = ordersRepository.getByCustomerName(ordersEntity.getCustomerName());
        if (ordersEntity1 != null) {
            ordersRepository.save(ordersEntity1);
            Collection<CartEntity> cartEntities = cartService.allCart();
            for (CartEntity cart : cartEntities) {
                OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
                ProductEntity product = productRepository.findById(cart.getProductEntity().getId()).get();
                orderDetailEntity.setQuantity(cart.getQuantity());
                orderDetailEntity.setOrdersEntity(ordersEntity1);
                orderDetailEntity.setProductEntity(product);
                orderDetailRepository.save(orderDetailEntity);
            }
        } else {
            ordersRepository.save(ordersEntity);
            Collection<CartEntity> cartEntities = cartService.allCart();
            for (CartEntity cart : cartEntities) {
                OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
                ProductEntity product = productRepository.findById(cart.getProductEntity().getId()).get();
                orderDetailEntity.setQuantity(cart.getQuantity());
                orderDetailEntity.setOrdersEntity(ordersEntity);
                orderDetailEntity.setProductEntity(product);
                orderDetailRepository.save(orderDetailEntity);
            }
        }
        cartService.clear();
        return "redirect:/cart";
    }
    @RequestMapping(value="/orderList",method = RequestMethod.GET)
    public String showOrder (Model model) {
        List<OrdersEntity> entityList = (List<OrdersEntity>) ordersRepository.findAll();
        model.addAttribute("orderDetail", entityList);
        return "orderList";
    }
    @RequestMapping(value="/orderList/{id}",method = RequestMethod.GET)
    public String showOderDetail (Model model, @PathVariable int id) {
        OrdersEntity ordersEntity = ordersRepository.findById(id).get();
        model.addAttribute("order", ordersEntity);
        List<OrderDetailEntity> orderDetailEntities = orderDetailRepository.getorderDetailByOrderId(id);
        model.addAttribute("orderDetail", orderDetailEntities);
        return "orderDetailList";
    }

    @RequestMapping(value = "/orderList/deleteCart/{id}", method = RequestMethod.GET)
    public String deleteCart(@PathVariable int id) {
        ordersRepository.deleteById(id);

        return "orderList";
    }

}
