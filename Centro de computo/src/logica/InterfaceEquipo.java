/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.sql.SQLException;
import java.util.List;

/**
 * Contiene métodos para administrar un equipo.
 * @author ferc
 */

public interface InterfaceEquipo {
  
  public String getDisponibilidad();
  
  public String getIdentificador();
  
  public String getModelo();
  
  public String getNumeroSerie();
  
  public String getTipoEquipo();
  
  public String getMarca();
  
  public String getResponsableUbicacion();
  
  public List<String> obtenerDisponibles()throws SQLException;
  
  public String obtenerProducto(String identificador)throws SQLException;
  
}
