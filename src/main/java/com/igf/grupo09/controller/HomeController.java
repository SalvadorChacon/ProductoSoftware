package com.igf.grupo09.controller;

import com.igf.grupo09.model.Product;
import com.igf.grupo09.persistence.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    
    @Autowired
    private ProductRepository repository;
    
    @RequestMapping("/")
    String home(Model model)
    {
        repository.save(new Product("The Dark Tower", "Science Fiction", 25.75, "1001001110"));
        repository.save(new Product("The Dark Tower II", "Science Fiction", 35.00, "100110011"));
        repository.save(new Product("The Dark Tower III", "Science Fiction", 42.00, "100110010"));
        repository.save(new Product("The Dark Tower IV", "Science Fiction", 23.30, "100100111"));
        repository.save(new Product("The Dark Tower V", "Science Fiction", 25.00, "100100111"));
        repository.save(new Product("The Dark Tower VI", "Science Fiction", 32.00, "100100111"));
        repository.save(new Product("The Dark Tower VII", "Science Fiction", 47.30, "100100111"));
        List<Product> inventory = new ArrayList();
        for (Product product : repository.findAll())
        {
            inventory.add(product);
        }
        
        List<Product> result = new ArrayList();
        for (int i = 0; i < 3; i++)
        {
            result.add(inventory.get(i));
        }
        model.addAttribute("stock", result);
        return "index";
    }
   
}
