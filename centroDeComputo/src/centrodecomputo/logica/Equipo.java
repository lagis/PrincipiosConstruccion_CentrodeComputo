/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrodecomputo.logica;

import centrodecomputo.persistencia.EquipoAlmacen;
import centrodecomputo.persistencia.PersistenciaEquipo;
import java.util.Date;
import java.util.List;

/**
 * contiene los datos de un equipo además de 
 * métodos para registrar un mantenimiento o un préstamo.
 * @author ferc
 * @author Giss
 * @author Pao
 */

public class Equipo implements InterfaceEquipo{
  
  private int identificador;
  private String modelo;
  private String numeroSerie;
  private String tipoEquipo;
  private String marca;
  private String responsableUbicacion;
  private boolean disponibilidad;
  private PersistenciaEquipo persistencia = new EquipoAlmacen();
  

  /**
   * registra el préstamo de un equipo.
   * @param prestamo un préstamo nuevo registrado. 
   */
  
  public Equipo(int identificador, String modelo, String numeroSerie,
      String tipoEquipo, String marca, String responsableUbicacion, boolean disponibilidad){
    this.modelo = modelo;
    this.numeroSerie = numeroSerie;
    this.tipoEquipo = tipoEquipo;
    this.identificador = identificador;
    this.marca = marca;
    this.responsableUbicacion = responsableUbicacion;
    this.disponibilidad = disponibilidad;    
  }
  
  public Equipo(String modelo, String numeroSerie,
      String tipoEquipo, String marca, String responsableUbicacion){
    this.modelo = modelo;
    this.numeroSerie = numeroSerie;
    this.tipoEquipo = tipoEquipo;
    this.marca = marca;
    this.responsableUbicacion = responsableUbicacion;
    this.disponibilidad = true;
  }
  
  
  @Override
  public void registrarPrestamoEquipo(Prestamo prestamo) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

/**
 * Registra un nuevo dictamen de mantenimiento para el equipo actual.
 * @param nombreTecnico
 * @param apellidoPaternoTecnico
 * @param apellidoMaternoTecnico
 * @param fecha
 * @param region
 * @param telefono
 * @param correo
 * @param entidadAcademica
 * @param tipoBorrado
 * @param observaciones
 * @param numeroDeReporte
 * @param tipoDictamen
 * @param descripcion 
 */
  
  @Override
  public void registrarDictamen(String nombreTecnico, String apellidoPaternoTecnico,
      String apellidoMaternoTecnico, Date fecha, String region,
          String telefono, String correo, String entidadAcademica, String tipoBorrado,  
              String observaciones, String tipoDictamen, String descripcion) {
    
    DictamenMantenimiento nuevoDictamen = new DictamenMantenimiento(nombreTecnico, apellidoPaternoTecnico,
      apellidoMaternoTecnico, fecha, region,
           telefono, correo, entidadAcademica, tipoBorrado,  
               observaciones, tipoDictamen, descripcion);
  
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  /**
   * consulta los préstamos registrados en el equipo.
   * @return  regresa una lista con los prestamos registrados.
   */
  
  @Override
  public List<Prestamo> consultarPrestamo() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  /**
   * sirve para consultar la disponibilidad del equipo.
   * @return valor booleano que corresponde a la disponibilidad del equipo.
   */
  
  
  @Override
  public boolean consultarDisponibilidad() {
    return this.disponibilidad;
  }

  public void registrarEquipo() {
    this.persistencia.registrarEquipo(this.modelo, this.numeroSerie, this.tipoEquipo, this.marca, this.responsableUbicacion);
  }

  @Override
  public int consultarId() {
    return this.identificador;
  }

  @Override
  public String consultarModelo() {
    return this.modelo;
  }

  @Override
  public String consultarNumeroSerie() {
    return this.numeroSerie;
  }

  @Override
  public String consultarTipoEquipo() {
    return this.tipoEquipo;
  }

  @Override
  public String consultarMarca() {
    return this.marca;
  }

  @Override
  public String responsableUbicacion() {
    return this.responsableUbicacion;
  }
  
}
