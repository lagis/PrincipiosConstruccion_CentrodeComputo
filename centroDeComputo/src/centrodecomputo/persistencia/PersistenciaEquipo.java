/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrodecomputo.persistencia;

import centrodecomputo.logica.DictamenMantenimiento;
import centrodecomputo.logica.Equipo;
import centrodecomputo.logica.Prestamo;
import java.util.List;

/**
 *
 * @author PREDATOR 15 G9-78Q
 */
public interface PersistenciaEquipo<T> {
 
  public void registrarEquipo(String modelo, String numeroSerie, String tipoEquipo, String marca, String responsableUbicacion);
  public List<Prestamo> consultarPrestamos(int id);
  public List<DictamenMantenimiento> consultarListaDictamen(int id);
  public Equipo consultarEquipo(int id);
  /* todo
  métodos para registrar y consultar citas y mantenimientos.
  */
  
}
