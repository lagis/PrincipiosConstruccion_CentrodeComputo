/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.PersistenciaPersonal;
import persistencia.PersonalAlmacen;

/**
 *
 * @author marai
 */
public class Personal implements PersonalInterface{
  
  private int idPersonal;
  private String nombre;
  private String correo;
  private String telefono;
  private String puesto;
  private String contrasenia;
  private PersistenciaPersonal  almacen = new PersonalAlmacen();
  
  public Personal(){
    
  }
  
  public Personal(int idPersonal, String nombre, String correo, String telefono, String puesto, String contrasenia) {
    this.idPersonal = idPersonal;
    this.nombre = nombre;
    this.correo = correo;
    this.telefono = telefono;
    this.puesto = puesto;
    this.contrasenia = contrasenia;
  }
  
  public Personal(String idPersonal, String contrasenia){
    this.idPersonal = Integer.parseInt(idPersonal);
    this.contrasenia = contrasenia;
    }

  public int getIdPersonal() {
    return idPersonal;
  }

  public String getNombre() {
    return nombre;
  }

  public String getCorreo() {
    return correo;
  }

  public String getTelefono() {
    return telefono;
  }

  public String getPuesto() {
    return puesto;
  }

  public String getContrasenia() {
    return contrasenia;
  }

  @Override
  public boolean comprobarUsuario(int usuario) throws SQLException  {
    this.idPersonal = almacen.obtenerUsuario(usuario);
    if (this.idPersonal == 0) {
      return false;
    } else {
      return true;
    }
    
  }

  @Override
  public boolean comprobarContrasenia(String contrasenia) throws SQLException  {
    this.contrasenia = almacen.obtenerContrasenia(contrasenia);
    return !this.contrasenia.isEmpty();
  }

  @Override
  public Personal obtenerPersonal() throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean comprobarPersonal(int numeroDePersonal, String contrasenia) {
    return this.almacen.buscarPersonal(numeroDePersonal, contrasenia);
  }

  @Override
  public String obtenerPuesto(int usuario) {
    try {
      this.puesto = this.almacen.obteberPuesto(usuario);
    } catch (SQLException ex) {
      
    }
    return this.puesto;
  }
  
  

 
  
}
