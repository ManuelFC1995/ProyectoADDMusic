/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import data.ArtistaDAO;
import data.CancionDAO;
import data.DAOException;
import data.DiscoDAO;
import data.PlayLIstDAO;
import data.UsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Artista;
import modelo.Cancion;
import modelo.Disco;
import modelo.PlayList;
import modelo.Usuario;

/**
 *
 * @author manue
 */
public class Controller implements IController {

  @Override
    public void ListarArtistas() {
       ArtistaDAO artista = new ArtistaDAO();
       ArrayList<Artista> listarA = new ArrayList<>();
       listarA = (ArrayList<Artista>) artista.obtenerTodos();
       for(Artista a : listarA){
           System.out.println(a);
       }
    }

    @Override
    public void CrearArtista() {

       Artista artist = new Artista();
       ArtistaDAO ArtistaDao= new ArtistaDAO();
         System.out.println("Introduzca el nombre del artista");
                artist.setNombre(utilities.Utilidades.getString());
                
         System.out.println("Introduzca la nacionalidad del artista");
                artist.setNacionalidad(utilities.Utilidades.getString());
                
         System.out.println("Introduzca una foto del artista");
                artist.setFoto(utilities.Utilidades.getString());
         
         ArrayList<Disco> Discos =null; 
         artist.setDiscos(Discos);
        try {
            ArtistaDao.insertar(artist);
        } catch (DAOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ActualizarArtistaInfo() {
         System.out.println("introduzca id del artista");
        int id=utilities.Utilidades.getInt();
       ArtistaDAO artist= new ArtistaDAO();
       
        try {
            artist.modificar(id);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
   

    @Override
    public void EliminaArtista() {
         Artista artist = new Artista();
         ArtistaDAO artistaDao= new ArtistaDAO();
         System.out.println("introduzca la id del usuario");
         int a=utilities.Utilidades.getInt();
    
        try {
            artistaDao.eliminar(a);
        } catch (DAOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
         System.out.println("Usuario  Eliminado");
    }

    @Override
    public void ListarDiscos() {
        
       DiscoDAO disco = new DiscoDAO();
       ArrayList<Disco> listarD = new ArrayList<>();
       listarD = (ArrayList<Disco>) disco.obtenerTodos();
       for(Disco d : listarD){
           System.out.println(d);
       }
    }

    @Override
    public void CrearDiscos() {
       Disco disc= new Disco();
       DiscoDAO discoDao= new DiscoDAO();
         System.out.println("Introduzca el nombre del disco");
                disc.setNombre(utilities.Utilidades.getString());
                
         System.out.println("Introduzca foto del disco");
                disc.setFoto(utilities.Utilidades.getString());
                
         System.out.println("Introduzca la fecha de salida");
                disc.setFecha(utilities.Utilidades.getString());
         
         ArrayList<Cancion> canciones =null; 
         disc.setCanciones(canciones);
        try {
            discoDao.insertar(disc);
        } catch (DAOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void ActualizarDiscoInfo() {
        System.out.println("introduzca id del disco");
        int id=utilities.Utilidades.getInt();
       DiscoDAO disc= new DiscoDAO();
       
        try {
            disc.modificar(id);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
     @Override
    public void EliminarDisco() {
        DiscoDAO DiscoDao= new DiscoDAO();
         System.out.println("introduzca la id del artista");
        int d=utilities.Utilidades.getInt();
    
        try {
            DiscoDao.eliminar(d);
        } catch (DAOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("artista Eliminado");
    }

    @Override
    public void ListarCanciones() {
       CancionDAO cdao = new CancionDAO();
      ArrayList<Cancion> canciones= (ArrayList<Cancion>) cdao.obtenerTodos();
      for (Cancion c :canciones){
          System.out.println(c);
      }
    }
    
    public void EliminarCancionLIsta() throws SQLException{
         CancionDAO cdao = new CancionDAO();
       int idLista=utilities.Utilidades.getInt("introduzca el id de la lista");
       int idcancion=utilities.Utilidades.getInt("introduzca el id de la cancion");
       cdao.DeleteCancionPlist(idcancion, idLista);
    }

    @Override
    public void CrearCanciones() {
          CancionDAO cdao = new CancionDAO();
        try {
            cdao.InsertCancion();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
     public void ActualizarCancion() {
         System.out.println("introduzca id de la cancion");
        int id=utilities.Utilidades.getInt();
       CancionDAO song= new CancionDAO();
       
        try {
            song.modificar(id);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @Override
    public void EliminarCancion() {
        ListarCanciones();
       int id=utilities.Utilidades.getInt("Introduzca el id de la cancion");
        CancionDAO cdao = new CancionDAO();
        try {
            cdao.eliminar(id);
        } catch (DAOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
          Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
      }
       
    }

    @Override
    public void ListarPlayList() {
       PlayLIstDAO pldao = new PlayLIstDAO();
       ArrayList<PlayList> listas = new ArrayList<>();
        try {
            listas = (ArrayList<PlayList>) pldao.SelectPlayList();
            for(PlayList p : listas){
                System.out.println(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void CrearPlayList() {
       PlayLIstDAO pdao=new PlayLIstDAO();
    
        try {
            pdao.InsertPlaylist();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }

    @Override
    public void ActualizarPlayLIst( ) {
        System.out.println("introduzca id de la lista");
        int id=utilities.Utilidades.getInt();
       PlayLIstDAO pldao= new PlayLIstDAO();
        try {
            pldao.updatePlayListinfo(id);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void AñadirCancionPlayLIst() {
       CancionDAO cdao = new CancionDAO();
    
        try {
            cdao.InsertCancionLista();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void EliminarPlayList() {
        
        System.out.println("introduzca la id de la PlayList");
        int id=utilities.Utilidades.getInt();
    PlayLIstDAO pdao=new PlayLIstDAO();
        try {
            pdao.DeletePlist(id);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void ListarUsers() {
         UsuarioDAO UsuarioDao= new UsuarioDAO();
        
        try {
            for (Usuario u: UsuarioDao.SelectUsuarios(UsuarioDao.SELECTall)){
                System.out.println(u);
            }       } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            
            
        }
    }
    
    public void ListarPlaylistUser(int id) throws SQLException{
        PlayLIstDAO pdao = new PlayLIstDAO();
        ArrayList<PlayList> listas =(ArrayList<PlayList>) pdao.SelectPlayListUsuario(id);
        for(PlayList p:listas){
            System.out.println(p);
        }
    }

    @Override
    public void CrearUsuario() {
        Usuario user = new Usuario();
         UsuarioDAO UsuarioDao= new UsuarioDAO();
         System.out.println("Introduzca nuevo correo del usuario");
                user.setCorreo(utilities.Utilidades.getString());
                  System.out.println("Introduzca nuevo nombre de usuario");
                user.setNombre(utilities.Utilidades.getString());
                      System.out.println("Introduzca nuevo foto del usuario");
                user.setFoto(utilities.Utilidades.getString());
                ArrayList<PlayList> misListas =null;
               user.setMisListas(misListas);
        try {
            UsuarioDao.InsertUser(user);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
               
               
                
    }

   
   public void ListarCancionesPL(int id) throws SQLException{
       CancionDAO cdao = new CancionDAO();
      
      ArrayList<Cancion> cn= (ArrayList<Cancion>) cdao.SelectCancioLista(id);
       for (Cancion c :cn){
           System.out.println(cn);
       }
   }

   

    public void EliminarUsuario() {
       UsuarioDAO UsuarioDao= new UsuarioDAO();
         System.out.println("introduzca la id del usuario");
        int id=utilities.Utilidades.getInt();
    
        try {
         
            UsuarioDao.DeleteUser(id);
            System.out.println("Usuario  Eliminado");
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ActualizarUsuarioInfo() {
        UsuarioDAO UsuarioDao= new UsuarioDAO();
        System.out.println("introduzca el id");
       int id=utilities.Utilidades.getInt();
     
        try {
            UsuarioDao.updateUserInfo(id);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    
    }

  public void ListarPlayListUsuario(int id) throws SQLException{
     PlayLIstDAO pdao = new PlayLIstDAO();
      ArrayList <PlayList> listas =(ArrayList <PlayList>) pdao.SelectPlayListUsuario(id);
     for (PlayList p : listas){
         System.out.println(p);
     }
      
  }



    
    
}
