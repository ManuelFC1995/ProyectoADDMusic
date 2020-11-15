/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import data.UsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Usuario;

/**
 *
 * @author manue
 */
public class UsersGui {
    public static void ChoseUsuario() throws SQLException{
        ArrayList<Usuario> usuarios = new ArrayList<>();
        UsuarioDAO udao = new UsuarioDAO();
       int n=1;
        usuarios = (ArrayList<Usuario>) udao.SelectUsuarios(udao.SELECTall);
        for(Usuario us:usuarios){
            System.out.println(n+"."+us);
            n++;
        }
    }
    
    
    public static int ElegirUsuario() throws SQLException{
       ArrayList<Usuario> usuarios = new ArrayList<>();
        UsuarioDAO udao = new UsuarioDAO();
         usuarios = (ArrayList<Usuario>) udao.SelectUsuarios(udao.SELECTall);
        int numElegido=utilities.Utilidades.getInt();
        int contador=0;
        Boolean result;
       Usuario elegido=new Usuario();
    
        for(Usuario u: usuarios){
            contador++;
            result=false;
            do{
                if(numElegido==contador){
              elegido=u;
                result=true;
                break;
            }else{
                result=false;
            }
                
            }while(result==false);
        }
        
       
        
        return elegido.getId();
        
        
      
    }
}
