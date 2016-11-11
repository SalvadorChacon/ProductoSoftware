
package com.igf.grupo09.controller;


import com.igf.grupo09.model.Categoria;
import com.igf.grupo09.persistence.CategoryRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController{
    
    @Autowired
    private CategoryRepository repository;
    
    @RequestMapping("/admin/categorias/administrar_categorias")
    String administrarCategorias(Model model)
    {
        List<Categoria> categorias = new ArrayList();
        for (Categoria c : repository.findAll())
        {
            categorias.add(c);
        }
        model.addAttribute("categorias", categorias);
   
        return "admin/categorias/administrar_categorias";
    }
  
    @RequestMapping("/admin/categorias/agregar_categoria")
    String addCategory(Model model)
    {
        model.addAttribute("categoria", new Categoria("", ""));
        return "admin/categorias/agregar_categoria";
    }
    
    @RequestMapping("/admin/categorias/guardar_categoria")
    String save(Model model, Categoria categoria)
    {
        String answer = "";
        try{
            repository.save(categoria);
            answer = "Saved Succesfully";
        }
        catch (Exception e)
        {
            answer = "Something went wrong";
        }
        
        model.addAttribute("res", answer);
        List<Categoria> categorias = new ArrayList();
        for (Categoria c : repository.findAll())
        {
            categorias.add(c);
        }
        model.addAttribute("categorias", categorias);
        return "admin/categorias/administrar_categorias";
    }
    
    @RequestMapping("/admin/categorias/eliminar_categoria/{id}")
    String delete(@PathVariable("id")Long id, Model model)
    {
        String answer = "";
        try{
            repository.delete(id);
            answer = "Categoría Eliminada";
        }
        catch (Exception ex)
        {
            answer = "Algo salió mal";
        }
        model.addAttribute("res", answer);
        List<Categoria> categorias = new ArrayList();
        for (Categoria c : repository.findAll())
        {
            categorias.add(c);
        }
        model.addAttribute("categorias", categorias);
        return "admin/categorias/administrar_categorias";
    }
}
