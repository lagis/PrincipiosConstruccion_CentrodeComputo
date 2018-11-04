/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrodecomputo.logica;

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
  private String modelo;
  private String numeroSerie;
  private String tipoEquipo;
  private int identificador;
  private String marca;
  private String responsableUbicacion;
  private boolean disponibilidad;

  /**
   * registra el préstamo de un equipo.
   * @param prestamo un préstamo nuevo registrado. 
   */
  
  @Override
  public void registrarPrestamoEquipo(Prestamo prestamo) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  /**
   * registra un nuevo dictamen de mantenimiento.
   * @param dictamen  nuevo dictamen registrado.
   */
  
  @Override
  public void registrarDictamen(DictamenMantenimiento dictamen) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  /**
   * recupera una lista de los mantenimientos realizados en ua fecha específica.
   * @param fehca fecha del dictamen.
   * @return lista de dictamenes registrados en la fecha ingresad.
   */
  
  @Override
  public List<DictamenMantenimiento> generarReporteMantenimiento(Date fehca) {
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
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
}
