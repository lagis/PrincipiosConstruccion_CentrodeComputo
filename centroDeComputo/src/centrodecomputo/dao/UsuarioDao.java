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
  
  private String query;
  private Connection conexion;
  
public UsuarioDao(){
  
}
  


  @Override
  public Usuario obtenerUsuario(String numeroDePersonal) {
    Usuario usuario = null;
    query = "SELECT * FROM usuario WHERE personal.numeroDePersonal = ? ";
    conexion = ConexioBasedeDatos.obtenerConexionBaseDatos();
    
    try{
      PreparedStatement statement = conexion.prepareStatement(query);
      statement.setString(1, numeroDePersonal);  
      ResultSet result=statement.executeQuery();
      usuario = new Usuario(result.getString("numeroDePersonal"), 
              result.getString("contrasenia"));
    } catch(SQLException ex){
     Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      ConexioBasedeDatos.cerrarConexion();
    }
    
    return usuario;
  }

  @Override
  public void atualizarUsuario(Usuario usuario) {
   query = "UPDATE usuario SET contrasenia = ?  WHERE idpersonal = ?";
   conexion = ConexioBasedeDatos.obtenerConexionBaseDatos();
   try{
     PreparedStatement statement = conexion.prepareStatement(query);
     statement.setString(1, usuario.getContrasenia());
     statement.setString(2, usuario.getNumeroDePersonal());
   } catch(SQLException ex){
      Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      ConexioBasedeDatos.cerrarConexion();
    }
  }

  @Override
  public void registrarUsuario(Usuario usuario) {
   query = "INSERT INTO usuario( personal_idpersonal,contrasenia) VALUES(?,?);";
   conexion = ConexioBasedeDatos.obtenerConexionBaseDatos();
   try{
     PreparedStatement statement = conexion.prepareStatement(query);
     statement.setString(1, usuario.getNumeroDePersonal());
     statement.setString(2, usuario.getContrasenia());
   } catch(SQLException ex){
      Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      ConexioBasedeDatos.cerrarConexion();
    }
  }
  
}
