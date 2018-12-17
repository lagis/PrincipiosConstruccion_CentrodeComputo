/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import persistencia.PrestamoAlmacen;
import persistencia.PersistenciaPrestamo;

/**
 *
 * @author Giselle
 */
public class Prestamo implements InterfacePrestamo {
  
  private int numeroPrestamo;
  private String nombreSolicitante;
  private String matricula;
  private java.sql.Date fechaPrestamo;
  private java.sql.Time horaPrestamo;
  private String equipo;
  private java.sql.Date FechaDevolucion;
  private java.sql.Time horaDevolucion;
  private String salon;
  private PersistenciaPrestamo persistencia = new PrestamoAlmacen();

  public Prestamo() {
  }

  public Prestamo(String nombreSolicitante, String matricula,
          java.sql.Date fechaPrestamo, java.sql.Time horaPrestamo,
          String equipo, java.sql.Date FechaDevolucion,
          java.sql.Time horaDevolucion, String salon) {

    this.nombreSolicitante = nombreSolicitante;
    this.matricula = matricula;
    this.fechaPrestamo = fechaPrestamo;
    this.horaPrestamo = horaPrestamo;
    this.equipo = equipo;
    this.FechaDevolucion = FechaDevolucion;
    this.horaDevolucion = horaDevolucion;
    this.salon = salon;
  }

  public int getNumeroPrestamo() {
    return numeroPrestamo;
  }

  public String getNombreSolicitante() {
    return nombreSolicitante;
  }

  public String getMatricula() {
    return matricula;
  }

  public Date getFechaPrestamo() {
    return fechaPrestamo;
  }

  public Time getHoraPrestamo() {
    return horaPrestamo;
  }

  public String getEquipo() {
    return equipo;
  }

  public Date getFechaDevolucion() {
    return FechaDevolucion;
  }

  public Time getHoraDevolucion() {
    return horaDevolucion;
  }

  public String getSalon() {
    return salon;
  }

  @Override
  public void registrarPrestamo(String nombreSolicitante, String matricula,
          java.sql.Date fechaPrestamo, java.sql.Time horaPrestamo, String equipo,
          String salon) throws SQLException{
    this.persistencia.registrarPrestamo(nombreSolicitante, matricula,
            fechaPrestamo, horaPrestamo, equipo, salon);
  }

  @Override
  public List<DictamenMantenimiento> obtenerTodosLosPrestamos()
          throws SQLException {
    return this.persistencia.obtenerTodosLosPrestamos();
  }

  @Override
  public List<DictamenMantenimiento> obtenerPrestados() throws SQLException {
    return this.persistencia.obtenerPrestados();
  }

  @Override
  public void registrarDevolucion(int numeroPrestamo,Date FechaDevolucion, Time horaDevolucion,String equipo) throws SQLException {
    this.persistencia.registrarDevolucion(numeroPrestamo,FechaDevolucion, horaDevolucion,equipo);
  }

}
