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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marai
 */
public class PersonalDao implements PersonalDaoInterface{

  private String query;
  private Connection conexion;
  
  @Override
  public Personal obtenerPersoanal(String numeroPersonal) {
    
  }

  @Override
  public List<Personal> obternerTodoPersonal() {
    
  }

  @Override
  public void registrarPersonal(Personal personal) {
    
  }

  @Override
  public void actualizarPersonal(Personal personal) {
   query = "UPDATE usuario SET contrasenia = ?  WHERE personal_idpersonal = ?";
   conexion = ConexioBasedeDatos.obtenerConexionBaseDatos();
   try{
     PreparedStatement statement = conexion.prepareStatement(query);
     statement.setString(1, personal.getContrasenia());
     statement.setString(2, personal.getNumeroDePersonal());
   } catch(SQLException ex){
      Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      ConexioBasedeDatos.cerrarConexion();
    }
  }

  @Override
  public String obteberPuesto(String numeroPersonal) {
    
  }
  
}
