package mvc.controller;

import mvc.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import mvc.repository.ProductRepository;

import java.util.List;

@Controller

@RequestMapping(value="/")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String showProduct(Model model) {
        List<ProductEntity> list = (List<ProductEntity>) productRepository.findAll();
        model.addAttribute("product",list);

        return "productList";
    }
    //============add==================
    @RequestMapping(value = "/newProduct", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String showAddProduct(Model model) {
        model.addAttribute("product",new ProductEntity());
        return "newProduct";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String addProduct(ProductEntity productEntity) {
        productRepository.save(productEntity);
        return "redirect:/";
    }
    //===========delete==========
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable int id) {
        productRepository.deleteById(id);
        return "redirect:/";
    }

    //===========edit===============

//
//    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
//    public String updateProduct(@PathVariable int id,@ModelAttribute
//                                @RequestParam("name") String name,
//                                @RequestParam("price") Double price,
//                                @RequestParam("productDescription") String productDescription) {
//        ProductEntity productEntities = productRepository.findById(id).get();
//        productEntities.setName(name);
//        productEntities.setPrice(price);
//        productEntities.setProductDescription(productDescription);
//        productRepository.save(productEntity);
//        return "redirect:/";
//    }

    //=============searech==============
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam("searchInput") String searchInput, Model model) {
        List<ProductEntity> searchList;
        if (searchInput.isEmpty()) {
            searchList = (List<ProductEntity>) productRepository.findAll();
        } else {
            searchList = productRepository.findByNameContaining(searchInput);
        }
        model.addAttribute("product",searchList);
        return "productList";
    }

    //=================update2============

//        @RequestMapping(value = "/edit", method = RequestMethod.GET)
//    public String showNewBook(Model model) {
//        model.addAttribute("product", new ProductEntity());
//        model.addAttribute("msg", "Add a new product");
//        model.addAttribute("action", "newProduct");
//        model.addAttribute("type", "newProduct");
//        return "updateProduct";
//    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String showUpdateProduct(Model model, @PathVariable int id) {
        model.addAttribute("msg", "Update product information");
        model.addAttribute("type", "update");
        model.addAttribute("product", productRepository.findById(id));
        return "updateProduct";
    }

    @RequestMapping(value = "/edit/update", method = RequestMethod.POST)
    public String updateProduct(@ModelAttribute ProductEntity product){
        System.out.println(product.toString());
        productRepository.save(product);
        return "redirect:/";
    }
}
