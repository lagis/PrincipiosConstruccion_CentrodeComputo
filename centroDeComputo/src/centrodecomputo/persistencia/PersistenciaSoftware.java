/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrodecomputo.persistencia;

import centrodecomputo.logica.Equipo;
import centrodecomputo.logica.Software;
import java.util.List;

/**
 *
 * @author PREDATOR 15 G9-78Q
 */
public interface PersistenciaSoftware {
  
  public void registrarSoftware(String nombre, String version, int numeroLicencias, String observaciones, String tipoSoftware);
  public Software consultarSoftware(int idSoftware);
  public List<Software> consultarListaSoftware();
  public void asignarSoftware(int idSoftware, int idEquipo);
  public void actualizarLicencias(int idSoftware, int cantidadLicencias);
  public void eliminarEquipo(int idSoftware, int idEquipo);
  public List<Equipo> consultarEquiposAsignados(int idSoftware); 
  
}
