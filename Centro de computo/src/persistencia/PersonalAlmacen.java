/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
  private Connection conexion;
  private String dato;
  private Personal personal;
  private List<Personal> listaPersonal;

  public PersonalAlmacen() {

  }

  @Override
  public Personal obtenerPersonal(int numeroDePersonal) throws SQLException {

    query = "SELECT * FROM centro_de_computo.personal p, centro_de_computo.usuario u"
            + " WHERE p.idpersonal = u.personal_idpersonal AND p.idpersonal = ?";

    try {
      conexion = this.conectar();
      PreparedStatement statement = conexion.prepareStatement(query);
      statement.setInt(1, numeroDePersonal);
      ResultSet result = statement.executeQuery();
      result.next();
      personal = new Personal(result.getInt("idpersonal"),
              result.getString("nombreTecnico"), result.getString("correo"),
              result.getString("numero_telefono"), result.getString("puesto"),
              result.getString("contrasenia"));
    } catch (SQLException ex) {
      throw new SQLException();
    } finally {
      try {
        conexion.close();
      } catch (SQLException ex) {
        throw new SQLException();
      }
    }

    return personal;
  }

  @Override
  public List<Personal> obternerTodoPersonal() throws SQLException {
    listaPersonal = new ArrayList<>();
    query = "SELECT * FROM centro_de_computo.personal p, centro_de_computo.usuario u"
            + " WHERE p.idpersonal = u.personal_idpersonal";

    try {
      conexion = this.conectar();
      PreparedStatement statement = conexion.prepareStatement(query);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        personal = new Personal(result.getInt("idpersonal"),
                result.getString("nombreTecnico"), result.getString("correo"),
                result.getString("numero_telefono"), result.getString("puesto"),
                result.getString("contrasenia"));
        listaPersonal.add(personal);
      }
    } catch (SQLException ex) {
      throw ex;
    } finally {
      try {
        conexion.close();
      } catch (SQLException ex) {
        throw new SQLException();
      }
    }
    return listaPersonal;
  }

  @Override
  public void registrarPersonal(Personal personal) throws SQLException {
    query = "INSERT INTO centro_de_computo.personal(idpersonal,nombreTecnico,correo,"
            + "numero_telefono,puesto) VALUES (?,?,?,?,?)";

    try {
      conexion = this.conectar();
      PreparedStatement statement = conexion.prepareStatement(query);
      statement.setInt(1, personal.getIdPersonal());
      statement.setString(2, personal.getNombre());
      statement.setString(3, personal.getCorreo());
      statement.setString(4, personal.getTelefono());
      statement.setString(5, personal.getPuesto());
    } catch (SQLException ex) {
      throw ex;
    } finally {
      try {
        conexion.close();
      } catch (SQLException ex) {
        throw ex;
      }
    }
  }

  @Override
  public void actualizarPersonal(Personal personal) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public String obteberPuesto(int numeroDePersonal) throws SQLException {

    query = "SELECT puesto FROM centro_de_computo.personal WHERE idpersonal = ? ";

    try {
      conexion = this.conectar();
      PreparedStatement statement = conexion.prepareStatement(query);
      statement.setInt(1, numeroDePersonal);
      ResultSet result = statement.executeQuery();
      result.next();
      dato = result.getString("puesto");
    } catch (SQLException ex) {
      throw new SQLException();
    } finally {
      try {
        conexion.close();
      } catch (SQLException ex) {
        throw new SQLException();
      }
    }

    return dato;
  }

  @Override
  public String obtenerContrasenia(int numeroDePersonal) throws SQLException {
    query = "SELECT contrasenia FROM centro_de_computo.usuario WHERE "
            + "nombre_usuario = ? ;";

    try {
      conexion = this.conectar();
      PreparedStatement statement = conexion.prepareStatement(query);
      statement.setInt(1, numeroDePersonal);
      ResultSet result = statement.executeQuery();
      result.next();
      dato = result.getString("contrasenia");
    } catch (SQLException ex) {
      throw new SQLException();
    } finally {
      try {
        conexion.close();
      } catch (SQLException ex) {
        throw new SQLException();
      }
    }

    return dato;
  }

  @Override
  public boolean buscarUsuario(int numeroDePersonal) throws SQLException {
    query = "SELECT usuario FROM centro_de_computo.personal WHERE nombre_usuario = ? ";

    try {
      conexion = this.conectar();
      PreparedStatement statement = conexion.prepareStatement(query);
      statement.setInt(1, numeroDePersonal);
      ResultSet result = statement.executeQuery();
      if (result.next()) {
        return true;
      } else {
        return false;
      }
    } catch (SQLException ex) {
      return false;
    } finally {
      try {
        conexion.close();
      } catch (SQLException ex) {
        return false;
      }
    }
  }

  @Override
  public boolean buscarPersonal(int numeroDePersonal, String contrasenia) {
    query = "SELECT * FROM centro_de_computo.usuario WHERE "
            + "contrasenia = ? && nombre_usuario = ? ;";

    try {
      conexion = this.conectar();
      PreparedStatement statement = conexion.prepareStatement(query);
      statement.setString(1, contrasenia);
      statement.setInt(2, numeroDePersonal);
      ResultSet result = statement.executeQuery();
      if (result.next()) {
        return true;
      } else {
        return false;
      }
    } catch (SQLException ex) {
      return false;
    } finally {
      try {
        conexion.close();
      } catch (SQLException ex) {
        return false;
      }
    }
  }

  @Override
  public void registrarContrasenia(Personal personal) throws SQLException {
    query = "INSERT INTO centro_de_computo.usuario(contrasenia,nombre_usuario,"
            + "personal_idpersonal) VALUES(?,?,?);";
    try {
      conexion = this.conectar();
      PreparedStatement statement = conexion.prepareStatement(query);
      statement.setString(1, personal.getContrasenia());
      statement.setInt(2, personal.getIdPersonal());
      statement.setInt(3, personal.getIdPersonal());
    } catch (SQLException ex) {
      throw new SQLException();
    } finally {
      try {
        conexion.close();
      } catch (SQLException ex) {
        throw ex;
      }
    }
  }

}
