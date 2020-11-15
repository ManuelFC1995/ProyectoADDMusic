/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import data.CancionDAO;
import data.Conection;
import data.UsuarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.PlayList;
import utilities.Utilidades;

/**
 *
 * @author manue
 */
public class PlayLIstDAO extends PlayList  {

    Connection con;

    public PlayLIstDAO() {
        this.con =  Conection.GetConnection();
    }

   

    public List<PlayList> SelectPlayList() throws SQLException {
        ArrayList<PlayList> Listas = new ArrayList<>();
   

        if (con != null) {
            Statement st = con.createStatement();
            try (ResultSet rs = st.executeQuery("SELECT id,nombre,descripcion from lista order by id")) {
                while (rs != null && rs.next()) {
                    PlayList PL = new PlayList();
                    int id = rs.getInt(1);
                    String Nombre = rs.getString(2);
                    String Descripcion = rs.getString(3);
                 

                    PL.setId(id);
                    PL.setDescripcion(Descripcion);
                    PL.setNombre(Nombre);
              
               
                   
                      Listas.add(PL);
                }
            } finally {
                st.close();
            }
        }
        return Listas;
    }
    
      public void InsertPlaylist() throws SQLException {
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("INSERT INTO lista(Nombre,Descripcion,ID_usuario)VALUES(?,?,?)");
 System.out.println("Introduzca  Nombre de la PlayLIst");
             String Nombre=(utilities.Utilidades.getString());
              System.out.println("Introduzca Descripcion de la PlayLIst");
             String Desc=(utilities.Utilidades.getString());
                 System.out.println("Introduzca Id del creador de la PlayLIst");
             int IdC=(utilities.Utilidades.getInt());
            ps.setString(1,Nombre);
            
            ps.setString(2,Desc );
            ps.setInt(3,IdC);
              if(ps.executeUpdate()==0) {
                  throw new SQLException("NO se ha insertado correctamente");
              }
        } finally {
            if (ps != null) {
                ps.close();
            }

        }
    }
      
       public void DeletePlist(int id) throws SQLException {
        Statement st = null;

        try {
            if (con != null) {

                st = con.createStatement();

                st.executeUpdate("DELETE FROM lista WHERE ID=" + id);
                    st.executeUpdate("DELETE FROM lista_cancion WHERE id_lista=" + id);
            }

        } finally {
            if (con != null) {
                st.close();
            }
        }
    }
       
       
         public void updatePlayListinfo(int id) throws SQLException {
        Statement st = null;

        try {
            if (con != null) {

                st = con.createStatement();
                System.out.println("Introduzca nuevo Nombre de la PlayList");
                String Nombre=Utilidades.getString();
                  System.out.println("Introduzca nueva Descripcion de la PlayLIst");
                String Descripcion= Utilidades.getString();
                
                  

                st.executeUpdate("UPDATE lista "
     + "SET " + "nombre="+Nombre+","
               + "descripcion="+Descripcion+" WHERE id="+id);
            }

        } finally {
            if (con != null) {
                st.close();
            }
        }
    }
         
         
            public List<PlayList> SelectPlayListUsuario(int idUsuario) throws SQLException {
        ArrayList<PlayList> Listas = new ArrayList<>();
   

        if (con != null) {
            Statement st = con.createStatement();
            try (ResultSet rs = st.executeQuery("SELECT li.id,li.nombre,li.descripcion from usuario as us"
                    + " LEFT JOIN lista as li on li.id_usuario=us.id WHERE us.id="+idUsuario+" order by id")) {
                while (rs != null && rs.next()) {
                    PlayList PL = new PlayList();
                    int id1 = rs.getInt(1);
                    String Nombre = rs.getString(2);
                    String Descripcion = rs.getString(3);
                 

                    PL.setId(id1);
                    PL.setDescripcion(Descripcion);
                    PL.setNombre(Nombre);
              
               
                   
                      Listas.add(PL);
                }
            } finally {
                st.close();
            }
        }
        return Listas;
    }
}
