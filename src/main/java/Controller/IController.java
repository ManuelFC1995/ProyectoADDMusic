/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import modelo.Artista;
import modelo.Cancion;
import modelo.Disco;
import modelo.PlayList;
import modelo.Usuario;

/**
 *
 * @author manue
 */
public interface IController {
    public void ListarArtistas();//CArgar el DaoArtistas y imprimirlos por pantalla
    public void CrearArtista();//crear un menu que crea un artista y hacer un create
    public void ActualizarArtistaInfo();//recibe un artista crea un menu para recibir por pantalla los nuevos datos y hace un update
    
    public void EliminaArtista();// recibe un artista y hace el delete
    
    
    public void ListarDiscos();//CArgar el DaoDiscos y imprimirlos por pantalla(agrupados por artista)
    public void CrearDiscos();//crear un menu que crea un Disco y hacer un create(debe  de asociarlo a un artista )
    public void ActualizarDiscoInfo();//recibe un disco crea un menu para recibir por pantalla los nuevos parametros y hace un update
   
    public void EliminarDisco();// recibe un disco y hace el delete 
    
    public void ListarCanciones();//CArgar el DaoCanciones y imprimirlos por pantalla(agrupados por Disco)
    public void CrearCanciones();//crear un menu que crea un Disco y hacer un create(debe dar la opcion de asociarlo a un disco ya existente o uno nuevo)
    // no se añade por defecto a ninguna playList
    public void ActualizarCancion();//recibe un disco crea un menu para recibir por pantalla los nuevos parametros y hace un update
    public void EliminarCancion();// recibe un disco y hace el delete
    
        
      public void ListarPlayList();//CArgar el DaoPlayList y imprimirlos por pantalla
    public void CrearPlayList();//crear un menu que crea una PlayLIst y hacer un create(lo añade a un usuario por defecto);
    public void ActualizarPlayLIst();//recibe un disco crea un menu para recibir por pantalla los nuevos parametros y hace un update
    public void AñadirCancionPlayLIst();//hace uso del metodo crearCanciones() y la añade
    public void EliminarPlayList();// recibe un disco y hace el delete
    
          public void ListarUsers();//CArgar el DaoUsers y imprimirlos por pantalla(ordenarlos por nombre
    public void CrearUsuario();//crear un menu que crea una Usuario y hacer un create(lo añade sin nada de playlist);
    public void ActualizarUsuarioInfo();//recibe un usuario crea un menu para recibir por pantalla los nuevos parametros y hace un update
   
    public void EliminarUsuario();// recibe un usuario y hace el delete
    
    
    
    
    
    
        
    
}
