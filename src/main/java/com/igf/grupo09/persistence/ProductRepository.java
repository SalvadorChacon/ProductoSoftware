package com.igf.grupo09.persistence;

import com.igf.grupo09.model.Product;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    
    List<Product> findByNameProduct(String name);
}