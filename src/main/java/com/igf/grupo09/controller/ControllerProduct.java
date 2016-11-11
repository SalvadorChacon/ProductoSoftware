package com.igf.grupo09.controller;

import com.igf.grupo09.model.Product;
import com.igf.grupo09.persistence.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerProduct {
    
    @Autowired
    private ProductRepository repository;
    
    @RequestMapping("/admin/AdministrarProductos")
    String administrarProductos(Model model)
    {
        repository.save(new Product("The Dark Tower", "Science Fiction", 25.75, "1001001110"));
        repository.save(new Product("The Dark Tower II", "Science Fiction", 35.00, "100110011"));
        repository.save(new Product("The Dark Tower III", "Science Fiction", 42.00, "100110010"));
        repository.save(new Product("The Dark Tower IV", "Science Fiction", 23.30, "100100111"));
        repository.save(new Product("The Dark Tower V", "Science Fiction", 25.00, "100100111"));
        repository.save(new Product("The Dark Tower VI", "Science Fiction", 32.00, "100100111"));
        repository.save(new Product("The Dark Tower VII", "Science Fiction", 47.30, "100100111"));
        List<Product> inventory = new ArrayList();
        for (Product p : repository.findAll())
        {
            inventory.add(p);
        }
        model.addAttribute("inventario", inventory);
        model.addAttribute("producto", new Product("Hola", "mundo", 0.00, "desc"));
   
        return "admin/AdministrarProductos";
    }
    
    @RequestMapping("/products/details/{id}")
    String view(@PathVariable("id")Long id, Model model)
    {
        Product product = repository.findOne(id);
        model.addAttribute("product", product);
        return "products/details";
    }
    
    @RequestMapping("admin/agregarProducto")
    String addProduct(Model model)
    {
        model.addAttribute("product", new Product("", "", 0.00, ""));
        return "admin/agregarProducto";
    }
    
    @RequestMapping("/admin/saveProduct")
    String save(Model model, Product producto)
    {
        String answer = "";
        try{
            repository.save(producto);
            answer = "Saved Succesfully";
        }
        catch (Exception e)
        {
            answer = "Something went wrong";
        }
        
        model.addAttribute("res", answer);
        List<Product> inventory = new ArrayList();
        for (Product p : repository.findAll())
        {
            inventory.add(p);
        }
        model.addAttribute("inventario", inventory);
        return "admin/AdministrarProductos";
    }
}
