package com.MSebas55.pruebaspring.controllers;

import com.MSebas55.pruebaspring.models.Product;
import com.MSebas55.pruebaspring.servicies.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/all")
    public List<Product> getAllProduct() {
        return productService.getAllProducts();
    }

    @GetMapping("/by-id/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    @PostMapping("/save")
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/allNames")
    public List<String> getAllProductNames() {
        List<Product> allProducts = productService.getAllProducts();
        List<String> allNames = new ArrayList<String>();

        for (Product product: allProducts) {
            allNames.add(product.getName());
        }
        return allNames;
    }

    @GetMapping("/under/{price}")
    public List<Product> getProductsUnderPrice(@PathVariable String cad) {
        List<Product> allProducts = productService.getAllProducts();
        List<Product> returnProducts = new ArrayList<Product>();

        for (Product product: allProducts) {
            if (product.getName().contains(cad)) {
                returnProducts.add(product);
            }
        }
        return returnProducts;
    }
    @GetMapping("/like/{cad}")
    public List<Product> getProductsLike(@PathVariable String cad) {
        List<Product> allProducts = productService.getAllProducts();
        List<Product> returnProducts = new ArrayList<Product>();
        cad = cad.toUpperCase();

        for (Product product: allProducts) {
            if (product.getName().toUpperCase().contains(cad)) {
                returnProducts.add(product);
            }
        }
        return returnProducts;
    }
    @DeleteMapping("/delete/{id}")
    public Boolean deleteProduct(@PathVariable Integer id) {
        return productService.deleteProduct(id);
    }
}
