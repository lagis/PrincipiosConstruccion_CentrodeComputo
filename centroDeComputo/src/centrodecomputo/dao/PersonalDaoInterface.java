package centrodecomputo.dao;

import centrodecomputo.logica.Personal;
import java.sql.SQLException;
import java.util.List;

public interface PersonalDaoInterface {
  
  public Personal obtenerPersonal(int numeroPersonal) throws SQLException;
  
  public List<Personal> obternerTodoPersonal() throws SQLException;
  
  public void registrarPersonal(Personal personal) throws SQLException;
  
  public void actualizarPersonal(Personal personal) throws SQLException;
 
  public String obteberPuesto(int numeroPersonal) throws SQLException;
}
