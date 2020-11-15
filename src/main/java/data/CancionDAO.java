package data;


import data.Conection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cancion;
import modelo.PlayList;

/**
 *
 * @author migue
 */

public class CancionDAO {
    final String INSERT ="INSERT INTO Artista(nombre,nacionalidad,foto)VALUES(?,?,?)";
    final String UPDATE ="UPDATE Cancion SET nombre=?,duracion=? WHERE id=?";
    final String DELETE ="DELETE * FROM cancion  WHERE id= ?";
    final String GETALL = "SELECT id,nombre,duracion,id artista from cancion order by id";
    final String GETONE = "SELECT id,nombre,nacionalidad FROM Artista WHERE id=?";
    final String GETCANCIONESLIST="Select can.id,can.nombre from lista as list " +
" left join lista_cancion as lc On lc.id_lista=list.id" +
" left join cancion as can On lc.id_cancion=can.id where list.id=";
    
    
   final private Connection conexion;
    
    public CancionDAO(){
        this.conexion=Conection.GetConnection();
    }


    public void insertar(Cancion c) throws DAOException {
           
        
        PreparedStatement stat = null;
            ResultSet rs =null;
            try{
                stat =conexion.prepareStatement(INSERT);
                stat.setString(1,c.getNombre());
                stat.setString(2,c.getDuracion());
                stat.executeUpdate();
                if (stat.executeUpdate()==0){
                    throw new DAOException("Puede que no se haya guardado.");
                }
                rs=stat.getGeneratedKeys();
                if (rs.next()){
                c.setId(rs.getInt(1));
            }else{
                throw new DAOException("No puede asignar ID a esta cancion");    
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
        Cancion song = new Cancion();
        try {
            if (conexion != null) {

                st = conexion.createStatement();
                System.out.println("Introduzca nuevo Nombre de la cancion");
                song.setNombre(utilities.Utilidades.getString());
                  System.out.println("Introduzca nueva duracion de la cancion");
                song.setDuracion(utilities.Utilidades.getString());
                  

                st.executeUpdate("UPDATE  cancion "
               + "SET " + "Nombre="+song.getNombre()+","
               + "Descripcion="+song.getDuracion()
               +"WHERE ID="+id);
            }

        } finally {
            if (conexion != null) {
                st.close();
            }
    }
 }


    public void eliminar(int c) throws DAOException, SQLException {
        Statement st = null;

        try {
            if (conexion != null) {

                st = conexion.createStatement();

                st.executeUpdate("DELETE FROM lista WHERE ID=" + c);
            }

        } finally {
            if (conexion != null) {
                st.close();
            }
        }
 }

   
     private Cancion convertir (ResultSet rs) throws SQLException{
         String nombre = rs.getString("nombre");
         String duracion = rs.getString("duracion");
         Cancion cancion= new Cancion(nombre,duracion);
         cancion.setId(rs.getInt("id"));
         return cancion;
     }
    public List<Cancion> obtenerTodos() {
        PreparedStatement stat = null;
        ResultSet rs =null;
        List<Cancion> cancion=new ArrayList<>();
        try{
            stat =conexion.prepareStatement("SELECT id,nombre,duracion,id artista from cancion order by id");
            rs=stat.executeQuery();
            while(rs.next()){
                cancion.add(convertir(rs));
            }
        } catch (SQLException ex) {
             try {
                 throw new DAOException("Error SQL",ex);
             } catch (DAOException ex1) {
                 Logger.getLogger(CancionDAO.class.getName()).log(Level.SEVERE, null, ex1);
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
        return cancion;
    }

    public Cancion obtener(int id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs =null;
        Cancion c=null;
        try{
            stat =conexion.prepareStatement(GETONE);
            stat.setInt(1, id);
            rs=stat.executeQuery();
            if(rs.next()){
                c=convertir(rs);
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
        return c;
        
    }
      public List<Cancion> obtenerTodosList(int id) {
        PreparedStatement stat = null;
        ResultSet rs =null;
        List<Cancion> cancion=new ArrayList<>();
        try{
            stat =conexion.prepareStatement(GETCANCIONESLIST+id);
            rs=stat.executeQuery();
            while(rs.next()){
                cancion.add(convertir(rs));
            }
        } catch (SQLException ex) {
             try {
                 throw new DAOException("Error SQL",ex);
             } catch (DAOException ex1) {
                 Logger.getLogger(CancionDAO.class.getName()).log(Level.SEVERE, null, ex1);
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
        return cancion;
    }
      
              public List<Cancion> SelectCancioLista(int idLista) throws SQLException {
        ArrayList<Cancion> Canciones = new ArrayList<>();
   

        if (this.conexion != null) {
            Statement st = this.conexion.createStatement();
            try (ResultSet rs = st.executeQuery(GETCANCIONESLIST+idLista)) {
                while (rs != null && rs.next()) {
                    Cancion PL = new  Cancion();
                  int id=rs.getInt(1);
                    String Nombre = rs.getString(2);
                   
                 PL.setNombre(Nombre);
                 PL.setId(id);
                 Canciones.add(PL);

                  
              
               
                   
                }
            } finally {
                st.close();
            }
        }
        return Canciones;
    }
                    public List<Cancion> SelectCancioNombre(String nombre) throws SQLException {
        ArrayList<Cancion> Canciones = new ArrayList<>();
   

        if (this.conexion != null) {
            Statement st = this.conexion.createStatement();
            try (ResultSet rs = st.executeQuery("SELECT id form cancion where nombre ="+nombre)) {
                while (rs != null && rs.next()) {
                    Cancion PL = new  Cancion();
                  
                    String Nombre = rs.getString(1);
                   
                 PL.setNombre(Nombre);
                 Canciones.add(PL);

                  
              
               
                   
                }
            } finally {
                st.close();
            }
        }
        return Canciones;
    }
              
              
     
       public void InsertCancion() throws SQLException{
               PreparedStatement ps = null;

        try {
            ps = this.conexion.prepareStatement("INSERT INTO cancion(Nombre,Duracion,id_disco)VALUES(?,?,?)");
 System.out.println("Introduzca  Nombre de la Cancion");
             String Nombre=(utilities.Utilidades.getString());
              System.out.println("Introduzca Duracion");
             String Desc=(utilities.Utilidades.getString());
                 System.out.println("Introduzca Id del disco");
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
        public void InsertCancionLista() throws SQLException{
        PreparedStatement ps = null;

        try {
            ps = this.conexion.prepareStatement("INSERT INTO lista_cancion(id_lista,id_cancion)VALUES(?,?)");
 System.out.println("Introduzca  Id de la playList");
             int idP=utilities.Utilidades.getInt();
              System.out.println("Introduzca Id de la cancion para añadirla");
             int idC=utilities.Utilidades.getInt();
         
            ps.setInt(1,idP);
            
            ps.setInt(2,idC );
          
              if(ps.executeUpdate()==0) {
                  throw new SQLException("NO se ha insertado correctamente");
              }
        } finally {
            if (ps != null) {
                ps.close();
            }

        }

        
}
        
        
         public void DeleteCancionPlist(int idcancion, int idlista) throws SQLException {
        Statement st = null;

        try {
            if (this.conexion != null) {

                st = this.conexion.createStatement();

               
                    st.executeUpdate("DELETE FROM lista_cancion WHERE id_lista=" + idlista+",id_cancion="+idcancion);
            }

        } finally {
            if (this.conexion != null) {
                st.close();
            }
        }
    }
       
}
