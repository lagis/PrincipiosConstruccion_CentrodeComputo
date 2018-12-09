/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrodecomputo.logica;

import java.util.List;

/**
 *
 * @author marai
 */
public class JefeCentroComputo extends Usuario{
  private String nombreJefeCentroComputo;
  
  /**
   *
   */
  public JefeCentroComputo(String nombre, String numeroDePersonal, String contrasenia){
    super(numeroDePersonal,contrasenia,"Jefe de sentro de computo");
    this.nombreJefeCentroComputo = nombre;
    
  }
  
  public void registrarUsuario(Usuario nuevoUsuario){
    
  }
  
  public List<Usuario> verUsuarios(){
    
    return null;
  }
  
  public void editarUsuario(Usuario usuario){
    
  }
}
