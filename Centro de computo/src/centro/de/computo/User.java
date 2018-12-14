/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centro.de.computo;

/**
 *
 * @author PREDATOR 15 G9-78Q
 */
public class User {
  
  private static String usuario;
  private static String puesto;
  
  public static void enviarUsuario(String usuario){
    User.usuario = usuario;
  }
  
  public static void enviarPuesto(String puesto){
    User.puesto = puesto;
  }
  
  public static String getUsuario(){
    return User.usuario;
  }
  
  public static String getPuesto(){
    return User.puesto;
  }
  
  
}
