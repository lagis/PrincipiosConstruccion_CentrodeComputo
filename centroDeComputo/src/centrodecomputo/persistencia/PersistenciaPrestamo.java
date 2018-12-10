/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrodecomputo.persistencia;

import centrodecomputo.logica.Prestamo;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Giselle
 */
public interface PersistenciaPrestamo {
  List<Prestamo> obtenerTodosPrestamos(String nombreSolicitante, String matricula, Date fechaPrestamo, String horaPrestamo, Date FechaDevolucion, String horaDevolucion, String salon);
  boolean agregarPrestamo(String nombreSolicitante, String matricula, String fechaPrestamo, String horaPrestamo, String equipo,String salon);
}
