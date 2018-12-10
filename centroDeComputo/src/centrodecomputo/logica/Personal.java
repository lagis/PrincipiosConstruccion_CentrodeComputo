/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrodecomputo.logica;

/**
 *
 * @author marai
 */
public class Personal {
  
  private int idPersonal;
  private String nombre;
  private String correo;
  private String telefono;
  private String puesto;

  public Personal(int idPersonal, String nombre, String correo, String telefono, String puesto) {
    this.idPersonal = idPersonal;
    this.nombre = nombre;
    this.correo = correo;
    this.telefono = telefono;
    this.puesto = puesto;
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
  
}
