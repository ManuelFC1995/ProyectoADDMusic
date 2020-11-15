package data;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Artista;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author migue
 */

public class ArtistaDAO {
    final String INSERT ="INSERT INTO Artista(nombre,nacionalidad,foto)VALUES(?,?,?)";
    final String UPDATE ="UPDATE Artista SET nombre=?,nacionalidad=?,foto=? WHERE id=?";
    final String DELETE ="DELETE FROM Artista WHERE id= ?";
    final String GETALL = "SELECT id,nombre,nacionalidad FROM Artista";
    final String GETONE = "SELECT id,nombre,nacionalidad FROM Artista WHERE id=?";
    
    
    private Connection conexion;
    
    public ArtistaDAO(Connection conexion){
        this.conexion=conexion;
    }

    public ArtistaDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    


    public void insertar(Artista a) throws DAOException {
            PreparedStatement stat = null;
            ResultSet rs =null;
            try{
                stat =conexion.prepareStatement(INSERT);
                stat.setString(1,a.getNombre());
                stat.setString(2,a.getNacionalidad());
                stat.setString(3,a.getFoto());
                stat.executeUpdate();
                if (stat.executeUpdate()==0){
                    throw new DAOException("Puede que no se haya guardado.");
                }
                rs=stat.getGeneratedKeys();
                if (rs.next()){
                a.setId(rs.getInt(1));
            }else{
                throw new DAOException("No puedon asignar ID a este artista");    
          }
            } catch (SQLException ex) {
                throw new DAOException("Error en SQL",ex);
        }finally{
                if(rs!=null){
                try{
                    rs.close();
                }catch(SQLException ex){
                    new DAOException("Error en SQL",ex);
                }
            }
                if(stat != null){
             try{
                 stat.close();
             }catch(SQLException ex){
                 throw new DAOException("Error en SQL", ex);
             }
        }
                
    }
 }


    public void modificar(int id) throws SQLException, DAOException {
        Statement st = null;
        Artista artist = new Artista();
        try {
            if (conexion != null) {

                st = conexion.createStatement();
                System.out.println("Introduzca nuevo Nombre del Artista");
                artist.setNombre(utilities.Utilidades.getString());
                  System.out.println("Introduzca nueva nacionalidad");
                artist.setNacionalidad(utilities.Utilidades.getString());
                    System.out.println("Introduzca nueva nacionalidad");
                artist.setFoto(utilities.Utilidades.getString());

                st.executeUpdate("UPDATE  cancion "
               + "SET " 
               + "Nombre="+artist.getNombre()+","
               + "nacionalidad="+artist.getNombre()+","
               + "foto="+artist.getFoto()
               +"WHERE ID="+id);
            }

        } finally {
            if (conexion != null) {
                st.close();
            
        }
                
    }
 }


    public void eliminar(int a) throws DAOException, SQLException {
        Statement st = null;

        try {
            if (conexion != null) {

                st = conexion.createStatement();

                st.executeUpdate("DELETE FROM artista WHERE ID=" + a);
            }

        } finally {
            if (conexion != null) {
                st.close();
            }
        }
 }
 

   
     private Artista convertir (ResultSet rs) throws SQLException{
         String nombre = rs.getString("nombre");
         String nacionalidad = rs.getString("nacionalidad");
         String foto = rs.getString("foto");  
         Artista artista= new Artista(nombre,nacionalidad,foto);
         artista.setId(rs.getInt("id"));
         return artista;
     }
    public List<Artista> obtenerTodos() {
        PreparedStatement stat = null;
        ResultSet rs =null;
        List<Artista> artista=new ArrayList<>();
        try{
            stat =conexion.prepareStatement(GETALL);
            rs=stat.executeQuery();
            while(rs.next()){
                artista.add(convertir(rs));
            }
        } catch (SQLException ex) {
             try {
                 throw new DAOException("Error SQL",ex);
             } catch (DAOException ex1) {
                 Logger.getLogger(ArtistaDAO.class.getName()).log(Level.SEVERE, null, ex1);
             }
        }finally{
            if(rs!=null){
                try{
                    rs.close();
                }catch(SQLException ex){
                    new DAOException("Error en SQL",ex);
                }
                if(stat!=null){
                try{
                    stat.close();
                }catch(SQLException ex){
                    new DAOException("Error en SQL",ex);
                }
               }
            }
        }
        return artista;
    }

    public Artista obtener(int id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs =null;
        Artista a=null;
        try{
            stat =conexion.prepareStatement(GETONE);
            stat.setInt(1, id);
            rs=stat.executeQuery();
            if(rs.next()){
                a=convertir(rs);
            }else{
                throw new DAOException("No se ha encontrado ese registro.");
            }
        } catch (SQLException ex) {
            throw new DAOException("Error SQL",ex);
        }finally{
            if(rs !=null){
                try{
                    rs.close();
                }catch(SQLException ex){
                    new DAOException("Error en SQL",ex);
                }
            }
            if(stat!=null){
                try{
                    stat.close();
                }catch(SQLException ex){
                    new DAOException("Error en SQL",ex);
                }
            }
        }
        return a;
        
    }
}
    

