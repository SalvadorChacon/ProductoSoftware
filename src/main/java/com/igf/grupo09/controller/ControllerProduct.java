package com.igf.grupo09.controller;

import com.igf.grupo09.model.Product;
import com.igf.grupo09.persistence.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerProduct {
    
    @Autowired
    private ProductRepository repository;
    
    @RequestMapping("/AdministrarProductos")
    @ResponseBody
    String home()
    {
        String answer = "";
        repository.save(new Product("The Dark Tower", "Science Fiction", 25.75, "1001001110"));
        repository.save(new Product("The Dark Tower II", "Science Fiction", 35.00, "100110011"));
        repository.save(new Product("The Dark Tower III", "Science Fiction", 42.00, "100110010"));
        repository.save(new Product("The Dark Tower IV", "Science Fiction", 23.30, "100100111"));
        for (Product product : repository.findAll())
        {
            answer += product.toString();
            answer += " ";
        }
        return answer;
    }
    
    
}
