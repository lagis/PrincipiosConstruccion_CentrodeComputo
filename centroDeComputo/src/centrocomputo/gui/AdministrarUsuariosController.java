/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrocomputo.gui;

import centrodecomputo.logica.JefeCentroComputo;
import centrodecomputo.logica.Personal;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author marai
 */
public class AdministrarUsuariosController implements Initializable {
  
  @FXML
  private TableView tabla;

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
   JefeCentroComputo jefe = new JefeCentroComputo();
   List<Personal> lista = jefe.verPersonal();
  }  
  
}
