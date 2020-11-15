/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import Controller.Controller;
import java.sql.SQLException;

/**
 *
 * @author manue
 */
public class Pruebas {
    public static void main(String[] args) throws SQLException {
        Controller c = new Controller();
       c.AñadirCancionPlayLIst();
              
    }
}
