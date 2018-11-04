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
  private Date fehca;
  private String nombrePrestamo;
  private Date devolucion;
  
  public void registrarDevolucion(Date devolucion){
    this.devolucion = devolucion;
  }    
}
