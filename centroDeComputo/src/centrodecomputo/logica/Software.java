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
public class Software implements InterfaceSoftware{
  private String  nombre;
  private int numeroLicencias;
  private String tipoSoftware;
  private String version;
  private String observaciones;

  @Override
  public void actualizarNumeroLicencias(String cantidad) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
    
}
