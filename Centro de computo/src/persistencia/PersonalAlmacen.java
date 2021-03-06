
package persistencia;

import conexion.GenericDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import logica.Personal;

/**
 * Contiene métodos para realizar la administración del personal mediante una base de datos mysql.
 * @author marai
 */

public class PersonalAlmacen extends GenericDao implements PersistenciaPersonal {

  private String query;
  private String dato;
  private Personal personal;

  /**
   * Permite cuperar un personal.
   * @param numeroDePersonal int id del personal.
   * @return objeto de tipo Personal
   * @throws SQLException la arroja sino puede realizar una conexión con la base de datos.
   */
  
  @Override
  public Personal obtenerPersonal(int numeroDePersonal) throws SQLException {

    Connection conexion = this.conectar();
    query = "SELECT * FROM centro_de_computo.personal p, centro_de_computo.usuario u"
            + " WHERE p.idpersonal = u.personal_idpersonal AND p.idpersonal = ? ;";
    try (PreparedStatement stp = conexion.prepareStatement(query)) {
      stp.setInt(1, numeroDePersonal);
      ResultSet result = this.ejecutarQuery(stp);
      result.next();
      personal = new Personal(result.getInt("idpersonal"),
              result.getString("nombreTecnico"), result.getString("correo"),
              result.getString("numero_telefono"), result.getString("puesto"),
              result.getString("contrasenia"));
    } catch (SQLException ex) {
      throw new SQLException();
    } finally {
      conexion.close();
    }

    return personal;

  }

  /**
   * Recupera una lista de personal registrado en la base de datos.
   * @return una lista de personal
   * @throws SQLException Arroja esta excepción sino puede realizar una conexión con la DataBase.
   */
  
  @Override
  public List<Personal> obternerTodoPersonal() throws SQLException {
    List<Personal> listaPersonal = new ArrayList<>();
    query = "SELECT * FROM centro_de_computo.personal p, centro_de_computo.usuario u"
            + " WHERE p.idpersonal = u.personal_idpersonal;";
    Connection conexion = this.conectar();

    try (PreparedStatement stp = conexion.prepareStatement(query)) {

      ResultSet result = this.ejecutarQuery(stp);

      while (result.next()) {
        personal = new Personal(result.getInt("idpersonal"),
                result.getString("nombreTecnico"), result.getString("correo"),
                result.getString("numero_telefono"), result.getString("puesto"),
                result.getString("contrasenia"));
        listaPersonal.add(personal);
      }
    } catch (SQLException ex) {
      throw new SQLException();
    } finally {
      conexion.close();
    }
    return listaPersonal;
  }

  /**
   * Registra un nuevo personal en el sistema.
   * @param personal objeto de tipo Personal.
   * @throws SQLException arroja una excepción si no puede realizar una conexión con la DataBase.
   */
  
  @Override
  public void registrarPersonal(Personal personal) throws SQLException {
    query = "INSERT INTO centro_de_computo.personal(idpersonal,nombreTecnico,correo,"
            + "numero_telefono,puesto) VALUES (?,?,?,?,?);";

    Connection conexion = this.conectar();
    try (PreparedStatement stp = conexion.prepareStatement(query)) {
      stp.setInt(1, personal.getIdPersonal());
      stp.setString(2, personal.getNombre());
      stp.setString(3, personal.getCorreo());
      stp.setString(4, personal.getTelefono());
      stp.setString(5, personal.getPuesto());
      stp.executeUpdate();
      conexion.commit();

    } catch (SQLException ex) {
      throw new SQLException();
    } finally {
      conexion.close();
    }
  }

  /**
   * Actualiza los datos de un personal ya registrado.
   * @param personal Persona.
   * @throws SQLException arroja esta excepción sino puede realizar una conexión con la DataBase. 
   */
  
  @Override
  public void actualizarPersonal(Personal personal) throws SQLException {
    query = "UPDATE centro_de_computo.personal SET nombreTecnico = ?, correo = ?,"
            + " numero_telefono = ?, puesto = ? WHERE idpersonal = ? ;";

    Connection conexion = this.conectar();
    try (PreparedStatement stp = conexion.prepareStatement(query)) {
      stp.setString(1, personal.getNombre());
      stp.setString(2, personal.getCorreo());
      stp.setString(3, personal.getTelefono());
      stp.setString(4, personal.getPuesto());
      stp.setInt(5, personal.getIdPersonal());
      stp.executeUpdate();
      conexion.commit();
    } catch (SQLException ex) {
      throw new SQLException();
    } finally {
      conexion.close();
    }
  }

  /**
   * Actualiza la contraseña de un usuario ya registrado.
   * @param personal Personal.
   * @throws SQLException arroja esta excepción sino puede realizar una conexión con la DataBase.
   */
  
  @Override
  public void actualizarContrasenia(Personal personal) throws SQLException {
    query = "UPDATE centro_de_computo.usuario SET contrasenia = ? WHERE nombre_usuario = ? ;";

    Connection conexion = this.conectar();
    try (PreparedStatement stp = conexion.prepareStatement(query)) {
      stp.setString(1, personal.getContrasenia());
      stp.setInt(2, personal.getIdPersonal());
      stp.executeUpdate();
      conexion.commit();
    } catch (SQLException ex) {
      throw new SQLException();
    } finally {
      conexion.close();
    }
  }

  /**
   * Obtiene el puesto correspondiente al personal.
   * @param numeroDePersonal int.
   * @return String
   * @throws SQLException arroja esta excepción sino puede realizar una conexión con laDataBase.
   */
  
