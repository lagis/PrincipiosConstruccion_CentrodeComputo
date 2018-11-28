/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrodecomputo.logica;

import java.util.List;

/**
 *
 * @author ferc
 */
public class Software implements InterfaceSoftware{
  private int id;
  private String  nombre;
  private int numeroLicencias;
  private String tipoSoftware;
  private String version;
  private String observaciones;

  public Software(String nombre, String version, int numeroLicencias, String observaciones, String tipoSoftware){
    this.nombre = nombre;
    this.version = version;
    this.numeroLicencias = numeroLicencias;
    this.observaciones = observaciones;
    this.tipoSoftware = tipoSoftware;
  }

  public Software(int id, String nombre, String version, int numeroLicencias, String observaciones, String tipoSoftware){
    this.id = id;
    this.nombre = nombre;
    this.version = version;
    this.numeroLicencias = numeroLicencias;
    this.observaciones = observaciones;
    this.tipoSoftware = tipoSoftware;
  }

  @Override
  public void actualizarNumeroLicencias(String cantidad) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void registrarSoftware(String nombre, String version, int numeroLicencias, String observaciones, String tipoSoftware) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Software consultarSoftware(int idSoftware) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Software> consultarListaSoftware() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
