/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import logica.DictamenMantenimiento;
import conexion.GenericDao;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Giselle
 */
public class PrestamoAlmacen<T> extends GenericDao<T> implements PersistenciaPrestamo {

  private String query;
  private Connection conexion;

  @Override
  public void registrarPrestamo(String nombreSolicitante, String matricula,
          java.sql.Date fechaPrestamo, java.sql.Time horaPrestamo,
          String equipo, String salon) throws SQLException {

    conexion = this.conectar();
    query = "INSERT INTO `centro_de_computo`.`prestamo`"
            + "(`nombre_solicitante`,"
            + "`matricula_solicitante`,"
            + "`fecha_prestamo`,"
            + "`hora_prestamo`,"
            + "`equipo_numero_inventario`,"
            + "`salon`)"
            + "VALUES"
            + "(?,?,?,?,?,?);";
    try {

      PreparedStatement statement = conexion.prepareStatement(query);
      statement.setString(1, nombreSolicitante);
      statement.setString(2, matricula);
      statement.setDate(3, fechaPrestamo);
      statement.setTime(4, horaPrestamo);
      statement.setString(5, equipo);
      statement.setString(6, salon);
      statement.executeUpdate();

      query = "UPDATE centro_de_computo.equipo"
              + "SET estado = prestado where numero_inventario = ?";
      statement = conexion.prepareStatement(query);
      statement.setString(1, equipo);
      statement.executeUpdate();

      conexion.commit();
      statement.close();

    } catch (SQLException ex) {
      Logger.getLogger(PrestamoAlmacen.class.getName()).log(Level.SEVERE,
              null, ex);
    } finally {
      conexion.close();
    }

  }

  @Override
  public List<DictamenMantenimiento> obtenerTodosLosPrestamos() 
          throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<DictamenMantenimiento> obtenerPrestados() throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void registrarDevolucion(int numeroPrestamo,Date FechaDevolucion,
          Time horaDevolucion,String equipo)
          throws SQLException {

    conexion = this.conectar();
    query = "UPDATE `centro_de_computo`.`prestamo`"
            + "SET"
            + "`fecha_entrega` = ?,"
            + "`hora_entrega` = ?,"
            + "WHERE `numero_prestamo` = ?;";
    try {

      PreparedStatement statement = conexion.prepareStatement(query);
      statement.setDate(1, FechaDevolucion);
      statement.setTime(2, horaDevolucion);
      statement.setInt(3, numeroPrestamo);
    
      statement.executeUpdate();

      query = "UPDATE centro_de_computo.equipo"
              + "SET estado = disponible where numero_inventario = ?";
      statement = conexion.prepareStatement(query);
      statement.setString(1, equipo);
      statement.executeUpdate();

      conexion.commit();
      statement.close();

    } catch (SQLException ex) {
      Logger.getLogger(PrestamoAlmacen.class.getName()).log(Level.SEVERE,
              null, ex);
    } finally {
      conexion.close();
    }
  }

}