  @Override
  public String obteberPuesto(int numeroDePersonal) throws SQLException {

    query = "SELECT puesto FROM centro_de_computo.personal WHERE idpersonal = ?; ";

    Connection conexion = this.conectar();

    try (PreparedStatement stp = conexion.prepareStatement(query)) {

      stp.setInt(1, numeroDePersonal);

      ResultSet result = this.ejecutarQuery(stp);

      result.next();
      dato = result.getString("puesto");
    } catch (SQLException ex) {
      throw new SQLException();
    } finally {
      conexion.close();
    }

    return dato;
  }

  /**
   * Recupera la contraseña de un usuario.
   * @param numeroDePersonal int
   * @return String
   * @throws SQLException arroja esta excepción sino puede realizar una conexión con la DataBase.
   */
  
  @Override
  public String obtenerContrasenia(int numeroDePersonal) throws SQLException {
    query = "SELECT contrasenia FROM centro_de_computo.usuario WHERE "
            + "nombre_usuario = ? ;";

    Connection conexion = this.conectar();

    try (PreparedStatement stp = conexion.prepareStatement(query)) {

      stp.setInt(1, numeroDePersonal);
      ResultSet result = this.ejecutarQuery(stp);
      result.next();
      dato = result.getString("contrasenia");
    } catch (SQLException ex) {
      throw new SQLException();
    } finally {
      conexion.close();
    }

    return dato;
  }

  /**
   * Busca un usuario en la base de datos.
   * @param numeroDePersonal número correspondiente al usuario.
   * @return true si encuentra una coincidencia.
   * @throws SQLException sino puede realizar la conexión con la bDataBase.
   */
  
  @Override
  public boolean buscarUsuario(int numeroDePersonal) throws SQLException {
    query = "SELECT usuario FROM centro_de_computo.personal WHERE nombre_usuario = ?; ";

    Connection conexion = this.conectar();

    try (PreparedStatement stp = conexion.prepareStatement(query)) {

      stp.setInt(1, numeroDePersonal);
      ResultSet result = this.ejecutarQuery(stp);
      boolean existeUsuario = false;
      if (result.next()) {
        existeUsuario = true;
      }
      return existeUsuario;

    } catch (SQLException ex) {
      return false;
    } finally {
      conexion.close();
    }
  }

  /**
   * Busca a un usuario con esa contraseña y usuario.
   * @param numeroDePersonal int
   * @param contrasenia String
   * @return true si encuenta una coincidencia.
   */
  
  @Override
  public boolean buscarPersonal(int numeroDePersonal, String contrasenia) {
    query = "SELECT * FROM centro_de_computo.usuario WHERE "
            + "contrasenia = ? && nombre_usuario = ? ;";

    try {
      Connection conexion = this.conectar();

      try (PreparedStatement stp = conexion.prepareStatement(query)) {

        stp.setString(1, contrasenia);
        stp.setInt(2, numeroDePersonal);
        ResultSet result = this.ejecutarQuery(stp);
        boolean retorno = false;
        if (result.next()) {
          retorno = true;
        }
        return retorno;

      } catch (SQLException ex) {
        return false;
      } finally {
        conexion.close();
      }
    } catch (SQLException ex) {
      return false;
    }
  }

  /**
   * Registra una contraseña a un nuevo personal.
   * @param personal de tipo personal.
   * @throws SQLException arroja esta excepción sino puede realizar una conexión con la DataBase.
   */
  
  @Override
  public void registrarContrasenia(Personal personal) throws SQLException {
    query = "INSERT INTO centro_de_computo.usuario(contrasenia,nombre_usuario,"
            + "personal_idpersonal) VALUES(?,?,?);";
    Connection conexion = this.conectar();

    try (PreparedStatement stp = conexion.prepareStatement(query)) {

      stp.setString(1, personal.getContrasenia());
      stp.setInt(2, personal.getIdPersonal());
      stp.setInt(3, personal.getIdPersonal());
      stp.executeUpdate();
      conexion.commit();
    } catch (SQLException ex) {
      throw new SQLException();
    } finally {
      conexion.close();
    }
  }

  /**
   * Busca si ya se ha registrado el correo en la base de datos.
   * @param correo String.
   * @return true si encuentra una coincidencia.
   * @throws SQLException arroja esta excepción sino puede realizar una conexión con la DataBase.
   */
  
  @Override
  public boolean buscarCorreo(String correo) throws SQLException {
    query = "SELECT * FROM centro_de_computo.personal WHERE correo = ?; ";

    Connection conexion = this.conectar();

    try (PreparedStatement stp = conexion.prepareStatement(query)) {

      stp.setString(1, correo);
      ResultSet result = this.ejecutarQuery(stp);
      boolean existeCorreo = false;
      if (result.next()) {
        existeCorreo = true;
      }
      return existeCorreo;

    } catch (SQLException ex) {
      return false;
    } finally {
      conexion.close();
    }
  }

  /**
   * Busca si ya se ha registrado el teléfono en la base de datos.
   * @param telefono String.
   * @return true si encuentra una coincidencia.
   * @throws SQLException arroja esta excepción sino puede realizar una conexión con la DataBase.
   */
  
  @Override
  public boolean buscarTelefono(String telefono) throws SQLException {
    query = "SELECT * FROM centro_de_computo.personal WHERE numero_telefono = ?; ";

    Connection conexion = this.conectar();

    try (PreparedStatement stp = conexion.prepareStatement(query)) {

      stp.setString(1, telefono);
      ResultSet result = this.ejecutarQuery(stp);
      boolean existeTelefono = false;
      if (result.next()) {
        existeTelefono = true;
      }
      return existeTelefono;

    } catch (SQLException ex) {
      return false;
    } finally {
      conexion.close();
    }
  }

  private ResultSet ejecutarQuery(PreparedStatement stp) throws SQLException {
    try {
      return stp.executeQuery();
    } catch (SQLException e) {
      throw new SQLException();
    }
  }

}
