/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;


/**
 *
 * @author migue
 */
public class PlayList {
    private int id;
    private String nombre;
    private String descripcion;
    private Usuario Creador;
    private ArrayList<Usuario> subs;
    private ArrayList<Cancion> Canciones;
    
    
    public PlayList(int id, String nombre, String descripcion,Usuario Creador ) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion =  descripcion;
        this.Creador = Creador;
        this.subs=null;
        this.Canciones=null;
       
    }

    public PlayList() {
    }

   
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getCreador() {
        return Creador;
    }

    public void setCreador(Usuario Creador) {
        this.Creador = Creador;
    }

    public ArrayList<Usuario> getSubs() {
        return subs;
    }

    public void setSubs(ArrayList<Usuario> subs) {
        this.subs = subs;
    }

    public ArrayList<Cancion> getCanciones() {
        return Canciones;
    }

    public void setCanciones(ArrayList<Cancion> Canciones) {
        this.Canciones = Canciones;
    }

    @Override
    public String toString() {
        return "PlayList{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion ;
    }
    
}
