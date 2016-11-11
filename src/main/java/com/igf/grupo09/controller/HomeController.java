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
    String home()
    {
        return "index";
    }
   
}
