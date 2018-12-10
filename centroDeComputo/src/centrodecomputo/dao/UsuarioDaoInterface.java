/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrodecomputo.dao;

import centrodecomputo.logica.Usuario;
import java.util.List;

/**
 *
 * @author marai
 */
public interface UsuarioDaoInterface {
  public Usuario obtenerUsuario(String numeroDePersonal);
  public void atualizarUsuario(Usuario usuario);
  public void registrarUsuario(Usuario usuario);
}
