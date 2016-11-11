package com.igf.grupo09.controller;

import com.igf.grupo09.model.Categoria;
import com.igf.grupo09.model.Product;
import com.igf.grupo09.persistence.CategoryRepository;
import com.igf.grupo09.persistence.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerProduct {
    
    @Autowired
    private ProductRepository repository;
    @Autowired
    private CategoryRepository categoryRepo;
    
    @RequestMapping("/admin/AdministrarProductos")
    String administrarProductos(Model model)
    {
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
        List<Categoria> categorias = new ArrayList<>();
        for (Categoria c : categoryRepo.findAll())
        {
            categorias.add(c);
        }
        model.addAttribute("categorias", categorias);
        return "admin/AdministrarProductos";
    }
}
