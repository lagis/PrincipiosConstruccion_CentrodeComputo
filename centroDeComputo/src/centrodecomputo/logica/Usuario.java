/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrodecomputo.logica;

import centrodecomputo.dao.PersonalDao;
import centrodecomputo.dao.UsuarioDao;
import java.sql.SQLException;

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

  public String iniciarSesion() throws SQLException {
    UsuarioDao user = new UsuarioDao();
    PersonalDao personal = new PersonalDao();
    String puesto = null;
    try {
      if (user.obtenerContrasenia(this.numeroDePersonal).equals(this.contrasenia)) {
        puesto = personal.obteberPuesto(Integer.parseInt(this.numeroDePersonal));
      }
    } catch (SQLException e) {
      throw new SQLException();
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
