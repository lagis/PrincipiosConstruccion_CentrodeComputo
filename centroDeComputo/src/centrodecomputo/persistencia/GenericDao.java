/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrodecomputo.persistencia;

import centrodecomputo.logica.DictamenMantenimiento;
import centrodecomputo.logica.Prestamo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author PREDATOR 15 G9-78Q
 */
public abstract class GenericDao<T> {
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  static final String DB_URL = "jdbc:mysql://";	
  
  
  protected Connection conectar() {
    String usuario = Credenciales.USUARIO;
    String pass = Credenciales.PASSWORD;
    String bd = Credenciales.BASEDATOS;
    String host = Credenciales.HOST;
    int port = Credenciales.PORT;
    Connection res = null;
    try {
      // Registrar JDBC driver
      Class.forName("com.mysql.jdbc.Driver");
      String url = String.format(DB_URL, host, port, bd);
      res = DriverManager.getConnection(url, usuario, pass);
    } catch (SQLException sqe) {
      sqe.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    try {
      res.setAutoCommit(false);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return res;
  }
  
  
}
