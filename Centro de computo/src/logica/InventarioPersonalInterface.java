/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.sql.SQLException;
import java.util.List;

/**
 * Contiene métodos para administrar el personal.
 *
 * @author marai
 */
public interface InventarioPersonalInterface {

  public boolean comprobarIdPersonal(int usuario) throws SQLException;

  public boolean comprobarCorreo(String correo) throws SQLException;

  public boolean comprobarTelefono(String telefono) throws SQLException;

  public boolean comprobarContrasenia(String contrasenia) throws SQLException;

  public Personal obtenerPersonal(int numeroDePersonal) throws SQLException;

  public boolean comprobarPersonal(int numeroDePersonal, String contrasenia);

  public String obtenerPuesto(int usuario);

  public List<Personal> verPersonal() throws SQLException;

  public void registrarNuevoPersonal(Personal personal) throws SQLException;

}
