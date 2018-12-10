/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrodecomputo.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import centrodecomputo.logica.Prestamo;
import centrodecomputo.persistencia.ConexioBasedeDatos;
import java.util.Date;

/**
 *
 * @author Giselle
 */
public class PrestamoAlmacen implements PersistenciaPrestamo {

  private ArrayList<Prestamo> listaPrestamos;
  private String query;
  private Connection connection;
  private Prestamo prestamo;

  @Override
  public List<Prestamo> obtenerTodosPrestamos(String nombreSolicitante, String matricula, Date fechaPrestamo, String horaPrestamo, Date FechaDevolucion, String horaDevolucion, String salon) {
    listaPrestamos = new ArrayList<>();
    query = "select * from prestamo";
    connection = ConexioBasedeDatos.obtenerConexionBaseDatos();
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        Prestamo prestamo = new Prestamo();
        prestamo.consultarNombreSolicitante();
        listaPrestamos.add(prestamo);
      }
    } catch (SQLException ex) {
      Logger.getLogger(PrestamoAlmacen.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      ConexioBasedeDatos.cerrarConexion();
    }
    return listaPrestamos;
  }

  @Override
  public boolean agregarPrestamo(String nombreSolicitante, String matricula, String fechaPrestamo, String horaPrestamo, String equipo, String salon) {
    query = "\"INSERT INTO centro_de_computo.prestamo (numero_prestamo,nombre_solicitante,matricula_solicitante,fecha_prestamo,hora_prestamo,equipo_numero_inventario,salon, \" +\n"
            + "\"VALUES(?, ?, ?, ?, ?,?,?);\"";
    try {
      PreparedStatement statement = connection.prepareStatement(query);

      statement.setString(1, null);
      statement.setString(2, nombreSolicitante);
      statement.setString(3, matricula);
      statement.setString(4, fechaPrestamo);
      statement.setString(5, horaPrestamo);
      statement.setString(6, equipo);
      statement.setString(7, salon);
    } catch (SQLException ex) {
      Logger.getLogger(PrestamoAlmacen.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      ConexioBasedeDatos.cerrarConexion();
    }
    return true;
  }

}
