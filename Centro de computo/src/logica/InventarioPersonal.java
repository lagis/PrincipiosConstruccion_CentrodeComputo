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
 * Clase que administra el personal.
 *
 * @author marai
 */
public class InventarioPersonal implements InventarioPersonalInterface {

  private PersistenciaPersonal almacen = new PersonalAlmacen();

  public InventarioPersonal() {
  }

  /**
   *
   * @param usuario
   * @return
   * @throws SQLException
   */
  @Override
  public boolean comprobarIdPersonal(int usuario) throws SQLException {
    return this.almacen.buscarUsuario(usuario);
  }

  /**
   *
   * @param contrasenia
   * @return
   * @throws SQLException
   */
  @Override
  public boolean comprobarContrasenia(String contrasenia) throws SQLException {
    return false;
  }

  /**
   *
   * @param numeroDePersonal
   * @return
   * @throws SQLException
   */
  @Override
  public Personal obtenerPersonal(int numeroDePersonal) throws SQLException {
    return this.almacen.obtenerPersonal(numeroDePersonal);
  }

  /**
   *
   * @param numeroDePersonal
   * @param contrasenia
   * @return
   */
  @Override
  public boolean comprobarPersonal(int numeroDePersonal, String contrasenia) {
    return this.almacen.buscarPersonal(numeroDePersonal, contrasenia);
  }

  /**
   *
   * @param usuario
   * @return
   */
  @Override
  public String obtenerPuesto(int usuario) {
    try {
      return this.almacen.obteberPuesto(usuario);
    } catch (SQLException ex) {
      return null;
    }
  }

  /**
   *
   * @return @throws SQLException
   */
  @Override
  public List<Personal> verPersonal() throws SQLException {
    return this.almacen.obternerTodoPersonal();
  }

  /**
   *
   * @param personal
   * @throws SQLException
   */
  @Override
  public void registrarNuevoPersonal(Personal personal) throws SQLException {
    try {
      this.almacen.registrarPersonal(personal);
      this.almacen.registrarContrasenia(personal);
    } catch (SQLException ex) {
      throw new SQLException();
    }
  }

  /**
   *
   * @param correo
   * @return
   * @throws SQLException
   */
  @Override
  public boolean comprobarCorreo(String correo) throws SQLException {
    return this.almacen.buscarCorreo(correo);
  }

  /**
   *
   * @param telefono
   * @return
   * @throws SQLException
   */
  @Override
  public boolean comprobarTelefono(String telefono) throws SQLException {
    return this.almacen.buscarTelefono(telefono);
  }

  /**
   *
   * @param personal
   */
  @Override
  public void editarPersonal(Personal personal) {
    try {
      this.almacen.actualizarPersonal(personal);
    } catch (SQLException ex) {
      Logger.getLogger(InventarioPersonal.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
      this.almacen.actualizarContrasenia(personal);
    } catch (SQLException ex) {
      Logger.getLogger(InventarioPersonal.class.getName()).log(Level.SEVERE, null, ex);
    }

  }
}
