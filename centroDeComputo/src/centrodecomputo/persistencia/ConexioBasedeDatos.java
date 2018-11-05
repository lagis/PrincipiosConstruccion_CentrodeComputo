/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrodecomputo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marai
 */
public class ConexioBasedeDatos {
  
  private static Connection connection;

  private static void makeConnection() {
    try {
      String url = "jdbc:mysql://localhost/";
      String databaseName = "tienda";
      String userName = "root";
      String password = "";

      connection = (Connection) DriverManager.getConnection(url + databaseName, userName, password);
    } catch (SQLException ex) {
      java.util.logging.Logger.getLogger(ConexioBasedeDatos.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  /**
   * Se obtiene el estado de la conexión a la base de datos
   * @return conexión a la base de datos
   */
  
  public static Connection getDataBaseConnection() {
    makeConnection();
    return ConexioBasedeDatos.connection;

  }
  
  /**
   * Cierra la conexión a la base de datos
   */
  
  public static void closeConnection() {
    if (connection != null) {
      try {
        if (!connection.isClosed()) {
          connection.close();
        }
      } catch (SQLException ex) {
        Logger.getLogger(ConexioBasedeDatos.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
}
