/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrodecomputo.logica;

import java.util.Date;

/**
 * Contiene los datos que se registran durante un mantenimiento de equipo.
 * 
 * @author ferc
 * @author Giss
 * @author Pao
 */

public class DictamenMantenimiento {
  private String nombreTecnico;
  private String apellidoPaternoTecnico;
  private String apellidoMaternoTecnico;
  private Date fecha;
  private String region;
  private String telefonoTecnico;
  private String correoTecnico;
  private String entidadAcademica;
  private String tipoBorrado; 
  private String observaciones;
  private int numeroDeReporte;
  private String tipoDictamen;
  private String descripcion;
  
  
  public DictamenMantenimiento(String nombreTecnico, String apellidoPaternoTecnico,
      String apellidoMaternoTecnico, Date fecha, String region,
          String telefono, String correo, String entidadAcademica, String tipoBorrado,  
              String observaciones, int numeroDeReporte, String tipoDictamen, String descripcion){
    this.nombreTecnico = nombreTecnico;
    this.apellidoPaternoTecnico = apellidoPaternoTecnico;
    this.apellidoMaternoTecnico = apellidoMaternoTecnico;
    this.fecha  = fecha;
    this.region = region;
    this.telefonoTecnico = telefono;
    this.correoTecnico = correo;
    this.entidadAcademica = entidadAcademica;
    this.tipoBorrado = tipoBorrado;
    this.observaciones = observaciones;
    this.numeroDeReporte = numeroDeReporte;
    this.tipoDictamen = tipoDictamen;
    this.descripcion = descripcion;
    
  }
  
    public DictamenMantenimiento(String nombreTecnico, String apellidoPaternoTecnico,
      String apellidoMaternoTecnico, Date fecha, String region,
          String telefono, String correo, String entidadAcademica, String tipoBorrado,  
              String observaciones, String tipoDictamen, String descripcion){
    this.nombreTecnico = nombreTecnico;
    this.apellidoPaternoTecnico = apellidoPaternoTecnico;
    this.apellidoMaternoTecnico = apellidoMaternoTecnico;
    this.fecha  = fecha;
    this.region = region;
    this.telefonoTecnico = telefono;
    this.correoTecnico = correo;
    this.entidadAcademica = entidadAcademica;
    this.tipoBorrado = tipoBorrado;
    this.observaciones = observaciones;
    this.numeroDeReporte = numeroDeReporte;
    this.tipoDictamen = tipoDictamen;
    this.descripcion = descripcion;
    
  }
  
  
  public String consultarNombre(){
    return this.nombreTecnico;
  }
  
  public String consultarApellidoPaterno(){
    return this.apellidoPaternoTecnico;
  }
  
  public String consultarApellidoMaterno(){
    return this.apellidoMaternoTecnico;
  }
  
  public Date consultarFecha(){
    return this.fecha;
  }
  
  public String consultarRegion(){
    return this.region;
  }
  
  public String consultarTelefono(){
    return this.telefonoTecnico;
  }
  
  public String consultarCorreo(){
    return this.correoTecnico;
  }
  
  public String consultarEntidadAcademica(){
    return this.entidadAcademica;
  }
  
  public String consultarTipoBorrado(){
    return this.consultarDescripcion();
  }
  
  public String consultarObservaciones(){
    return this.observaciones;
  }
  
  public int consultarNumeroReporte(){
    return this.numeroDeReporte;
  }
  
  public String consultarTipoDictamen(){
    return this.tipoDictamen;
  }
  
  public String consultarDescripcion(){
    return this.descripcion;
  }
  
}
