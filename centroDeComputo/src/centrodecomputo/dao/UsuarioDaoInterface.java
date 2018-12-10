/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrodecomputo.dao;

import centrodecomputo.logica.Usuario;

/**
 *
 * @author marai
 */
public interface UsuarioDaoInterface {
  public String obtenerContrasenia(String numeroDePersonal);
  public void registrarUsuario(Usuario usuario);
}
