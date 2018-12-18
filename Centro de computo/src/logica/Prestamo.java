/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.sql.SQLException;
import java.util.List;
import persistencia.PrestamoAlmacen;
import persistencia.PersistenciaPrestamo;
import java.lang.String;

/**
 *
 * @author Giselle
 */
public class Prestamo implements InterfacePrestamo {
  
  private int numeroPrestamo;
  private String nombreSolicitante;
  private String matricula;
  private String fechaPrestamo;
  private String horaPrestamo;
  private String equipo;
  private String FechaDevolucion;
  private String horaDevolucion;
  private String salon;
  private PersistenciaPrestamo persistencia = new PrestamoAlmacen();

  public Prestamo() {
  }

  public Prestamo(String nombreSolicitante, String matricula,
          String fechaPrestamo, String horaPrestamo,
          String equipo, String FechaDevolucion,
          String horaDevolucion, String salon) {

    this.nombreSolicitante = nombreSolicitante;
    this.matricula = matricula;
    this.fechaPrestamo = fechaPrestamo;
    this.horaPrestamo = horaPrestamo;
    this.equipo = equipo;
    this.FechaDevolucion = FechaDevolucion;
    this.horaDevolucion = horaDevolucion;
    this.salon = salon;
  }

  public Prestamo(String fechaPrestamo,String equipo,  String matricula,String nombreSolicitante,  String salon) {
    this.nombreSolicitante = nombreSolicitante;
    this.matricula = matricula;
    this.fechaPrestamo = fechaPrestamo;
    this.equipo = equipo;
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

  public String getFechaPrestamo() {
    return fechaPrestamo;
  }

  public String getHoraPrestamo() {
    return horaPrestamo;
  }

  public String getEquipo() {
    return equipo;
  }

  public String getFechaDevolucion() {
    return FechaDevolucion;
  }

  public String getHoraDevolucion() {
    return horaDevolucion;
  }

  public String getSalon() {
    return salon;
  }

  @Override
  public void registrarPrestamo(String nombreSolicitante, String matricula,
          String fechaPrestamo, String horaPrestamo,
          String equipo, String salon) throws SQLException{
    this.persistencia.registrarPrestamo(nombreSolicitante, matricula,
            fechaPrestamo, horaPrestamo, equipo, salon);
  }

  @Override
  public List<Prestamo> obtenerTodosLosPrestamos()
          throws SQLException {
    return this.persistencia.obtenerTodosLosPrestamos();
  }

  @Override
  public List<Prestamo> obtenerPrestados() throws SQLException {
    return this.persistencia.obtenerPrestados();
  }

  @Override
  public void registrarDevolucion(int numeroPrestamo,
          String FechaDevolucion,String horaDevolucion,
          String equipo) throws SQLException {
    this.persistencia.registrarDevolucion(numeroPrestamo,FechaDevolucion, horaDevolucion,equipo);
  }

}
