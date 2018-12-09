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
  
  private static Connection conexion;

  private static void crearCnexion() {
    try {
      String url = "jdbc:mysql://localhost/";
      String databaseName = "centro_de_computo";
      String userName = "root";
      String password = "";

      conexion = (Connection) DriverManager.getConnection(url + databaseName, userName, password);
    } catch (SQLException ex) {
      java.util.logging.Logger.getLogger(ConexioBasedeDatos.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  /**
   * Se obtiene el estado de la conexión a la base de datos
   * @return conexión a la base de datos
   */
  
  public static Connection obtenerConexionBaseDatos() {
    crearCnexion();
    return ConexioBasedeDatos.conexion;

  }
  
  /**
   * Cierra la conexión a la base de datos
   */
  
  public static void cerrarConexion() {
    if (conexion != null) {
      try {
        if (!conexion.isClosed()) {
          conexion.close();
        }
      } catch (SQLException ex) {
        Logger.getLogger(ConexioBasedeDatos.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
}
