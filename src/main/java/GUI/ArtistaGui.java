
package GUI;

import modelo.Artista;

/**
 *
 * @author manue
 */
public class ArtistaGui {
    public void ShowArtista(Artista artista){
        System.out.println("Artista: "+artista.getNombre()+"\n  Nacionalidad: "+artista.getNacionalidad()+""
        + "\n Discos registrados: "+artista.getDiscos().size());
    }
    
    public Artista ChoseArtista(){
        Artista a = new Artista();
        
        return a;
    }
}
