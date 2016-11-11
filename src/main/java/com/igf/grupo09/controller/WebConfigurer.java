package com.igf.grupo09.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfigurer extends WebMvcConfigurerAdapter {
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/mensaje").setViewName("mensaje");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/admin/AdministrarProductos").setViewName("AdministrarProductos");
    }
    
}
