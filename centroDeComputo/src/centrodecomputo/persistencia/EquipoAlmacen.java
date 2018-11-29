/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrodecomputo.persistencia;

import centrodecomputo.logica.DictamenMantenimiento;
import centrodecomputo.logica.Equipo;
import centrodecomputo.logica.Prestamo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author PREDATOR 15 G9-78Q
 */
public class EquipoAlmacen<T> extends GenericDao<T> implements PersistenciaEquipo<T>{
  
  
/**
 * Registra un equipo nuevo dentro de la base de datos.
 * @param modelo String con el modelo del equipo.
 * @param numeroSerie String con el número de serie del equipo.
 * @param tipoEquipo String con el tipo de equipo que se va a registrar.
 * @param marca String con la marca del equipo.
 * @param responsableUbicacion String con el responsable o la ubicación del equipo.
 */
  
  @Override
  public void registrarEquipo(String modelo, String numeroSerie, String tipoEquipo, String marca, String responsableUbicacion) {
    Connection miConexion = this.conectar();
    PreparedStatement stp = null;
    try {
     
      String insert = "INSERT INTO centro_de_computo.equipo(numero_serie, tipo_equipo, "
        + "responsable_ubicacion,  marca, modelo) VALUES(?,?,?,?,?)";
      
      stp = miConexion.prepareStatement(insert);
      
      stp.setString(1, numeroSerie);
      stp.setString(2, tipoEquipo);
      stp.setString(3, responsableUbicacion);
      stp.setString(4, marca);
      stp.setString(5, modelo);
      stp.executeUpdate();
      miConexion.commit();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      System.out.println(e);
      e.printStackTrace();
    } finally {
      try {
        stp.close();
        miConexion.close();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

/**
 * Recupera una lista con los préstamos registrados al equipo respectivo.
 * @param id Número de identificador del equipo que se quiere recuperar la lista de préstamos.
 * @return Retorna una lista con los préstamos registrados al equipo.
 */  
  
  @Override
  public List<Prestamo> consultarPrestamos(int id) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

/**
 * Recupera una lista con los dictámenes del equipo respectivo.
 * @param id Número de identificador del que se quiere recuperar una lista de los dictámenes de mantenimiento.
 * @return Retorna una lista con los dictámenes de mantenimiento registrados al equipo.
 */
  
  @Override
  public List<DictamenMantenimiento> consultarListaDictamen(int id) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  /**
   * Consulta un equipo registrado en la Base de datos.
   * @param id entero correspondiente al identificador el Equio.
   * @return Retorna un objeto de tipo Equipo.
   */
  @Override
  public Equipo consultarEquipo(int id) {
    Equipo equipo = null;
    Connection miConexion = this.conectar();
    PreparedStatement stp = null;
    
    try {
     stp = miConexion.prepareStatement("SELECT * FROM centro_de_computo.equipo WHERE idequipo = ?");
     stp.setInt(1, id);
     ResultSet resultadoQuery = stp.executeQuery();
     resultadoQuery.next();
     String modelo = resultadoQuery.getString("modelo");
     String numeroSerie = resultadoQuery.getString("numero_serie");
     String tipoEquipo = resultadoQuery.getString("tipo_equipo");
     String marca = resultadoQuery.getString("marca");
     String responsable = resultadoQuery.getString("responsable_ubicacion");
     byte disponibilidad = resultadoQuery.getByte("disponibilidad");
     equipo = new Equipo(id, modelo, numeroSerie,
        tipoEquipo, marca, responsable, disponibilidad);

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        miConexion.close();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      return equipo;
    }

    
  }

  /**
   * Recupera todos los Equipos almacenados en la Base de datos.
   * @return Retorna una lista con los equipos almacenados.
   */
  @Override
  public List<Equipo> consultarListaEquipo() {
    List<Equipo> listaDeEquipos = null;
    Connection miConexion = this.conectar();
    PreparedStatement stp = null;
    try {
     stp = miConexion.prepareStatement("SELECT * FROM centro_de_computo.equipo");
     ResultSet resultadoQuery = stp.executeQuery();
     
     while (resultadoQuery.next()) {
      
       int id = resultadoQuery.getInt("idequipo");
       String modelo = resultadoQuery.getString("modelo");
       String numeroSerie = resultadoQuery.getString("numero_serie");
       String tipoEquipo = resultadoQuery.getString("tipo_equipo");
       String marca = resultadoQuery.getString("marca");
       String responsable = resultadoQuery.getString("responsable_ubicacion");
       byte disponibilidad = resultadoQuery.getByte("disponibilidad");
       listaDeEquipos.add(new Equipo(id, modelo, numeroSerie,
              tipoEquipo, marca, responsable, disponibilidad));

     }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        miConexion.close();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      return listaDeEquipos;
    }

  }

  
}
