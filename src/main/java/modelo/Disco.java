/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author manue
 */
public class Disco {
   int id;
   String nombre;
   String foto;
   String fecha;
   int id_artista;
   ArrayList<Cancion> canciones ;

    public Disco( String nombre, String foto, String fecha) {
    
        this.nombre = nombre;
        this.foto = foto;
        this.fecha = fecha;
        this.id_artista=0;
        this.canciones=null;
    }

    public Disco() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId_artista() {
        return id_artista;
    }

    public void setId_artista(int id_artista) {
        this.id_artista = id_artista;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
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
        final Disco other = (Disco) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    	
    public String convertirFechaString(Date date){
	
   return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);	
}
   
}
