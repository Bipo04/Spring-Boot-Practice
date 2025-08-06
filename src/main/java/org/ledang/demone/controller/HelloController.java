package org.ledang.demone.controller;

import org.ledang.demone.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HelloController {

    @Controller
    @RequestMapping("/products")
    public class ProductController {

        private List<Product> productList = List.of(
                new Product(1L, "Laptop", "/images/laptop.jpg", "High-end laptop"),
                new Product(2L, "Phone", "/images/iphone.jpg", "Latest smartphone"),
                new Product(3L, "Camera", "/images/camera.jpg", "Professional camera")
        );

        @GetMapping
        public String listProducts(Model model) {
            model.addAttribute("products", productList);
            return "product-list";
        }

        @GetMapping("/view/{id}")
        public String viewProduct(@PathVariable Long id, Model model) {
            Product product = productList.stream()
                    .filter(p -> p.getId().equals(id))
                    .findFirst()
                    .orElse(null);

            if (product == null) {
                return "not-found";
            }

            model.addAttribute("product", product);
            return "product-detail";
        }
    }
}
