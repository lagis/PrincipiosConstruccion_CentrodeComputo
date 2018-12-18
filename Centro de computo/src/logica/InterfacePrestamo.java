/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Giselle
 */
public interface InterfacePrestamo {

  public void registrarPrestamo(String nombreSolicitante, String matricula,
          String fechaPrestamo, String horaPrestamo,
          String equipo, String salon)throws SQLException;
  
  public void registrarDevolucion(int numeroPrestamo,
          String FechaDevolucion,String horaDevolucion,
          String equipo)throws SQLException;

  public List<Prestamo>obtenerTodosLosPrestamos()
          throws SQLException;

  public List<Prestamo>obtenerPrestados()throws SQLException;
  
}
