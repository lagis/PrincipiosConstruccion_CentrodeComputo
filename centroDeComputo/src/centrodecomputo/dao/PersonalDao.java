/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package centrodecomputo.dao;

import centrodecomputo.logica.Personal;
import centrodecomputo.persistencia.GenericDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que obtine interactua con los datos del personal de la base de datos.
 * @author marai
 */
public class PersonalDao extends GenericDao implements PersonalDaoInterface {

  private String query;
  private Connection conexion;
  private String puesto;

  public PersonalDao() {

  }
  
  /**
   * Obtene todos el registro de un personal en la base de datos.
   * @param numeroPersonal ide del personal
   * @return Personal
   * @throws SQLException Si no puede establecer conexion con la base de datos
   */
  @Override
  public Personal obtenerPersonal(int numeroPersonal) throws SQLException {
    Personal personal = null;
    query = "SELECT * FROM personal WHERE idpersonal = ? ";

    try {
      conexion = this.conectar();
      PreparedStatement statement = conexion.prepareStatement(query);
      statement.setInt(1, numeroPersonal);
      ResultSet result = statement.executeQuery();
      result.next();
      personal = new Personal(result.getInt("idpersonal"),
              result.getString("nombreTecnico"), result.getString("correo"),
              result.getString("numero_telefono"), result.getString("puesto"));
    } catch (SQLException ex) {
      throw new SQLException();
    } finally {
      try {
        conexion.close();
      } catch (SQLException ex) {
        Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

    return personal;
  }

  /**
   * Obtene todos los registros de la tabla personal en la base de datos.
   * @return listaPersonal lista de todo el personal
   * @throws SQLException Si no puede establecer conexion con la base de datos
   */
  @Override
  public List<Personal> obternerTodoPersonal() throws SQLException {
    ArrayList<Personal> listaPersonal = new ArrayList<>();
    Personal personal;
    query = "SELECT * FROM personal";

    try {
      conexion = this.conectar();
      PreparedStatement statement = conexion.prepareStatement(query);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        personal = new Personal(result.getInt("idpersonal"),
                result.getString("nombreTecnico"), result.getString("correo"),
                result.getString("numero_telefono"), result.getString("puesto"));
        listaPersonal.add(personal);
      }
    } catch (SQLException ex) {
      throw new SQLException();
    } finally {
      try {
        conexion.close();
      } catch (SQLException ex) {
        Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

    return listaPersonal;
  }

  /**
   * Crea el registro de un personal en la base de datos.
   * @param personal objeto Personal
   * @throws SQLException Si no puede establecer conexion con la base de datos
   */
  @Override
  public void registrarPersonal(Personal personal) throws SQLException {
    query = "INSERT INTO personal(idpersonal,nombreTecnico,correo,numero_telefono,puesto)"
            + "VALUES (?,?,?,?,?)";

    try {
      conexion = this.conectar();
      PreparedStatement statement = conexion.prepareStatement(query);
      statement.setInt(1, personal.getIdPersonal());
      statement.setString(2, personal.getNombre());
      statement.setString(3, personal.getCorreo());
      statement.setString(4, personal.getTelefono());
      statement.setString(5, personal.getPuesto());
    } catch (SQLException ex) {
      Logger.getLogger(PersonalDao.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      try {
        conexion.close();
      } catch (SQLException ex) {
        Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }

  /**
   * Actualiza el registro del personal indicado.
   * @param personal objeto Personal
   * @throws SQLException Si no puede establecer conexion con la base de datos
   */
  @Override
  public void actualizarPersonal(Personal personal) throws SQLException {
    query = "UPDATE personal SET nombreTecnico = ?, correo = ?, numero_telefono = ?,"
            + "puesto = ?  WHERE idpersonal = ?";

    try {
      conexion = this.conectar();
      PreparedStatement statement = conexion.prepareStatement(query);
      statement.setString(1, personal.getNombre());
      statement.setString(2, personal.getCorreo());
      statement.setString(3, personal.getTelefono());
      statement.setString(4, personal.getPuesto());
      statement.setInt(5, personal.getIdPersonal());
    } catch (SQLException ex) {
      throw new SQLException();
    } finally {
      try {
        conexion.close();
      } catch (SQLException ex) {
        Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }

  /**
   * Obtiene el puesto de un personal.
   * @param numeroPersonal id del personal
   * @return puesto del personal
   * @throws SQLException Si no puede establecer conexion con la base de datos
   */
  @Override
  public String obteberPuesto(int numeroPersonal) throws SQLException {
    query = "SELECT puesto FROM personal WHERE idpersonal = ? ";

    try {
      conexion = this.conectar();
      PreparedStatement statement = conexion.prepareStatement(query);
      statement.setInt(1, numeroPersonal);
      ResultSet result = statement.executeQuery();
      result.next();
      puesto = result.getString("puesto");
    } catch (SQLException ex) {
      throw new SQLException();
    } finally {
      try {
        conexion.close();
      } catch (SQLException ex) {
        Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    return puesto;
  }
}
