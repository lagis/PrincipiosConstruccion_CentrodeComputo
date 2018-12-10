/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrodecomputo.dao;

import centrodecomputo.logica.Personal;
import centrodecomputo.persistencia.ConexioBasedeDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marai
 */
public class PersonalDao implements PersonalDaoInterface {

  private String query;
  private Connection conexion;
  private String puesto;

  public PersonalDao() {

  }

  @Override
  public Personal obtenerPersonal(int numeroPersonal) {
    Personal personal = null;
    query = "SELECT * FROM personal WHERE idpersonal = ? ";
    conexion = ConexioBasedeDatos.obtenerConexionBaseDatos();

    try {
      PreparedStatement statement = conexion.prepareStatement(query);
      statement.setInt(1, numeroPersonal);
      ResultSet result = statement.executeQuery();
      result.next();
      personal = new Personal(result.getInt("idpersonal"),
              result.getString("nombreTecnico"), result.getString("correo"),
              result.getString("numero_telefono"), result.getString("puesto"));
    } catch (SQLException ex) {
      Logger.getLogger(PersonalDao.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      ConexioBasedeDatos.cerrarConexion();
    }

    return personal;
  }

  @Override
  public List<Personal> obternerTodoPersonal() {
    ArrayList<Personal> listaPersonal = new ArrayList<>();
    Personal personal;
    query = "SELECT * FROM personal";
    conexion = ConexioBasedeDatos.obtenerConexionBaseDatos();

    try {
      PreparedStatement statement = conexion.prepareStatement(query);
      ResultSet result = statement.executeQuery();

      while (result.next()) {
        personal = new Personal(result.getInt("idpersonal"),
                result.getString("nombreTecnico"), result.getString("correo"),
                result.getString("numero_telefono"), result.getString("puesto"));
        listaPersonal.add(personal);
      }
    } catch (SQLException ex) {
      Logger.getLogger(PersonalDao.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      ConexioBasedeDatos.cerrarConexion();
    }
    
    return listaPersonal;
  }

  @Override
  public void registrarPersonal(Personal personal) {
    query = "INSERT INTO personal(idpersonal,nombreTecnico,correo,numero_telefono,puesto)"
            + "VALUES (?,?,?,?,?)";
   conexion = ConexioBasedeDatos.obtenerConexionBaseDatos();
   try{
     PreparedStatement statement = conexion.prepareStatement(query);
     statement.setInt(1, personal.getIdPersonal());
     statement.setString(2, personal.getNombre());
     statement.setString(3, personal.getCorreo());
     statement.setString(4, personal.getTelefono());
     statement.setString(5, personal.getPuesto());
   } catch(SQLException ex){
      Logger.getLogger(PersonalDao.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      ConexioBasedeDatos.cerrarConexion();
    }
  }

  @Override
  public void actualizarPersonal(Personal personal) {
   query = "UPDATE personal SET nombreTecnico = ?, correo = ?, numero_telefono = ?,"
           + "puesto = ?  WHERE idpersonal = ?";
   conexion = ConexioBasedeDatos.obtenerConexionBaseDatos();
   try{
     PreparedStatement statement = conexion.prepareStatement(query);
     statement.setString(1, personal.getNombre());
     statement.setString(2, personal.getCorreo());
     statement.setString(3, personal.getTelefono());
     statement.setString(4, personal.getPuesto());
     statement.setInt(5, personal.getIdPersonal());
   } catch(SQLException ex){
      Logger.getLogger(PersonalDao.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      ConexioBasedeDatos.cerrarConexion();
    }
  }

  @Override
  public String obteberPuesto(int numeroPersonal) {
    query = "SELECT puesto FROM personal WHERE idpersonal = ? ";
    conexion = ConexioBasedeDatos.obtenerConexionBaseDatos();
    
    try{
      PreparedStatement statement = conexion.prepareStatement(query);
      statement.setInt(1, numeroPersonal);
      ResultSet result=statement.executeQuery();
      result.next();
      puesto = result.getString("puesto");
    } catch(SQLException ex){
      Logger.getLogger(PersonalDao.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      ConexioBasedeDatos.cerrarConexion();
    }
    
    return puesto;
  }
  
}
