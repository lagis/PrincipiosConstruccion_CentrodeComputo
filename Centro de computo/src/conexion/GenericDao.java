/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Permite realizar una conexión a una base de datos mysql mediante jdbc.
 * @author PREDATOR 15 G9-78Q
 */

public abstract class GenericDao<T> {

  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  static final String DB_URL = "jdbc:mysql://";

  protected Connection conectar() throws SQLException {
    String usuario = Credenciales.Usuario;
    String pass = Credenciales.Contrasenia;
    String bd = Credenciales.BaseDatos;
    String host = Credenciales.Host;
    int port = Credenciales.Port;
    Connection res = null;

    
    try {
      Class.forName(JDBC_DRIVER);
      String url = String.format(DB_URL, host, port, bd);
      res = this.iniciarConexion(
          DriverManager.getConnection(url, usuario, pass));
      res.setAutoCommit(false);
      
    } catch (ClassNotFoundException e) {
      throw new SQLException();
    }
    return res;
  }

  
  private Connection iniciarConexion(Connection conexion) throws SQLException {
    return conexion;
  }
  
}
