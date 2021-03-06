/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia;

import conexion.GenericDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import logica.Prestamo;

/**
 * Contiene métodos para administrar los préstamos.
 * @author Giselle
 */

public class PrestamoAlmacen<T> extends GenericDao<T> implements PersistenciaPrestamo {

  private String query;
  private Connection conexion;
  private List<Prestamo> prestamos = new ArrayList<Prestamo>();

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

    String query2 = "UPDATE `centro_de_computo`.`equipo` "
        + "SET"
            + "`estado` = 'prestado' "
                + "WHERE equipo.numero_inventario like ?;";
    try (PreparedStatement statement = conexion.prepareStatement(query);
            PreparedStatement statement2 = conexion.prepareStatement(query2);) {

      statement.setString(1, nombreSolicitante);
      statement.setString(2, matricula);
      statement.setString(3, fechaPrestamo);
      statement.setString(4, horaPrestamo);
      statement.setString(5, equipo);
      statement.setString(6, salon);
      statement.executeUpdate();

      statement2.setString(1, equipo);
      statement2.executeUpdate();

      conexion.commit();
      statement.close();

    } catch (SQLException ex) {
      throw new SQLException();
    } finally {
      conexion.close();
    }

  }

  @Override
  public List<Prestamo> obtenerTodosLosPrestamos() throws SQLException {
    conexion = this.conectar();
    query = "Select * from centro_de_computo.prestamo;";
    try (PreparedStatement statement = conexion.prepareStatement(query)) {

      ResultSet result
              = this.ejecutarQuery(statement);
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
      throw new SQLException();
    } finally {
      conexion.close();
    }
    return prestamos;

  }

  @Override
  public List<Prestamo> obtenerPrestados() throws SQLException {
    List<Prestamo> prestados = new ArrayList<Prestamo>();
    conexion = this.conectar();
    query = "SELECT * FROM centro_de_computo.prestamo WHERE fecha_entrega IS null;";
    try (PreparedStatement statement = conexion.prepareStatement(query)) {

      ResultSet result
              = this.ejecutarQuery(statement);

      while (result.next()) {
        Prestamo prestamo = new Prestamo(result.getInt("numero_prestamo"),
            result.getString("fecha_prestamo"),
                result.getString("equipo_numero_inventario"),
                    result.getString("matricula_solicitante"),
                        result.getString("nombre_solicitante"),
                            result.getString("salon"));

        prestados.add(prestamo);
      }

    } catch (SQLException ex) {
      throw new SQLException();
    } finally {
      conexion.close();
    }
    return prestados;
  }

  @Override
  public void registrarDevolucion(int numeroPrestamo, String fechaDevolucion,
          String horaDevolucion, String equipo)
          throws SQLException {

    conexion = this.conectar();
    query = "UPDATE centro_de_computo.prestamo SET "
        + "fecha_entrega = ?, hora_entrega = ? "
            + "WHERE numero_prestamo = ?;";

    String query2 = "UPDATE centro_de_computo.equipo SET estado = 'disponible' "
        + "WHERE numero_inventario = ?;";

    try (PreparedStatement statement = conexion.prepareStatement(query);
            PreparedStatement statement2 = conexion.prepareStatement(query2)) {

      statement.setString(1, fechaDevolucion);
      statement.setString(2, horaDevolucion);
      statement.setInt(3, numeroPrestamo);
      statement.executeUpdate();

      statement2.setString(1, equipo);
      statement2.executeUpdate();

      conexion.commit();
      statement.close();

    } catch (SQLException ex) {
      throw new SQLException();
    } finally {
      conexion.close();
    }
  }

  private ResultSet ejecutarQuery(PreparedStatement stp) throws SQLException {
    try {
      return stp.executeQuery();
    } catch (SQLException e) {
      throw new SQLException();
    }
  }

}
