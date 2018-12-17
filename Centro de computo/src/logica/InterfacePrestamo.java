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
          java.sql.Date fechaPrestamo, java.sql.Time horaPrestamo,
          String equipo, String salon)throws SQLException;
  
  public void registrarDevolucion(int numeroPrestamo,java.sql.Date FechaDevolucion,
          java.sql.Time horaDevolucion,String equipo)throws SQLException;

  public List<DictamenMantenimiento>obtenerTodosLosPrestamos()
          throws SQLException;

  public List<DictamenMantenimiento>obtenerPrestados()throws SQLException;
}
