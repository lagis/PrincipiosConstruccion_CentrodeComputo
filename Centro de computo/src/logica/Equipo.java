/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.sql.SQLException;
import java.util.List;
import persistencia.EquipoAlmacen;
import persistencia.PersistenciaEquipo;

/**
 * contiene los datos de un equipo además de métodos para registrar un
 * mantenimiento o un préstamo.
 *
 * @author ferc
 * @author Giss
 * @author Pao
 */
public class Equipo implements InterfaceEquipo {

  private String identificador;
  private String modelo;
  private String numeroSerie;
  private String tipoEquipo;
  private String marca;
  private String responsableUbicacion;
  private String disponibilidad;
  private PersistenciaEquipo persistencia = new EquipoAlmacen();

  public Equipo(String identificador, String modelo, String numeroSerie,
          String tipoEquipo, String marca, String responsableUbicacion, String disponibilidad) {
    this.modelo = modelo;
    this.numeroSerie = numeroSerie;
    this.tipoEquipo = tipoEquipo;
    this.identificador = identificador;
    this.marca = marca;
    this.responsableUbicacion = responsableUbicacion;
    this.disponibilidad = disponibilidad;
  }

  public Equipo(String modelo, String numeroSerie,
          String tipoEquipo, String marca, String responsableUbicacion) {
    this.modelo = modelo;
    this.numeroSerie = numeroSerie;
    this.tipoEquipo = tipoEquipo;
    this.marca = marca;
    this.responsableUbicacion = responsableUbicacion;
  }

  public Equipo(String identificador, String modelo, String numeroSerie,
          String tipoEquipo, String marca, String disponibilidad) {
    this.modelo = modelo;
    this.numeroSerie = numeroSerie;
    this.tipoEquipo = tipoEquipo;
    this.identificador = identificador;
    this.marca = marca;
    this.disponibilidad = disponibilidad;
  }

  public Equipo() {
  }

  public Equipo(String identificador) {
    this.identificador = identificador;
  }

  @Override
  public String getDisponibilidad() {
    return this.disponibilidad;
  }

  @Override
  public String getIdentificador() {
    return this.identificador;
  }

  @Override
  public String getModelo() {
    return this.modelo;
  }

  @Override
  public String getNumeroSerie() {
    return this.numeroSerie;
  }

  @Override
  public String getTipoEquipo() {
    return this.tipoEquipo;
  }

  @Override
  public String getMarca() {
    return this.marca;
  }

  @Override
  public String getResponsableUbicacion() {
    return this.responsableUbicacion;
  }

  /**
   * Recupera una lista conequipos disponibles.
   *
   * @return lista de Strings.
   * @throws SQLException Cuando no es posible recuperar el producto.
   */
  @Override
  public List<String> obtenerDisponibles() throws SQLException {
    return this.persistencia.obtenerDisponibles();
  }

  /**
   * Recupera los productos.
   *
   * @param identificador String
   * @return String.
   * @throws SQLException Cuando no es posible recuperar el producto.
   */
  @Override
  public String obtenerProducto(String identificador) throws SQLException {
    return this.persistencia.obtenerProducto(identificador);
  }

}
