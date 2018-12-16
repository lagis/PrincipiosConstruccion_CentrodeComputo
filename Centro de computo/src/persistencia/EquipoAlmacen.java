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
import logica.Equipo;

/**
 * Permite guardar y recuperar Equipos, modificar sus datos y crear dictamenes.
 * @author PREDATOR 15 G9-78Q
 */
public class EquipoAlmacen<T> extends GenericDao<T> implements PersistenciaEquipo<T> {
  
  private String query;

  
  
  /**
   * Registra un equipo nuevo dentro de la base de datos.
   *
   * @param modelo String con el modelo del equipo.
   * @param numeroSerie String con el número de serie del equipo.
   * @param tipoEquipo String con el tipo de equipo que se va a registrar.
   * @param marca String con la marca del equipo.
   * @param responsableUbicacion String con el responsable o la ubicación del equipo.
   * @throws java.sql.SQLException Arroja esta excepción cuando no es posible concretar la conexion.
   */
  @Override
  public void registrarEquipo(String modelo, String numeroSerie, String tipoEquipo,
      String marca, String responsableUbicacion) throws SQLException {

    Connection miConexion = this.conectar();
    this.query = "INSERT INTO centro_de_computo.equipo "
        + "(numero_inventario, tipo_equipo, marca, "
            + "modelo, numero_serie) "
                + "VALUES(?, ?, ?, ?, ?);";
    String query2 = "INSERT INTO centro_de_computo.area (nombre_area, "
          + "equipo_numero_inventario) "
              + "VALUES(?, ?);";
    
    try (PreparedStatement stp = miConexion.prepareStatement(this.query); 
        PreparedStatement stp2 = miConexion.prepareStatement(query2)) {

      stp.setString(1, numeroSerie);
      stp.setString(2, tipoEquipo);
      stp.setString(3, marca);
      stp.setString(4, modelo);
      stp.setString(5, numeroSerie);
      stp.executeUpdate();

      stp2.setString(1, responsableUbicacion);
      stp2.setString(2, numeroSerie);
      stp2.executeUpdate();

      miConexion.commit();
    } catch (SQLException e) {
      throw new SQLException();
    } finally {
      miConexion.close();
       
    }
  }

  /**
   * Consulta un equipo registrado en la Base de datos.
   *
   * @param id entero correspondiente al identificador el Equio.
   * @return Retorna un objeto de tipo Equipo.
   * @throws java.sql.SQLException Arroja esta excepción cuando no es posible concretar la conexion.
   */
  @Override
  public Equipo consultarEquipo(String id) throws SQLException {
    Equipo equipo = null;
    Connection miConexion = this.conectar();
    this.query = "SELECT * FROM centro_de_computo.equipo WHERE idequipo = ?";
    
    try (PreparedStatement stp = miConexion.prepareStatement(this.query)) {
      
      stp.setString(1, id);

      ResultSet resultadoQuery
          = this.ejecutarQuery(stp);
      resultadoQuery.next();
      String modelo = resultadoQuery.getString("modelo");
      String numeroSerie = resultadoQuery.getString("numero_serie");
      String tipoEquipo = resultadoQuery.getString("tipo_equipo");
      String marca = resultadoQuery.getString("marca");
      String responsable = resultadoQuery.getString("responsable_ubicacion");
      String disponibilidad = resultadoQuery.getString("disponibilidad");
      equipo = new Equipo(id, modelo, numeroSerie,
          tipoEquipo, marca, responsable, disponibilidad);
      
    } catch (SQLException e) {
      throw new SQLException();
    } finally {
      miConexion.close();
    }
    return equipo;
  }
  
  
  private ResultSet ejecutarQuery(PreparedStatement stp) throws SQLException{
    try  {
      return stp.executeQuery();
    } catch (SQLException e) {
        throw new SQLException();
      }
  }

  /**
   * Recupera todos los Equipos almacenados en la Base de datos.
   *
   * @return Retorna una lista con los equipos almacenados.
   * @throws java.sql.SQLException Arroja esta excepción cuando no es posible concretar la conexion.
   */
  @Override
  public List<Equipo> consultarListaEquipo() throws SQLException {
    List<Equipo> listaDeEquipos = new ArrayList<Equipo>();
    Connection miConexion = this.conectar();
    this.query = "SELECT e.numero_inventario, e.tipo_equipo, e.marca, e.modelo, e.numero_serie, e.estado, "
        + "a.nombre_area FROM centro_de_computo.equipo e, centro_de_computo.area a "
            + "WHERE e.numero_inventario = a.equipo_numero_inventario;";
    try (PreparedStatement stp = miConexion.prepareStatement(this.query)) {

      ResultSet resultadoQuery
          = this.ejecutarQuery(stp);
      while (resultadoQuery.next()) {
        Equipo equipo = new Equipo(resultadoQuery.getString("e.numero_inventario"),
            resultadoQuery.getString("e.modelo"), resultadoQuery.getString("e.numero_serie"),
                resultadoQuery.getString("e.tipo_equipo"), resultadoQuery.getString("e.marca"),
                    resultadoQuery.getString("a.nombre_area"), resultadoQuery.getString("e.estado"));
        listaDeEquipos.add(equipo);
      }
       
    } catch (SQLException e) {
      throw new SQLException();
    }

      miConexion.close();
    return listaDeEquipos;
  }

  /**
   * Cambia el responsable a cargo de un equipo.
   *
   * @param id identificador del equipo de tipo String
   * @param nuevaUbicacion nueva ubicación del equipo.
   * @throws SQLException Arroja esta excepción cuando no es posible concretar la conexion.
   */
  
  @Override
  public void cambiarResponsable(String id, String nuevaUbicacion) throws SQLException {

    Connection miConexion = this.conectar();
    this.query = "UPDATE centro_de_computo.area "
        + "SET nombre_area = ? WHERE equipo_numero_inventario = ? ;";
    
    String query2 = "UPDATE centro_de_computo.equipo "
        + "SET estado = ? WHERE numero_inventario = ? ;";
    
    try (PreparedStatement stp = miConexion.prepareStatement(this.query);
        PreparedStatement stp2 = miConexion.prepareStatement(query2)) {

      stp.setString(1, nuevaUbicacion);
      stp.setString(2, id);
      stp.executeUpdate();

      if (nuevaUbicacion.equalsIgnoreCase("fuera de servicio")) {
        stp2.setString(1, "No disponible");
        stp2.setString(2, id);

      } else {
        stp2.setString(1, "Disponible");
        stp2.setString(2, id);
      }
      stp2.executeUpdate();
      miConexion.commit();

    } catch (SQLException e) {
      throw new SQLException();
    } finally {
      miConexion.close();
    }
      
  }

}
