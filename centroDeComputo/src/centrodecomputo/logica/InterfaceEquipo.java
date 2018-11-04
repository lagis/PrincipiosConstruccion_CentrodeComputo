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
public interface InterfaceEquipo {
  
  public void registrarPrestamoEquipo(Prestamo prestamo);
  public void registrarDictamen(DictamenMantenimiento dictamen);
  public List<DictamenMantenimiento> generarReporteMantenimiento(Date fehca);
  public List<Prestamo> consultarPrestamo();
  public boolean consultarDisponibilidad();
}
