/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.sql.SQLException;

/**
 *
 * @author marai
 */
public interface PersonalInterface {
  public boolean comprobarUsuario() throws SQLException ;
  public boolean comprobarContrasenia() throws SQLException ;
}
