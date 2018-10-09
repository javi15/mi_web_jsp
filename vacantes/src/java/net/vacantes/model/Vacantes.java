/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.vacantes.model;

import java.util.Date;

/**
 *
 * @author javier
 */
public class Vacantes {
    
    private int id;
    private Date fechapublicacion;
    private String nombre,detalle,descripcion;
    
    public Vacantes(int id){
        this.fechapublicacion = new Date();
        this.id = id;
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechapublicacion() {
        return fechapublicacion;
    }

    public void setFechapublicacion(Date fechapublicacion) {
        this.fechapublicacion = fechapublicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Vacantes{" + "id=" + id + ", fechapublicacion=" + fechapublicacion + ", nombre=" + nombre + ", detalle=" + detalle + ", descripcion=" + descripcion + '}';
    }

    public boolean insert(Vacantes vct) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
