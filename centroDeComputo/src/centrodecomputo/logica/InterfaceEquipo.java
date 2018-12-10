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
  public void registrarDictamen(String nombreTecnico, String apellidoPaternoTecnico,
      String apellidoMaternoTecnico, Date fecha, String region,
          String telefono, String correo, String entidadAcademica, String tipoBorrado,  
              String observaciones, String tipoDictamen, String descripcion);
  public List<Prestamo> consultarPrestamo();
  public String getDisponibilidad();
  public int getIdentificador();
  public String getModelo();
  public String getNumeroSerie();
  public String getTipoEquipo();
  public String getMarca();
  public String getResponsableUbicacion();
  
}
