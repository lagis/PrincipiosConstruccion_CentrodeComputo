/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.PersistenciaPersonal;
import persistencia.PersonalAlmacen;

/**
 *
 * @author marai
 */
public class InventarioPersonal implements InventarioPersonalInterface {
  
  private PersistenciaPersonal almacen = new PersonalAlmacen();
  
  

  public InventarioPersonal() {
  }
  
   @Override
  public boolean comprobarIdPersonal(int usuario) throws SQLException {
    return this.almacen.buscarUsuario(usuario);

  }

  @Override
  public boolean comprobarContrasenia(String contrasenia) throws SQLException {
    return false;
  }

  @Override
  public Personal obtenerPersonal(int numeroDePersonal) throws SQLException {
    return this.almacen.obtenerPersonal(numeroDePersonal);
  }

  @Override
  public boolean comprobarPersonal(int numeroDePersonal, String contrasenia) {
    return this.almacen.buscarPersonal(numeroDePersonal, contrasenia);
  }

  @Override
  public String obtenerPuesto(int usuario) {
    try {
      return this.almacen.obteberPuesto(usuario);
    } catch (SQLException ex) {
      return null;
    }
  }

  @Override
  public List<Personal> verPersonal() throws SQLException {
    return this.almacen.obternerTodoPersonal();
  
  }

  @Override
  public void registrarNuevoPersonal(Personal personal) {
    try {
      this.almacen.registrarPersonal(personal);
      this.almacen.registrarContrasenia(personal);
    } catch (SQLException ex) {
      Logger.getLogger(InventarioPersonal.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  @Override
  public boolean comprobarCorreo(String correo) throws SQLException {
    return this.almacen.buscarCorreo(correo);
  }

  @Override
  public boolean comprobarTelefono(String telefono) throws SQLException {
    return this.almacen.buscarTelefono(telefono);
  }

  
}
