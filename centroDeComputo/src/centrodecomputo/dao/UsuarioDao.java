/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package centrodecomputo.dao;

import centrodecomputo.logica.Usuario;
import centrodecomputo.persistencia.GenericDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que establece conexión con la base de datos. 
 * @author marai
 */
public class UsuarioDao extends GenericDao implements UsuarioDaoInterface {

  String password;
  private String query;
  private Connection conexion;

  public UsuarioDao() {

  }

  /**
   * Obtiene la contraseña de un usuario.
   * @param numeroDePersonal id del personal
   * @return puesto del usuario
   * @throws SQLException Si no puede establecer conexion con la base de datos 
   */
  @Override
  public String obtenerContrasenia(String numeroDePersonal) throws SQLException {
    query = "SELECT contrasenia FROM centro_de_computo.usuario WHERE nombre_usuario = ? ";

    try {
      conexion = this.conectar();
      PreparedStatement statement = conexion.prepareStatement(query);
      statement.setString(1, numeroDePersonal);
      ResultSet result = statement.executeQuery();
      result.next();
      password = result.getString("contrasenia");
    } catch (SQLException ex) {
      throw new SQLException();
    } finally {
      try {
        conexion.close();
      } catch (SQLException ex) {
        Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

    return password;
  }

  /**
   * Requistra un usuario en la base de datos.
   * @param usuario objeto usuario
   * @throws SQLException Si no puede establecer conexion con la base de datos 
   */
  @Override
  public void registrarUsuario(Usuario usuario) throws SQLException {
    query = "INSERT INTO centro_de_computo.usuario(contrasenia,nombre_usuario,"
            + "personal_idpersonal) VALUES(?,?,?);";
    try {
      conexion = this.conectar();
      PreparedStatement statement = conexion.prepareStatement(query);
      statement.setString(1, usuario.getContrasenia());
      statement.setString(2, usuario.getNumeroDePersonal());
      statement.setInt(3, Integer.parseInt(usuario.getNumeroDePersonal()));
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
}
