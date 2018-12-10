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
public class Personal extends Usuario{
  
  private String nombre;
  private String correo;
  private String numeroTelefonico;
  private String puesto;

  public Personal(String nombre, String correo, String numeroTelefonico, String puesto,
          String numeroDePersonal, String contrasenia) {
    super(numeroDePersonal, contrasenia);
    this.nombre = nombre;
    this.correo = correo;
    this.numeroTelefonico = numeroTelefonico;
    this.puesto = puesto;
  }
  
 
  
}
