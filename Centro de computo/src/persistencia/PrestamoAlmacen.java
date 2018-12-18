/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import conexion.GenericDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Prestamo;

/**
 *
 * @author Giselle
 */
public class PrestamoAlmacen<T> extends GenericDao<T> implements PersistenciaPrestamo {

  private String query;
  private Connection conexion;
  private List<Prestamo> prestamos = new ArrayList<Prestamo>();
  private List<Prestamo> prestados = new ArrayList<Prestamo>();

  @Override
  public void registrarPrestamo(String nombreSolicitante, String matricula,
          String fechaPrestamo, String horaPrestamo,
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
      statement.setString(3, fechaPrestamo);
      statement.setString(4, horaPrestamo);
      statement.setString(5, equipo);
      statement.setString(6, salon);
      statement.executeUpdate();

      query = "UPDATE centro_de_computo.equipo"
              + "SET estado = prestado where numero_inventario = ?;";
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
  public List<Prestamo> obtenerTodosLosPrestamos() throws SQLException {
    conexion = this.conectar();
    query = "Select * from centro_de_computo.prestamo;";
    try {
      PreparedStatement statement = conexion.prepareStatement(query);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        Prestamo prestamo = new Prestamo(result.getString("nombre_solicitante"),
                result.getString("matricula_solicitante"),
                result.getString("fecha_prestamo"),
                result.getString("hora_prestamo"),
                result.getString("equipo_numero_inventario"),
                result.getString("fecha_entrega"),
                result.getString("hora_entrega"), result.getString("salon"));
        prestamos.add(prestamo);
      }

    } catch (SQLException ex) {
      Logger.getLogger(PrestamoAlmacen.class.getName()).log(Level.SEVERE,
              null, ex);
    } finally {
      conexion.close();
    }
    return prestamos;

  }

  @Override
  public List<Prestamo> obtenerPrestados() throws SQLException {
    conexion = this.conectar();
    query = "select prestamo.fecha_prestamo,prestamo.equipo_numero_inventario,"
            + "prestamo.matricula_solicitante,prestamo.nombre_solicitante,prestamo.salon "
            + "from centro_de_computo.prestamo where prestamo.equipo_numero_inventario "
            + "like(select equipo.numero_inventario from centro_de_computo.equipo where equipo.estado "
            + "like 'prestado');";
    try {
      PreparedStatement statement = conexion.prepareStatement(query);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        Prestamo prestamo = new Prestamo(result.getString("fecha_prestamo"),
                result.getString("equipo_numero_inventario"),
                result.getString("matricula_solicitante"),
                result.getString("nombre_solicitante"),
                result.getString("salon"));

        prestados.add(prestamo);
      }

    } catch (SQLException ex) {
      Logger.getLogger(PrestamoAlmacen.class.getName()).log(Level.SEVERE,
              null, ex);
    } finally {
      conexion.close();
    }
    return prestados;
  }

  @Override
  public void registrarDevolucion(int numeroPrestamo, String FechaDevolucion,
          String horaDevolucion, String equipo)
          throws SQLException {

    conexion = this.conectar();
    query = "UPDATE `centro_de_computo`.`prestamo`"
            + "SET"
            + "`fecha_entrega` = ?,"
            + "`hora_entrega` = ?,"
            + "WHERE `numero_prestamo` = ?;";
    try {

      PreparedStatement statement = conexion.prepareStatement(query);
      statement.setString(1, FechaDevolucion);
      statement.setString(2, horaDevolucion);
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
