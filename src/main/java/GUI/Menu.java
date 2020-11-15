/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controller.Controller;
import java.sql.SQLException;
import java.util.Scanner;
import utilities.Utilidades;

public class Menu {

    static Scanner teclado = new Scanner(System.in);
    public static Controller c = new Controller();

    public static void Inicial() throws SQLException {
        int opciones = 0;
        do {

            System.out.println("Bienvenido a AppMusic");
            System.out.println("1. Artistas");
            System.out.println("2.Discos");
            System.out.println("3.Canciones");
            System.out.println("4.Listas");
            System.out.println("5 Usuarios");
            System.out.println("6.Salir");
            opciones = Utilidades.getInt();
            switch(opciones){
                case 1:
                    M_Artistas();
                    break;
                    
                case 2:
                    M_Discos();
                    break;
                case 3:
                    M_Canciones();
                    break;
                case 4:
                    M_Listas();
                    break;
                case 5:
                    M_Users();
                    break;
                case 6:
                    System.out.println("Hasta Pronto");
                    break;
                default:
                    System.err.println("Introduzca una opcion válida");
                    break;
            }

        } while (opciones != 6);

    }

    public static void M_Artistas() {
        int opciones = 0;
        do {

            System.out.println("1.Ver Lista de Artistas");
            System.out.println("2.Registrar un Artista");
            System.out.println("3.Actualizar información de un Artista");
            System.out.println("4.Eliminar Artista");
            System.out.println("5.Atras");

            opciones = Utilidades.getInt();
            switch(opciones){
                case 1:
                    c.ListarArtistas();
                    utilities.Utilidades.clearScreen();
                    break;
                    
                case 2:
                    c.CrearArtista();
                    utilities.Utilidades.clearScreen();
                    break;
                case 3:
                    c.ActualizarArtistaInfo();
                    utilities.Utilidades.clearScreen();
                    break;
                case 4:
                    c.EliminaArtista();
                    utilities.Utilidades.clearScreen();
                    break;
                case 5:
                    break;
             
                default:
                         System.err.println("Introduzca una opcion válida");
                    break;
            }

        } while (opciones != 5);

    }

    public static void M_Discos() {
        int opciones = 0;
        do {

            System.out.println("1.Ver Lista de Discos");
            System.out.println("2.Registrar un Disco");
            System.out.println("3.Actualizar un Disco");
            System.out.println("4.Eliminar un Disco");
            System.out.println("5.Atras");

            opciones = Utilidades.getInt();
            switch(opciones){
                case 1:
                    c.ListarDiscos();
                    utilities.Utilidades.clearScreen();
                    break;
                    
                case 2:
                    c.CrearDiscos();
                    utilities.Utilidades.clearScreen();
                    break;
                case 3:
                    c.ActualizarDiscoInfo();
                    utilities.Utilidades.clearScreen();
                    break;
                case 4:
                    c.EliminarDisco();
                    utilities.Utilidades.clearScreen();
                    break;
                case 5:
                    break;
             
                default:
                         System.err.println("Introduzca una opcion válida");
                    break;
            }

        } while (opciones != 5);

    }

    public static void M_Canciones() throws SQLException {
        int opciones = 0;
        do {

            System.out.println("1.Ver Lista de Canciones");
            System.out.println("2.Registrar una canción");
            System.out.println("3.Añadir cancion a Playlist");
            System.out.println("4.Eliminar cancion de playlist");

            System.out.println("5.Actualizar una canción");
            System.out.println("6.Eliminar una Cancíon");
            System.out.println("7.Atras");

            opciones = Utilidades.getInt();
            switch (opciones) {
                case 1:
                    c.ListarCanciones();
                    utilities.Utilidades.clearScreen();
              
                    break;

                case 2:
                    c.CrearCanciones();
                    utilities.Utilidades.clearScreen();
                  
                    break;
                case 3:
                    c.AñadirCancionPlayLIst();
                    utilities.Utilidades.clearScreen();
                 
                    break;
                case 4:
                    c.EliminarCancionLIsta();
                    utilities.Utilidades.clearScreen();
              
                    break;
                case 5:
                    c.ActualizarCancion();
                    utilities.Utilidades.clearScreen();
                 

                    break;
                case 6:

                    c.EliminarCancion();
                    utilities.Utilidades.clearScreen();
                    M_Canciones();
                    break;
                case 7:
                    utilities.Utilidades.clearScreen();
                    break;
                default:
                    System.err.println("Introduzca una opcion válida");
                    break;
            }

        } while (opciones != 7);

    }

    public static void M_Listas() throws SQLException {
        int opciones = 0;
        do {

            System.out.println("1.Listar PlayList");
            System.out.println("2.Listar canciones de una PlayList");
            System.out.println("3.Crear PlayList");
            System.out.println("4.Actualizar PlayList");
            System.out.println("5.Eliminar PlayList");//asegurarme q borra las canciones
            System.out.println("6.Atras");

            opciones = Utilidades.getInt();
            switch (opciones) {
                case 1:
                    c.ListarPlayList();

                    utilities.Utilidades.clearScreen();
                
                    break;

                case 2:

                    int id = utilities.Utilidades.getInt("Introduzca id de la lista");
                    c.ListarCancionesPL(id);
                    utilities.Utilidades.clearScreen();
                
                    break;
                case 3:

                    c.CrearPlayList();
                    utilities.Utilidades.clearScreen();
                

                    break;
                case 4:
                    c.ActualizarPlayLIst();
                    utilities.Utilidades.clearScreen();
           

                    break;
                case 5:
                    c.EliminarPlayList();
                    utilities.Utilidades.clearScreen();
                  
                case 6:
                    utilities.Utilidades.clearScreen();
                    break;
                default:
                    System.out.println("Introduzca una opcion válida");
                    break;
            }

        } while (opciones != 6);

    }

    public static void M_Users() throws SQLException {
        int opciones = 0;
        do {

            System.out.println("1. Usuarios");
            System.out.println("2. Mostrar playlist Usuarios");
            System.out.println("3.Registrar Usuario");
            System.out.println("4.Editar Usuario");
            System.out.println("5.Eliminar Usuario");
            System.out.println("6.Atras");

            opciones = Utilidades.getInt();
            switch (opciones) {
                case 1:
                    c.ListarUsers();
                    utilities.Utilidades.clearScreen();

                  

                    break;

                case 2:
                    int id = utilities.Utilidades.getInt("Introduzca el id del usuario");
                    c.ListarPlayListUsuario(id);
                    utilities.Utilidades.clearScreen();
                  
                    break;

                case 3:
                    c.CrearUsuario();
                    utilities.Utilidades.clearScreen();
               

                    break;
                case 4:
                    c.ActualizarUsuarioInfo();
                    utilities.Utilidades.clearScreen();
                

                    break;
                case 5:
                    c.EliminarUsuario();
                    utilities.Utilidades.clearScreen();
                 

                    break;

                case 6:
                    utilities.Utilidades.clearScreen();
                    break;
                default:
                    System.err.println("Introduzca una opcion válida");
                    break;
            }

        } while (opciones != 6);

    }
}
