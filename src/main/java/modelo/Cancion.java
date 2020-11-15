/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author manue
 */
public class Cancion {
    int id;
    String nombre;
    String duracion;
    int ID_disco;

    public Cancion(String nombre, String duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public Cancion() {
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

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getID_disco() {
        return ID_disco;
    }

    public void setID_disco(int ID_disco) {
        this.ID_disco = ID_disco;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Cancion other = (Cancion) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cancion{" + "id=" + id + ", nombre=" + nombre + ", duracion=" + duracion + ", ID_disco=" + ID_disco + '}';
    }
   
}
