/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import persistencia.DictamenMantenimientoAlmacen;
import persistencia.PersistenciaDictamenMantenimiento;

/**
 * Contiene los datos que se registran durante un mantenimiento de equipo.
 * 
 * @author ferc
 * @author Giss
 * @author Pao
 */

public class DictamenMantenimiento implements InterfaceDictamenMantenimiento{
  private String nombreTecnico;
  private String apellidoPaternoTecnico;
  private String apellidoMaternoTecnico;
  private java.sql.Date fecha;
  private String region;
  private String telefonoTecnico;
  private String correoTecnico;
  private String entidadAcademica;
  private String tipoBorrado; 
  private String observaciones;
  private int numeroDeReporte;
  private String tipoDictamen;
  private String descripcion;
  private PersistenciaDictamenMantenimiento persistencia =
      new DictamenMantenimientoAlmacen();
  
  
  public DictamenMantenimiento(String nombreTecnico, String apellidoPaternoTecnico,
      String apellidoMaternoTecnico, java.sql.Date fecha, String region,
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
      String apellidoMaternoTecnico, java.sql.Date fecha, String region,
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

  public DictamenMantenimiento() {
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
  
  @Override
  public void registrarDictamenString(java.sql.Date fecha, String region, 
      String dependencia, String tipoBorrado, String observaciones, 
          String tipoDictamen, 
              String descripcion, String idPersonal, String numeroInventario) 
                  throws SQLException {
    
    this.persistencia.registrarDictamenString(
        fecha, region, dependencia, tipoBorrado, observaciones, tipoDictamen, 
                descripcion, idPersonal, numeroInventario);
  
  }
  
    @Override
  public List<DictamenMantenimiento> generarReporteMantinimiento(Date fecha) {
    throw new UnsupportedOperationException("Not supported yet."); 
    //To change body of generated methods, choose Tools | Templates.
  }
  
}