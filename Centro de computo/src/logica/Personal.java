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
  public boolean comprobarUsuario() throws SQLException  {
    try {
      return almacen.obtenerUsuario(idPersonal).equals(Integer.toString(idPersonal));
    } catch (SQLException ex) {
      //TODO
    }
    return false;
  }

  @Override
  public boolean comprobarContrasenia() throws SQLException  {
    try {
      return almacen.obtenerContrasenia(idPersonal).equals(this.contrasenia);
    }  catch (SQLException ex) {
      //TODO
    }
    return false;
    
  }
 
  
}
