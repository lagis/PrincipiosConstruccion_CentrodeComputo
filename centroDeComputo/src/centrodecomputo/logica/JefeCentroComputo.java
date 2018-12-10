/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package centrodecomputo.logica;

import centrodecomputo.dao.PersonalDao;
import centrodecomputo.dao.UsuarioDao;
import java.sql.SQLException;
import java.util.List;

/**
 * Operaciones del jefe del centro de computo.
 *
 * @author marai
 */
public class JefeCentroComputo {

  private final PersonalDao personalDao;

  /**
   * Constructor de la clase.
   */
  public JefeCentroComputo() {
    this.personalDao = new PersonalDao();
  }

  /**
   * Registra el ususario de un personal.
   *
   * @param nuevoUsuario objeto UIsuario
   * @throws SQLException si hubo excepción registrar al recuperar datos
   */
  public void registrarUsuario(Usuario nuevoUsuario) throws SQLException {
    UsuarioDao user = new UsuarioDao();
    try {
      user.registrarUsuario(nuevoUsuario);
    } catch (SQLException e) {
      throw new SQLException();
    }
  }

  /**
   * Registra un nuevo persona.
   *
   * @param personal objeto Personal
   * @throws SQLException si hubo excepción generada al registrar datos
   */
  public void registrarPersonal(Personal personal) throws SQLException {
    try {
      personalDao.registrarPersonal(personal);
    } catch (SQLException e) {
      throw new SQLException();
    }
  }

  /**
   * Obtiene la lista de todo el personal.
   *
   * @return List lista del personal
   * @throws SQLException si hubo excepción generada al recuperar datos
   */
  public List<Personal> verPersonal() throws SQLException {
    List<Personal> lista;
    try {
      lista = personalDao.obternerTodoPersonal();
    } catch (SQLException e) {
      throw new SQLException();
    }
    return lista;
  }

  /**
   * Edita obtiene el personal para mandarlo a la DAO.
   *
   * @param personal objeto Personal
   * @throws SQLException si hubo excepción generada al editar datos
   */
  public void editarUsuario(Personal personal) throws SQLException {
    try {
      personalDao.actualizarPersonal(personal);
    } catch (SQLException e) {
      throw new SQLException();
    }
  }
}
