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
   * comprueba si existe el persona.
   * @param usuario Ide del personal
   * @return si existe o no el personal
   * @throws SQLException Por si causa problemas la base
   */
  @Override
  public boolean comprobarIdPersonal(int usuario) throws SQLException {
    return this.almacen.buscarUsuario(usuario);
  }

  /**
   *  comprieba la contraseña .
   * @param contrasenia es la contraseña dek usuario
   * @return si la contraseña conicide y es correcta.
   * @throws SQLException Por si causa problemas la base
   */
  @Override
  public boolean comprobarContrasenia(String contrasenia) throws SQLException {
    return false;
  }

  /**
   * obtiene el registro del personal.
   * @param numeroDePersonal id del personal
   * @return objeto personal
   * @throws SQLException Por si causa problemas la base
   */
  @Override
  public Personal obtenerPersonal(int numeroDePersonal) throws SQLException {
    return this.almacen.obtenerPersonal(numeroDePersonal);
  }

  /**
   * comprueba si los datos del usuario estan correctos.
   * @param numeroDePersonal numero del personal
   * @param contrasenia contraseña del usuario.
   * @return regresa si los datos si existe y son correctos
   */
  @Override
  public boolean comprobarPersonal(int numeroDePersonal, String contrasenia) {
    return this.almacen.buscarPersonal(numeroDePersonal, contrasenia);
  }

  /**
   * obtiene el puesto del personal indicado.
   * @param usuario id del personal
   * @return regresa el puesto del personal
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
   * obtiene todos los registros del personal.
   * @return lista de objetos personal.
   * @throws SQLException Por si causa problemas la base
   */
  @Override
  public List<Personal> verPersonal() throws SQLException {
    return this.almacen.obternerTodoPersonal();
  }

  /**
   * registra un nuevo objeto personal.
   * @param personal objeto personal.
   * @throws SQLException Por si causa problemas la base
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
   * comprueba si el correo existe.
   * @param correo correo del personal
   * @return si existe el correo
   * @throws SQLException Por si causa problemas la base
   */
  @Override
  public boolean comprobarCorreo(String correo) throws SQLException {
    return this.almacen.buscarCorreo(correo);
  }

  /**
   * comprueba si el telefono no es repedido.
   * @param telefono telefono del personal.
   * @return regresa si existe el telefono.
   * @throws SQLException Por si causa problemas la base
   */ 
  @Override
  public boolean comprobarTelefono(String telefono) throws SQLException {
    return this.almacen.buscarTelefono(telefono);
  }

  /**
   * edita un registro de un personal.
   * @param personal recibe un objeto personal
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
