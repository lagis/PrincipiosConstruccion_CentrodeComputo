/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrodecomputo.logica;

/**
 *
 * @author ferc
 */
public class Software {
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
    
}
