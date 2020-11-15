/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.PlayList;
import modelo.Usuario;

/**
 *
 * @author manue
 */
public class UsuarioDAO extends Usuario {

   public final String SELECTall = "SELECT * FROM usuario";
    Connection con;

    public UsuarioDAO() {
        this.con = Conection.GetConnection();
    }
    
    

    public List<Usuario> SelectUsuarios(String Query) throws SQLException {
        ArrayList<Usuario> usuarios = new ArrayList<>();
     

        if (con != null) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Query);
            try {
                while (rs != null && rs.next()) {
                    Usuario User = new Usuario();
                    int id = rs.getInt(1);
                    String Correo = rs.getString(2);
                    String Nombre = rs.getString(3);
                    String Foto = rs.getString(4);

                    User.setId(id);
                    User.setCorreo(Correo);
                    User.setNombre(Nombre);
                    User.setFoto(Foto);
                    ArrayList <PlayList> L = new ArrayList<>();
                    User.setMisListas(L);
                  
                    //DAO lista de ese usuario
                    usuarios.add(User);
                }
            } finally {
                rs.close();
                st.close();
            }
        }
        return usuarios;

    }

    public Usuario SelectUsuarioID(int Id) throws SQLException {

        con = Conection.GetConnection();
        Usuario user = new Usuario();

        if (con != null) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM USUARIO WHERE id =" + Id);
            try {
                while (rs != null) {
                    user = new Usuario();
                    int id = rs.getInt(1);
                    String Correo = rs.getString(2);
                    String Nombre = rs.getString(3);
                    String Foto = rs.getString(4);

                    user.setId(id);
                    user.setCorreo(Correo);
                    user.setNombre(Nombre);
                    user.setFoto(Foto);

                    return user;
                }
            } finally {
                rs.close();
                st.close();
            }

        }
        return user;
    }

    public void InsertUser(Usuario user) throws SQLException {
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("INSERT INTO usuario(correo,nombre,foto)VALUES(?,?,?)");

            ps.setString(1, user.getCorreo());
            ps.setString(2, user.getNombre());
            ps.setString(3, user.getFoto());
   if(ps.executeUpdate()==0) {
                  throw new SQLException("NO se ha insertado correctamente");
              }
        } finally {
            if (ps != null) {
                ps.close();
            }

        }
    }

    public void DeleteUser(int id) throws SQLException {
        Statement st = null;

        try {
            if (con != null) {

                st = con.createStatement();

                st.executeUpdate("DELETE FROM usuario WHERE ID=" + id);
            }

        } finally {
            if (con != null) {
                st.close();
            }
        }
    }
    
       public void updateUserInfo(int id) throws SQLException {
        Statement st = null;

        try {
            if (con != null) {
                Usuario user = new Usuario();
                st = con.createStatement();
                System.out.println("Introduzca nuevo correo del usuario");
                user.setCorreo(utilities.Utilidades.getString());
                  System.out.println("Introduzca nuevo nombre de usuario");
                user.setNombre(utilities.Utilidades.getString());
                      System.out.println("Introduzca nuevo foto del usuario");
                user.setFoto(utilities.Utilidades.getString());

                st.executeUpdate("UPDATE  Usuario "
     + "SET " + "correo="+user.getCorreo()+","
               + "nombre="+user.getNombre()+","
               + "foto="+user.getFoto()+"  WHERE id=" + id);
            }

        } finally {
            if (con != null) {
                st.close();
            }
        }
    }


}
