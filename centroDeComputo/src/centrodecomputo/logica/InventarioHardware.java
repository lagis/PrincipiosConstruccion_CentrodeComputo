/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrodecomputo.logica;

import centrodecomputo.persistencia.EquipoAlmacen;
import centrodecomputo.persistencia.PersistenciaEquipo;
import java.util.List;

/**
 *
 * @author ferc
 */
public class InventarioHardware {
  private List<Equipo> inventario;
  private PersistenciaEquipo persistencia = new EquipoAlmacen();
  
    public void registrarEquipo(String modelo, String numeroSerie, String tipoEquipo,String marca, String responsableUbicacion) {
    this.persistencia.registrarEquipo(modelo, numeroSerie, tipoEquipo, marca, responsableUbicacion);
  }
  
}
