/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrodecomputo.logica;

import centrodecomputo.dao.PersonalDao;
import centrodecomputo.dao.UsuarioDao;

/**
 *
 * @author marai
 */
public class Usuario {

  private String numeroDePersonal;
  private String contrasenia;

  public Usuario(String numeroDePersonal, String contrasenia) {
    this.numeroDePersonal = numeroDePersonal;
    this.contrasenia = contrasenia;
  }

  public String iniciarSesion() {
    UsuarioDao user = new UsuarioDao();
    PersonalDao personal = new PersonalDao();
    String puesto = null;
   
    if(user.obtenerContrasenia(this.numeroDePersonal).equals(this.contrasenia)){
      puesto = personal.obteberPuesto(Integer.parseInt(this.numeroDePersonal));
    }
    return puesto;
  }

  public String getNumeroDePersonal() {
    return numeroDePersonal;
  }

  public String getContrasenia() {
    return contrasenia;
  }

}
