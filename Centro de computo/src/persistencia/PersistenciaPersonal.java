/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.SQLException;
import java.util.List;
import logica.Personal;

/**
 * Contiene métodos para realizar la administración del personal.
 *
 * @author marai
 */
public interface PersistenciaPersonal {

  public Personal obtenerPersonal(int numeroDePersonal) throws SQLException;

  public List<Personal> obternerTodoPersonal() throws SQLException;

  public void registrarPersonal(Personal personal) throws SQLException;

  public void actualizarPersonal(Personal personal) throws SQLException;

  public void registrarContrasenia(Personal personal) throws SQLException;

  public String obteberPuesto(int numeroDePersonal) throws SQLException;

  public String obtenerContrasenia(int numeroDePersonal) throws SQLException;

  public boolean buscarUsuario(int numeroDePersonal) throws SQLException;

  public boolean buscarPersonal(int numeroDePersonal, String contrasenia);

  public boolean buscarCorreo(String correo) throws SQLException;

  public boolean buscarTelefono(String telefono) throws SQLException;

}
