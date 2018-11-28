/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrodecomputo.logica;

import centrodecomputo.persistencia.EquipoAlmacen;
import centrodecomputo.persistencia.PersistenciaEquipo;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ferc
 */
public class InventarioHardware implements InterfaceInventarioHardware{
  private List<Equipo> inventario;
  private PersistenciaEquipo persistencia = new EquipoAlmacen();

  public InventarioHardware() {
  }

  @Override
  public void registrarEquipo(String modelo, String numeroSerie, String tipoEquipo,String marca, String responsableUbicacion) {
    this.persistencia.registrarEquipo(modelo, numeroSerie, tipoEquipo, marca, responsableUbicacion);
  }

  @Override
  public List<DictamenMantenimiento> generarReporteMantinimiento(Date fecha) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Equipo> consultarEquipoDisponible() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
    
    
    
  
}
