package com.MSebas55.pruebaspring.repositories;

import com.MSebas55.pruebaspring.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
