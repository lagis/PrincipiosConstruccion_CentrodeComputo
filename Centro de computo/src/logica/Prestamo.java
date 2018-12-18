/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.sql.SQLException;
import java.util.List;
import persistencia.PersistenciaPrestamo;
import persistencia.PrestamoAlmacen;


/**
 * clase logica del prestamo.
 * @author Giselle
 */
public class Prestamo implements InterfacePrestamo {

  private int numeroPrestamo;
  private String nombreSolicitante;
  private String matricula;
  private String fechaPrestamo;
  private String horaPrestamo;
  private String equipo;
  private String fechaDevolucion;
  private String horaDevolucion;
  private String salon;
  private PersistenciaPrestamo persistencia = new PrestamoAlmacen();

  public Prestamo() {
  }

  public Prestamo(String nombreSolicitante, String matricula,
          String fechaPrestamo, String horaPrestamo,
          String equipo, String fechaDevolucion,
          String horaDevolucion, String salon) {

    this.nombreSolicitante = nombreSolicitante;
    this.matricula = matricula;
    this.fechaPrestamo = fechaPrestamo;
    this.horaPrestamo = horaPrestamo; 
    this.equipo = equipo;
    this.fechaDevolucion = fechaDevolucion;
    this.horaDevolucion = horaDevolucion;
    this.salon = salon;
  }

  public Prestamo(int numeroPrestamo, String fechaPrestamo, String equipo,
          String matricula, String nombreSolicitante, String salon) {
    this.numeroPrestamo = numeroPrestamo;
    this.nombreSolicitante = nombreSolicitante;
    this.matricula = matricula;
    this.fechaPrestamo = fechaPrestamo;
    this.equipo = equipo;
    this.salon = salon;
  }

  public Prestamo(int numeroPrestamo, String fechaDevolucion, String horaDevolucion,
          String equipo) {
    this.numeroPrestamo = numeroPrestamo;
    this.fechaDevolucion = fechaDevolucion;
    this.horaDevolucion = horaDevolucion;
    this.equipo = equipo;
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
    return fechaDevolucion;
  }

  public String getHoraDevolucion() {
    return horaDevolucion;
  }

  public String getSalon() {
    return salon;
  }

  /**
   * registra un prestamo nuevo.
   * @param nombreSolicitante  nombre del que solicita
   * @param matricula matricula de quien solicita
   * @param fechaPrestamo fecha cuando se solicita
   * @param horaPrestamo hora del prestamo
   * @param equipo el equipo que se presta
   * @param salon salon donde se ocupa
   * @throws SQLException  Por si causa problemas la base
   */
  @Override
  public void registrarPrestamo(String nombreSolicitante, String matricula,
          String fechaPrestamo, String horaPrestamo,
          String equipo, String salon) throws SQLException {
    this.persistencia.registrarPrestamo(nombreSolicitante, matricula,
            fechaPrestamo, horaPrestamo, equipo, salon);
  }

  /**
   * obtiene una lista de dos los prestamos registrados.
   * @return lista de prestamos registrados.
   * @throws SQLException Por si causa problemas la base
   */
  @Override
  public List<Prestamo> obtenerTodosLosPrestamos()
          throws SQLException {
    return this.persistencia.obtenerTodosLosPrestamos();
  }

  
  /**
   * obtiene solo los registros de los equipos con estado de prestados.
   * @return lista de equipos prestados.
   * @throws SQLException Por si causa problemas la base
   */
  @Override
  public List<Prestamo> obtenerPrestados() throws SQLException {
    return this.persistencia.obtenerPrestados();
  }

  /**
   * edita un registro de prestamos para poner que ha sido devuelto.
   * @param numeroPrestamo numero del prestamo a registrar
   * @param fechaDevolucion fecha cuando se devolvio
   * @param horaDevolucion hora a la que se devolvio
   * @param equipo equipo prestado
   * @throws SQLException Por si causa problemas la base
   */
  @Override
  public void registrarDevolucion(int numeroPrestamo,
          String fechaDevolucion, String horaDevolucion,
          String equipo) throws SQLException {
    this.persistencia.registrarDevolucion(numeroPrestamo, fechaDevolucion,
            horaDevolucion, equipo);
  }

}
