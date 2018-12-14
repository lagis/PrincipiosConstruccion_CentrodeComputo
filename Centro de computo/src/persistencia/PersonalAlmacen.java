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
import java.util.List;
import logica.Personal;

/**
 *
 * @author marai
 */
public class PersonalAlmacen extends GenericDao implements PersistenciaPersonal{

  private String query;
  private Connection conexion;
  private String dato;
  private Personal personal;

  public PersonalAlmacen() {

  }
  
  @Override
  public Personal obtenerPersonal(int numeroDePersonal) throws SQLException {
 
    query = "SELECT * FROM personal p, usuario u WHERE u.personal_idpersonal = p.idpersonal ADN p.idpersonal = ? ";

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
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void registrarPersonal(Personal personal) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
  public String obtenerContrasenia(String contrasenia) throws SQLException {
    query = "SELECT contrasenia FROM centro_de_computo.usuario WHERE "
            + "contrasenia = ? ;";

    try {
      conexion = this.conectar();
      PreparedStatement statement = conexion.prepareStatement(query);
      statement.setString(1, contrasenia);
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
  public int obtenerUsuario(int numeroDePersonal) throws SQLException {
    
    query = "SELECT usuario FROM centro_de_computo.personal WHERE nombre_usuario = ? ";

      conexion = this.conectar();
      PreparedStatement statement = conexion.prepareStatement(query);
      statement.setInt(1, numeroDePersonal);
      ResultSet result = statement.executeQuery();
      result.next();
      int usuario = result.getInt("nombre_usuario");

      try {
        conexion.close();
      } catch (SQLException ex) {
        throw new SQLException();
      }
      

    return usuario;
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
  
}
