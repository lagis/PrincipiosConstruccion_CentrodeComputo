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
import logica.DictamenMantenimiento;

/**
 * Permite administrar un dictamen de mantenimiento mediante una base de datos mysql.
 * @author PREDATOR 15 G9-78Q
 */

public class DictamenMantenimientoAlmacen<T> extends GenericDao<T>
    implements PersistenciaDictamenMantenimiento<T> {

  
  /**
   * Registra el mantenimiento de un equipo.
   *
   * @param fecha java.sql.Date.
   * @param region String.
   * @param dependencia String.
   * @param tipoBorrado String.
   * @param observaciones String.
   * @param tipoDictamen String.
   * @param descripcion String.
   * @param idPersonal String.
   * @param numeroInventario String.
   * @throws SQLException Arroja esta excepción cuando no es posible concretar la conexion.
   */
  
  @Override
  public void registrarDictamenString(java.sql.Date fecha, String region,
      String dependencia, String tipoBorrado, String observaciones, String tipoDictamen,
      String descripcion, String idPersonal, String numeroInventario) throws SQLException {

    Connection miConexion = this.conectar();
    String query = "INSERT INTO centro_de_computo.dictamen_de_mantenimiento "
        + "(fecha, region,  dependencia_solicitante, tipo_borrado, "
            + "observaciones_equipo, "
                + "tipo_dictamen, descripcion_dictamen, "
                    + "personal_idpersonal, equipo_numero_inventario) "
                        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";

    try(PreparedStatement stp = miConexion.prepareStatement(query)) {
      
      stp.setDate(1, fecha);
      stp.setString(2, region);
      stp.setString(3, dependencia);
      stp.setString(4, tipoBorrado);
      stp.setString(5, observaciones);
      stp.setString(6, tipoDictamen);
      stp.setString(7, descripcion);
      stp.setInt(8, Integer.parseInt(idPersonal));
      stp.setString(9, numeroInventario);

      stp.executeUpdate();

      miConexion.commit();
      stp.close();
    } catch (SQLException e) {
      throw new SQLException();
    } finally {
      miConexion.close();

    }
  }

  /**
   * Recupera una lista con los dictámenes del equipo respectivo.
   *
   * @param id Número de identificador del que se quiere.
   * @return Retorna una lista con los dictámenes de mantenimiento registrados al equipo.
   */
  
  @Override
  public List<DictamenMantenimiento> consultarListaDictamen(String id) {
    throw new UnsupportedOperationException("Not supported yet."); 
    //To change body of generated methods, choose Tools | Templates.
  }

  
  /**
   * 
   * @param fehca
   * @return
   * @throws SQLException 
   */
  
  @Override
  public List<DictamenMantenimiento> generarReporte(java.sql.Date fehca) throws SQLException {
    List<DictamenMantenimiento> lista = new ArrayList<DictamenMantenimiento>();
    Connection miConexion = this.conectar();
    String query = "SELECT * FROM centro_de_computo.dictamen_de_mantenimiento "
        + "WHERE fecha >= ?;";
    try (PreparedStatement stp = miConexion.prepareStatement(query)) {
        stp.setDate(1, fehca);
      ResultSet resultadoQuery
          = this.ejecutarQuery(stp);
      while (resultadoQuery.next()) {
        DictamenMantenimiento dictamen
            = new DictamenMantenimiento(resultadoQuery.getDate("fecha"), resultadoQuery.getString("region"),
                resultadoQuery.getString("dependencia_solicitante"), resultadoQuery.getString("tipo_borrado"),
                    resultadoQuery.getString("observaciones_equipo"), 
                        resultadoQuery.getInt("numero_reporte"), resultadoQuery.getString("tipo_dictamen"),
                        resultadoQuery.getString("descripcion_dictamen"));
        lista.add(dictamen);

      }
      
      return lista;

    } catch (SQLException e) {
      throw new SQLException();
    } finally {
      miConexion.close();
      
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
