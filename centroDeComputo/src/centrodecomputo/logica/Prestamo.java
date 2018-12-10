/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrodecomputo.logica;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ferc
 */
public class Prestamo{

  private String nombreSolicitante;
  private String matricula;
  private String fechaPrestamo;
  private String horaPrestamo;
  private String equipo;
  private String FechaDevolucion;
  private String horaDevolucion;
  private String salon;

  public Prestamo(String nombreSolicitante, String matricula, String fechaPrestamo, String horaPrestamo, String equipo, String FechaDevolucion, String horaDevolucion, String salon) {
    this.nombreSolicitante = nombreSolicitante;
    this.matricula = matricula;
    this.fechaPrestamo = fechaPrestamo;
    this.horaPrestamo = horaPrestamo;
    this.equipo = equipo;
    this.FechaDevolucion = FechaDevolucion;
    this.horaDevolucion = horaDevolucion;
    this.salon = salon;
  }
  

  public Prestamo(){
    
  }

  public String consultarNombreSolicitante() {
    return nombreSolicitante;
  }

  public String consultarMatricula() {
    return matricula;
  }

  public String consultarFechaPrestamo() {
    return fechaPrestamo;
  }

  public String consultarHoraPrestamo() {
    return horaPrestamo;
  }

  public String consultarFechaDevolucion() {
    return FechaDevolucion;
  }

  public String consultarHoraDevolucion() {
    return horaDevolucion;
  }

  public String consultarSalon() {
    return salon;
  }

  
  
 
}
