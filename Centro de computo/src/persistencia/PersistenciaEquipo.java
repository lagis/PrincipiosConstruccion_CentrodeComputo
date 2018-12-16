/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;


import java.sql.SQLException;
import java.util.List;
import logica.Equipo;

/**
 * Permite guardar acceder a métodos de persistencia de Equipo.
 * @author PREDATOR 15 G9-78Q
 */

public interface PersistenciaEquipo<T> {
 
  public void registrarEquipo(String modelo, String numeroSerie, String tipoEquipo, 
      String marca, String responsableUbicacion) throws SQLException ;
  
  public Equipo consultarEquipo(String id) throws SQLException ;
  
  public List<Equipo> consultarListaEquipo() throws SQLException;
  
  public void cambiarResponsable(String id, String nuevaUbicacion) throws SQLException;
  
  
}
