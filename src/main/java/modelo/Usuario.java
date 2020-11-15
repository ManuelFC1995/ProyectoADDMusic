/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.PlayList;
import java.util.ArrayList;


public class Usuario {

    private int id;
    private String nombre;
    private String correo;
    private String foto;
    private ArrayList<PlayList> MisListas;
    private ArrayList<PlayList> ListaSuscripcion;
    
    
    public Usuario(int id, String nombre, String correo,String foto, Object unknow ) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.foto = foto;
        this.MisListas=null;
        this.ListaSuscripcion=null;
    }

    public Usuario() {
        this.id=0;
        this.nombre="desconocido";
        this.correo="generico";
        this.foto="no";
         this.MisListas=null;
        this.ListaSuscripcion=null;
        
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }


    public ArrayList<PlayList> getMisListas() {
        return MisListas;
    }

    public void setMisListas(ArrayList<PlayList> MisListas) {
        this.MisListas = MisListas;
    }

    public ArrayList<PlayList> getListaSuscripcion() {
        return ListaSuscripcion;
    }

    public void setListaSuscripcion(ArrayList<PlayList> ListaSuscripcion) {
        this.ListaSuscripcion = ListaSuscripcion;
    }

    @Override
    public String toString() {
        return "id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", foto=" + foto + ", MisListas=" + MisListas + ", ListaSuscripcion=" + ListaSuscripcion + '}';
    }
    
    
}
