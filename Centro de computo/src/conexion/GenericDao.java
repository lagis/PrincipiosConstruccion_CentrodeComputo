/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Conexión.
 *
 * @author PREDATOR 15 G9-78Q
 */

public abstract class GenericDao<T> {

  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  static final String DB_URL = "jdbc:mysql://";

  protected Connection conectar() throws SQLException {
    String usuario = Credenciales.usuario;
    String pass = Credenciales.password;
    String bd = Credenciales.baseDatos;
    String host = Credenciales.host;
    int port = Credenciales.port;
    Connection res = null;

    try {
      Class.forName("com.mysql.jdbc.Driver");
      String url = String.format(DB_URL, host, port, bd);
      res = DriverManager.getConnection(url, usuario, pass);
    } catch (ClassNotFoundException e) {

    }
    res.setAutoCommit(false);

    return res;
  }

}
