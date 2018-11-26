/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrodecomputo.logica;

import java.util.Date;

/**
 *
 * @author ferc
 */
public class Prestamo {
  private Date fechaPrestamo;
  private String nombrePrestatario;
  private Date devolucion;
  
  
  public Prestamo(Date fecha, String prestatario){
    this.fechaPrestamo = fecha;
    this.nombrePrestatario = prestatario;
  }
  public Prestamo(Date fecha, String prestatario, Date devolucion){
    this.fechaPrestamo = fecha;
    this.nombrePrestatario = prestatario;
    this.devolucion = devolucion;
  }  
  
  public Date consultarFechaPrestamo(){
    return this.fechaPrestamo;
  }    
  
  public String consultarPrestatario(){
    return this.nombrePrestatario;
  }
  
  public Date consultarDevolucion(){
    return this.devolucion;
  }
  
}
