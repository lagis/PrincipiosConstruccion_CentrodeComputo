/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrodecomputo.logica;

import centrodecomputo.dao.UsuarioDao;

/**
 *
 * @author marai
 */
public class Usuario {
  private String numeroDePersonal;
  private String contrasenia;
  
  public Usuario(String numeroDePersonal,String contrasenia){
    this.numeroDePersonal = numeroDePersonal;
    this.contrasenia = contrasenia;
  }
  
  public void iniciarSesion(String numeroDePersonal, String contrasenia){
    UsuarioDao user = new UsuarioDao();
    if(user.obtenerUsuario(numeroDePersonal) != null){
      
    }
    
  }
  
  public String getNumeroDePersonal() {
    return numeroDePersonal;
  }

  public String getContrasenia() {
    return contrasenia;
  }
  
}
