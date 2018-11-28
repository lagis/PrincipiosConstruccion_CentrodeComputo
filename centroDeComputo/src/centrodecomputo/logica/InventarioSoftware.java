/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrodecomputo.logica;

import centrodecomputo.persistencia.PersistenciaSoftware;
import centrodecomputo.persistencia.SoftwareAlmacen;
import java.util.List;

/**
 *
 * @author ferc
 */
public class InventarioSoftware implements InterfaceSoftware{
  private List<Software> inventario;
  private PersistenciaSoftware persistencia 
      = new SoftwareAlmacen();

  @Override
  public void actualizarNumeroLicencias(String cantidad) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void registrarSoftware(String nombre, String version, int numeroLicencias, String observaciones, String tipoSoftware) {
    this.persistencia.registrarSoftware(nombre, version, numeroLicencias, observaciones, tipoSoftware);
  }

  @Override
  public Software consultarSoftware(int idSoftware) {
    return this.persistencia.consultarSoftware(idSoftware);
  }

  @Override
  public List<Software> consultarListaSoftware() {
    return this.persistencia.consultarListaSoftware();
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
