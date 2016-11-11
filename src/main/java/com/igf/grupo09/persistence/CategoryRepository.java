package com.igf.grupo09.persistence;

import com.igf.grupo09.model.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Categoria, Long> {
    
}
