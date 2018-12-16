/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Contiene métodos para realizar operaciones administrativas sobre objeto de tipo Equipo.
 * @author ferc
 */

public interface InterfaceInventarioHardware {
  
  public void registrarEquipo(String modelo, String numeroSerie, String tipoEquipo,
      String marca, String responsableUbicacion) throws SQLException ;
  
  public List<Equipo> consultarListaEquipo() throws SQLException ;  
  
  public Equipo consultarEquipo(String id) throws SQLException ;
  
  public void cambiarResponsable(String id, String nuevaUbicacion) throws SQLException;
  
  
}
