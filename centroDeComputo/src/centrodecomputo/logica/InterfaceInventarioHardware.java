/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrodecomputo.logica;

import java.util.Date;
import java.util.List;

/**
 *
 * @author ferc
 */
public interface InterfaceInventarioHardware {
  public void registrarEquipo(String modelo, String numeroSerie, String tipoEquipo, String marca, String responsableUbicacion);
  public List<DictamenMantenimiento> generarReporteMantinimiento(Date fecha);
  public List<Equipo> consultarEquipoDisponible();  
}
