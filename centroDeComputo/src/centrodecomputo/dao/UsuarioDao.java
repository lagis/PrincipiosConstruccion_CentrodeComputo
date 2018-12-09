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
import java.util.ArrayList;
import java.util.List;
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
  public String obtenerPuesto(String numeroDePersonal) {
    String puesto = null;
    query = "SELECT puesto FROM usuario WHERE numeroDePersonal = ?";
    conexion = ConexioBasedeDatos.obtenerConexionBaseDatos();
    
    try{
      PreparedStatement statement = conexion.prepareStatement(query);
      statement.setString(1, numeroDePersonal);  
      ResultSet result=statement.executeQuery();
      puesto = result.getString("puesto");
    } catch(SQLException ex){
      Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      ConexioBasedeDatos.cerrarConexion();
    }
    
    return puesto;
  }

  @Override
  public Usuario obtenerUsuario(String numeroDePersonal) {
    Usuario usuario = null;
    query = "SELECT * FROM usuario WHERE numeroDePersonal = ?";
    conexion = ConexioBasedeDatos.obtenerConexionBaseDatos();
    
    try{
      PreparedStatement statement = conexion.prepareStatement(query);
      statement.setString(1, numeroDePersonal);  
      ResultSet result=statement.executeQuery();
      usuario = new Usuario(result.getString("numeroDePersonal"), 
              result.getString("contrasenia"),result.getString("puesto"));
    } catch(SQLException ex){
     Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      ConexioBasedeDatos.cerrarConexion();
    }
    
    return usuario;
  }

  @Override
  public void atualizarUsuario(Usuario usuario) {
   query = "UPDATE usuario SET contrasenia = ? , puesto = ? WHERE numeroDePersonal = ?";
   conexion = ConexioBasedeDatos.obtenerConexionBaseDatos();
   try{
     PreparedStatement statement = conexion.prepareStatement(query);
     statement.setString(1, usuario.getContrasenia());
     statement.setString(2, usuario.getPuesto());
     statement.setString(3, usuario.getNumeroDePersonal());
   } catch(SQLException ex){
      Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      ConexioBasedeDatos.cerrarConexion();
    }
  }

  @Override
  public void registrarUsuario(Usuario usuario) {
    query = "INSERT INTO usuario( numeroDePersonal,contrasenia,puesto) VALUES(?,?,?);";
   conexion = ConexioBasedeDatos.obtenerConexionBaseDatos();
   try{
     PreparedStatement statement = conexion.prepareStatement(query);
     statement.setString(1, usuario.getNumeroDePersonal());
     statement.setString(2, usuario.getContrasenia());
     statement.setString(3, usuario.getPuesto());
   } catch(SQLException ex){
      Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      ConexioBasedeDatos.cerrarConexion();
    }
  }

  @Override
  public List<Usuario> obtenerTodosUsuarios() {
    ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    Usuario usuario;
    query = "SELECT * FROM usuario";
    conexion = ConexioBasedeDatos.obtenerConexionBaseDatos();
    
    try{
      PreparedStatement statement = conexion.prepareStatement(query);
      ResultSet result=statement.executeQuery();
      
      while(result.next()){
        usuario = new Usuario(result.getString("numeroDePersonal"), 
              result.getString("contrasenia"),result.getString("puesto"));
        listaUsuarios.add(usuario);
      }
    } catch(SQLException ex){
      Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      ConexioBasedeDatos.cerrarConexion();
    }
    
    return listaUsuarios;
  }
  
}
