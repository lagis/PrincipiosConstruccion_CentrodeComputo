/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrodecomputo.dao;

import centrodecomputo.logica.Usuario;
import centrodecomputo.persistencia.ConexioBasedeDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marai
 */
public class UsuarioDao implements UsuarioDaoInterface{
  String password;
  private String query;
  private Connection conexion;
  
public UsuarioDao(){
  
}
  
  @Override
  public String obtenerContrasenia(String numeroDePersonal) {
   // String password = null;
    query = "SELECT contrasenia FROM usuario WHERE nombre_usuario = ? ";
    conexion = ConexioBasedeDatos.obtenerConexionBaseDatos();
    
    try{
      PreparedStatement statement = conexion.prepareStatement(query);
      statement.setString(1, numeroDePersonal);  
      ResultSet result=statement.executeQuery();
      result.next();
      password = result.getString("contrasenia");
    } catch(SQLException ex){
      Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      ConexioBasedeDatos.cerrarConexion();
    }
    
    return password;
  }

  @Override
  public void registrarUsuario(Usuario usuario) {
   query = "INSERT INTO usuario(contrasenia,nombre_usuario,personal_idpersonal) VALUES(?,?,?);";
   conexion = ConexioBasedeDatos.obtenerConexionBaseDatos();
   try{
     PreparedStatement statement = conexion.prepareStatement(query);
     statement.setString(1, usuario.getContrasenia());
     statement.setString(2, usuario.getNumeroDePersonal());
     statement.setInt(3, Integer.parseInt(usuario.getNumeroDePersonal()));
   } catch(SQLException ex){
      Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      ConexioBasedeDatos.cerrarConexion();
    }
  }
  
}
