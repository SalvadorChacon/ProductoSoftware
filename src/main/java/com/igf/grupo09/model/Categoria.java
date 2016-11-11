package com.igf.grupo09.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_categoria", nullable=false, unique=true)
    private Long id;
    @Column(name="codigo_categoria", unique=true)
    private String codigo;
    @Column(name="nombre_categoria", nullable=false)
    private String nombre;
    
    protected Categoria(){}
    
    public Categoria(String codigo, String nombre)
    {
        this.codigo = codigo;
        this.nombre = nombre;
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
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString()
    {
        return String.format("%d, %s %s", this.id, this.codigo, this.nombre);
    }
}
