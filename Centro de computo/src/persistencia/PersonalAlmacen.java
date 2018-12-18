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
 * Contiene métodos para realizar la administración del personal mediante una
 * base de datos mysql.
 *
 * @author marai
 */
public class PersonalAlmacen extends GenericDao implements PersistenciaPersonal {

  private String query;
  private String dato;
  private Personal personal;

  /**
   * 
   * @param numeroDePersonal
   * @return
   * @throws SQLException 
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
   * 
   * @return
   * @throws SQLException 
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
   * 
   * @param personal
   * @throws SQLException 
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
   * 
   * @param personal
   * @throws SQLException 
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
   * 
   * @param personal
   * @throws SQLException 
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
   * 
   * @param numeroDePersonal
   * @return
   * @throws SQLException 
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
   * 
   * @param numeroDePersonal
   * @return
   * @throws SQLException 
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
   * 
   * @param numeroDePersonal
   * @return
   * @throws SQLException 
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
   * 
   * @param numeroDePersonal
   * @param contrasenia
   * @return 
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
   * 
   * @param personal
   * @throws SQLException 
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
   * 
   * @param correo
   * @return
   * @throws SQLException 
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
   * 
   * @param telefono
   * @return
   * @throws SQLException 
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
