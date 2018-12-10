/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrodecomputo.logica;

import centrodecomputo.dao.PersonalDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marai
 */
public class JefeCentroComputo {
  public PersonalDao personalDao;

  public JefeCentroComputo() {
    this.personalDao = new PersonalDao();
  }
  
  public void registrarUsuario(Usuario nuevoUsuario){
    
  }
  
  public void registrarPersonal(Personal nuevoOersonal){
    
  }
  
  public List<Personal> verPersonal(){
    List<Personal> lista = personalDao.obternerTodoPersonal();
    return lista;
  }
  
  public void editarUsuario(Usuario usuario){
    
  }
}
