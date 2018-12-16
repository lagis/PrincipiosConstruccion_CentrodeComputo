/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Contiene métodos para administrar un dictamen de mantenimiento.
 * @author PREDATOR 15 G9-78Q
 */

public interface InterfaceDictamenMantenimiento {
  
  public void registrarDictamenString(java.sql.Date fecha, String region,
      String dependencia, String tipoBorrado, String observaciones, String tipoDictamen,
          String descripcion, String idPersonal, String numeroInventario
    ) throws SQLException;
  
  public List<DictamenMantenimiento> generarReporteMantinimiento(Date fecha);
  
}
