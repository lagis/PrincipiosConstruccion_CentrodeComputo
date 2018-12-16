/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import conexion.GenericDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import static javafx.scene.input.KeyCode.T;
import logica.DictamenMantenimiento;


/**
 *
 * @author PREDATOR 15 G9-78Q
 */
public class DictamenMantenimientoAlmacen<T> extends GenericDao<T> 
    implements PersistenciaDictamenMantenimiento<T>{

  /**
   * Registra el mantenimiento de un equipo.
   * @param fecha java.sql.Date
   * @param region String
   * @param dependencia String
   * @param tipoBorrado String
   * @param observaciones String
   * @param tipoDictamen String
   * @param descripcion String
   * @param idPersonal String
   * @param numeroInventario String
   * @throws SQLException Arroja esta excepción cuando no es posible 
   * concretar la conexion.
   */
  
  @Override
  public void registrarDictamenString(java.sql.Date fecha, String region, 
      String dependencia, String tipoBorrado, String observaciones, String tipoDictamen, 
          String descripcion, String idPersonal, String numeroInventario) throws SQLException {
    
    
    Connection miConexion = this.conectar();
    PreparedStatement stp = null;
    
    try {
      
      stp = miConexion.prepareStatement(
          "INSERT INTO centro_de_computo.dictamen_de_mantenimiento "
              + "(fecha, region,  dependencia_solicitante, tipo_borrado, "
                  + "observaciones_equipo, "
                      + "tipo_dictamen, descripcion_dictamen, "
                          + "personal_idpersonal, equipo_numero_inventario) "
                              + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);");
      
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
    } catch (SQLException e) {
      e.printStackTrace();
      throw new SQLException();
    } finally {
      try {
        stp.close();
        miConexion.close();
      } catch (SQLException e) {
        throw new SQLException();
      }
    }
  }
  
    /**
  * Recupera una lista con los dictámenes del equipo respectivo.
  * @param id Número de identificador del que se quiere. 
  * @return Retorna una lista con los dictámenes de mantenimiento registrados al equipo.
  */

  @Override
  public List<DictamenMantenimiento> consultarListaDictamen(String id) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  

  
}
