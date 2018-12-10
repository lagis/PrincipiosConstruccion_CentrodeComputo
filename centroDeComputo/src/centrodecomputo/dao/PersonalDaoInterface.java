/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrodecomputo.dao;

import centrodecomputo.logica.Personal;
import java.util.List;

/**
 *
 * @author marai
 */
public interface PersonalDaoInterface {
  public Personal obtenerPersonal(int numeroPersonal);
  public List<Personal> obternerTodoPersonal();
  public void registrarPersonal(Personal personal);
  public void actualizarPersonal(Personal personal);
  public String obteberPuesto(int numeroPersonal);
}
