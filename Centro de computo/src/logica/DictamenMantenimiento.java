/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.sql.SQLException;
import java.util.Calendar;
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

public class DictamenMantenimiento implements InterfaceDictamenMantenimiento {
  private String nombreTecnico;
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
  private String idEquipo;
  private PersistenciaDictamenMantenimiento persistencia =
      new DictamenMantenimientoAlmacen();
  
 
  public DictamenMantenimiento(String nombreTecnico, java.sql.Date fecha, String region,
          String telefono, String correo, String entidadAcademica, String tipoBorrado,  
              String observaciones, int numeroDeReporte, String tipoDictamen, String descripcion) {
    this.nombreTecnico = nombreTecnico;
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
  
  public DictamenMantenimiento(java.sql.Date fecha, String region,
      String entidadAcademica, String tipoBorrado,
          String observaciones, int numeroDeReporte, String tipoDictamen, String descripcion, 
          String idEquipo) {
    
    this.fecha = fecha;
    this.region = region;
    this.entidadAcademica = entidadAcademica;
    this.tipoBorrado = tipoBorrado;
    this.observaciones = observaciones;
    this.numeroDeReporte = numeroDeReporte;
    this.tipoDictamen = tipoDictamen;
    this.descripcion = descripcion;
    this.idEquipo = idEquipo;

  }

  public DictamenMantenimiento() {
  }
  
  
  public String getNombre() {
    return this.nombreTecnico;
  }
  
  public Date getFecha() {
    return this.fecha;
  }
  
  public String getRegion() {
    return this.region;
  }
  
  public String getTelefono() {
    return this.telefonoTecnico;
  }
  
  public String getCorreo() {
    return this.correoTecnico;
  }
  
  public String getEntidadAcademica() {
    return this.entidadAcademica;
  }
  
  public String getTipoBorrado() {
    return this.tipoBorrado;
  }
  
  public String getObservaciones() {
    return this.observaciones;
  }
  
  public int getNumeroDeReporte() {
    return this.numeroDeReporte;
  }
  
  public String getTipoDictamen() {
    return this.tipoDictamen;
  }
  
  public String getDescripcion() {
    return this.descripcion;
  }
  
  public String getIdEquipo() {
    return this.idEquipo;
  }
  
  
  /**
   * Permite registrar un nuevo dictamen de mantenimiento.
   * @param fecha Tipo Date, es la fecha de cuando se registra el dictamen.
   * @param region String, región dónde se registra el dictamen.
   * @param dependencia String, dependencia académica de donde procede el dictamen.
   * @param tipoBorrado String, tipo de borrado que se le hará al equipo.
   * @param observaciones String, observaciones correspondientes al equipo que se 
   * le hará el mantenimiento.
   * @param tipoDictamen String
   * @param descripcion String, descripción del procedimiento.
   * @param idPersonal String, Núnero de empleado correspondiente al personal.
   * @param numeroInventario String, correspondiente al equipo.
   * @throws SQLException Se arroja cuando no es posible realizar el registro del equipo.
   */
  
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

  /**
   * genera un reporte del mantenimiento ocurrido desde la fecha indicada hasta
   * la actualidad.
   * @param fecha Dato de tipo Date que contrá la fecha desde que se quiere
   * realizar el dictamen.
   * @return retorna una lista con los dictámenes
   * realizados desde esa fecha hasta la actualidad
   */
  
  @Override
  public List<DictamenMantenimiento> generarReporteMantinimiento() throws SQLException{
    Date fecha = new Date();
    int apartirDeMeses = -6;
    Date fecha2 = this.sumarMeses(fecha, apartirDeMeses);
    java.sql.Date dateSql = new java.sql.Date(fecha2.getTime());
    return this.persistencia.generarReporte(dateSql);
  }
  
  private Date sumarMeses(Date fecha, int mesesSumados) {
    Calendar calendario = Calendar.getInstance();
    calendario.setTime(fecha);
    calendario.add(Calendar.MONTH, mesesSumados);
    return calendario.getTime();
  }
  
}