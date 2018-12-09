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
public class Tecnico extends Usuario{
  private String nombreTecnico; 
  
  public Tecnico(String nombre, String numeroDePersonal, String contrasenia){
    super(numeroDePersonal,contrasenia,"Tecnico");
    this.nombreTecnico = nombre;
  }
}
