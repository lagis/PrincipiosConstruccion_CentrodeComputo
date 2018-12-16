/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author ferc
 */
public interface InterfaceEquipo {
  
    public void registrarDictamen(String nombreTecnico, String apellidoPaternoTecnico,
      String apellidoMaternoTecnico, java.sql.Date fecha, String region,
          String telefono, String correo, String entidadAcademica, String tipoBorrado,  
              String observaciones, String tipoDictamen, String descripcion);
  public String getDisponibilidad();
  public String getIdentificador();
  public String getModelo();
  public String getNumeroSerie();
  public String getTipoEquipo();
  public String getMarca();
  public String getResponsableUbicacion();
  
}
