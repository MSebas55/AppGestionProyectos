package com.MSebas55.pruebaspring.servicies;

import com.MSebas55.pruebaspring.models.Product;
import com.MSebas55.pruebaspring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }
    public Product getProductById(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
    }
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
    public Boolean deleteProduct(Integer id) {
        productRepository.deleteById(id);
        return productRepository.findById(id).isEmpty();
    }
}
