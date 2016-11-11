package com.igf.grupo09.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Product {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idProducto", unique=true, nullable=false)
    private Long id;
    @Column(nullable=false)
    private String nameProduct;
    private String description;
    @Column(nullable=false)
    private double priceProduct;
    @Column(nullable=false)
    private String codeProduct;
    @OneToOne
    private Categoria categoria;
    
    protected Product(){}
    
    public Product(String name, String desc, double price, String code)
    {
        this.nameProduct = name;
        this.description = desc;
        this.priceProduct = price;
        this.codeProduct = code;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the nameProduct
     */
    public String getNameProduct() {
        return nameProduct;
    }

    /**
     * @param nameProduct the nameProduct to set
     */
    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the priceProduct
     */
    public double getPriceProduct() {
        return priceProduct;
    }

    /**
     * @param priceProduct the priceProduct to set
     */
    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    /**
     * @return the codeProduct
     */
    public String getCodeProduct() {
        return codeProduct;
    }

    /**
     * @param codeProduct the codeProduct to set
     */
    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }
    
    @Override
    public String toString()
    {
        return String.format("%d %s %s %f %s", id, nameProduct, description, priceProduct, codeProduct);
    }

    /**
     * @return the categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
}
