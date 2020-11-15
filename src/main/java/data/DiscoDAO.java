package data;


import data.DAOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Disco;


/**
 *
 * @author migue
 */

public class DiscoDAO {
    final String INSERT ="INSERT INTO Disco(nombre,foto,fecha,id_artista)VALUES(?,?,?)";
    final String UPDATE ="UPDATE Disco SET nombre=?,foto=?,fecha=?,id_artista=? WHERE id=?";
    final String DELETE ="DELETE FROM Disco WHERE id= ?";
    final String GETALL = "SELECT id,nombre,foto,fecha,id_artista FROM Disco";
    final String GETONE = "SELECT id,nombre,foto,fecha,id_artista FROM Disco WHERE id=?";
    
    
    private Connection conexion;
    
    public DiscoDAO(Connection conexion){
        this.conexion=conexion;
    }

    public DiscoDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public void insertar(Disco d) throws DAOException {
            PreparedStatement stat = null;
            ResultSet rs =null;
            try{
                stat =conexion.prepareStatement(INSERT);
                stat.setString(1,d.getNombre());
                stat.setString(2,d.getFoto());
                stat.setString(3,d.getFecha());
                stat.setInt(4,d.getId_artista());
                stat.executeUpdate();
                if (stat.executeUpdate()==0){
                    throw new DAOException("Puede que no se haya guardado.");
                }
                rs=stat.getGeneratedKeys();
                if (rs.next()){
                d.setId(rs.getInt(1));
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
        Disco disc = new Disco();
        try {
            if (conexion != null) {

                st = conexion.createStatement();
                System.out.println("Introduzca nuevo Nombre del disco");
                disc.setNombre(utilities.Utilidades.getString());
                  System.out.println("Introduzca foto del disco");
                disc.setFoto(utilities.Utilidades.getString());
                    System.out.println("Introduzca nueva fecha");
                disc.setFecha(utilities.Utilidades.getString());
                  

                st.executeUpdate("UPDATE  cancion "
               + "SET " + "Nombre="+disc.getNombre()+","
               + "Foto="+disc.getFoto()+","
               + "Fecha="+disc.getFecha()+","        
               +"WHERE ID="+id);
            }

        } finally {
            if (conexion != null) {
                st.close();
            }
    }
 }


    public void eliminar(int id) throws DAOException, SQLException {
            Statement st = null;

        try {
            if (conexion != null) {

                st = conexion.createStatement();

                st.executeUpdate("DELETE FROM Disco WHERE ID=" + id);
            }

        } finally {
            if (conexion != null) {
                st.close();
            }
        }
 }

   
     private Disco convertir (ResultSet rs) throws SQLException{
         String nombre = rs.getString("nombre");
         String foto = rs.getString("foto");
         String fecha = rs.getString("fecha");
         int id_artista= rs.getInt("id_artista");
         Disco disco= new Disco(nombre,foto,fecha);
         disco.setId(rs.getInt("id"));
         return disco;
     }
    public List<Disco> obtenerTodos() {
        PreparedStatement stat = null;
        ResultSet rs =null;
        List<Disco> disco=new ArrayList<>();
        try{
            stat =conexion.prepareStatement(GETALL);
            rs=stat.executeQuery();
            while(rs.next()){
                disco.add(convertir(rs));
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
        return disco;
    }

    public Disco obtener(int id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs =null;
        Disco d=null;
        try{
            stat =conexion.prepareStatement(GETONE);
            stat.setInt(1, id);
            rs=stat.executeQuery();
            if(rs.next()){
                d=convertir(rs);
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
        return d;
        
    }

}
