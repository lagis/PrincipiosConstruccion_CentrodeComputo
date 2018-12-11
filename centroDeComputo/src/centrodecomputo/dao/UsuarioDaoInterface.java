package centrodecomputo.dao;

import centrodecomputo.logica.Usuario;
import java.sql.SQLException;

public interface UsuarioDaoInterface {
  
  public String obtenerContrasenia(String numeroDePersonal)  throws SQLException ;
  
  public void registrarUsuario(Usuario usuario)  throws SQLException ;
}
