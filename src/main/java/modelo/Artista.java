/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author manue
 */
public class Artista {
    int id;
    String nombre;
    String nacionalidad;
    String foto;
    ArrayList<Disco> Discos;
   

    public Artista( String nombre, String nacionalidad, String foto) {
       
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.foto = foto;
        this.Discos=null;
    }

    public Artista() {
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

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public ArrayList<Disco> getDiscos() {
        return Discos;
    }

    public void setDiscos(ArrayList<Disco> Discos) {
        this.Discos = Discos;
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Artista other = (Artista) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Artista{" + "id=" + id + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", foto=" + foto + ", Discos=" + Discos + '}';
    }
    
    
    
    
}
