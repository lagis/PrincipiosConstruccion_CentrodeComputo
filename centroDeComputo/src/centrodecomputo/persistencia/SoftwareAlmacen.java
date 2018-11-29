/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrodecomputo.persistencia;

import centrodecomputo.logica.Equipo;
import centrodecomputo.logica.Software;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author PREDATOR 15 G9-78Q
 */
public class SoftwareAlmacen extends GenericDao implements PersistenciaSoftware{

  public SoftwareAlmacen() {
  }

  /**
   * Registra un nuevo software en la base de datos.
   * @param nombre String con el nombre del nuevo software a registrar.
   * @param version Version del software que se está registrando.
   * @param numeroLicencias Número entero que indica la cantidad de licencias.
   * @param observaciones Observaciones sobre el número de licencias del software.
   * @param tipoSoftware tipo del software que se está registrando..
   */
  
  @Override
  public void registrarSoftware(String nombre, String version, int numeroLicencias, String observaciones, String tipoSoftware) {
    Connection miConexion = this.conectar();
    PreparedStatement stp = null;
    try {
      String insert = "INSERT INTO centro_de_computo.software(nombre, version, "
          + "numero_licencias,  tipo_software, observaciones) VALUES(?,?,?,?,?)";
      
      stp = miConexion.prepareStatement(insert);
      
      stp.setString(1, nombre);
      stp.setString(2, version);
      stp.setInt(3, numeroLicencias);
      stp.setString(4, observaciones);
      stp.setString(5, tipoSoftware);
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
   * Recupera el registro de un software específico de la base de datos.
   * @param idSoftware int con el identificador del software registrado.
   * @return Retorna un objeto de tipo Software si lo encuentra en la
   * base de datos y un software null si no existe.
   */
  
  @Override
  public Software consultarSoftware(int idSoftware) {
    Software software = null;
    Connection miConexion = this.conectar();
    PreparedStatement stp = null;
    
    try {
     stp = miConexion.prepareStatement("SELECT * FROM centro_de_computo.software WHERE idequipo = ?");
     stp.setInt(1, idSoftware);
     ResultSet resultadoQuery = stp.executeQuery();
     resultadoQuery.next();
     String nombre = resultadoQuery.getString("nombre");
     String version = resultadoQuery.getString("version");
     int numeroLicencias = resultadoQuery.getInt("numero_licencias");
     String tipoSoftware = resultadoQuery.getString("tipo_software");
     String observaciones = resultadoQuery.getString("observaciones");
     software = new Software(idSoftware, nombre, version,
        numeroLicencias, tipoSoftware, observaciones);
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        miConexion.close();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      return software;
    }
  }

  /**
   * Consulta todos los los equipos registrados en la base de datos.
   * @return Regresa una list con el software registrado en la base de datos.
   */
  
  @Override
  public List<Software> consultarListaSoftware () {
    
    List<Software> listaDeSoftware = null;
    Connection miConexion = this.conectar();
    PreparedStatement stp = null;
    try {
     stp = miConexion.prepareStatement("SELECT * FROM centro_de_computo.software");
     ResultSet resultadoQuery = stp.executeQuery();
     
     while (resultadoQuery.next()) {
       int idSoftware = resultadoQuery.getInt("idsoftware");
       String nombre = resultadoQuery.getString("nombre");
       String version = resultadoQuery.getString("version");
       int numeroLicencias = resultadoQuery.getInt("numero_licencias");
       String tipoSoftware = resultadoQuery.getString("tipo_software");
       String observaciones = resultadoQuery.getString("observaciones");
       listaDeSoftware.add(new Software(idSoftware, nombre, version, numeroLicencias,
              tipoSoftware, observaciones));

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
      return listaDeSoftware;
    }
  }

  @Override
  public void asignarSoftware(int idSoftware, int idEquipo) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void actualizarLicencias(int idSoftware, int cantidadLicencias) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void eliminarEquipo(int idSoftware, int idEquipo) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Equipo> consultarEquiposAsignados(int idSoftware) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  
}
