/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centro.de.computo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author PREDATOR 15 G9-78Q
 */
public class MenuController implements Initializable {

  @FXML
  private Label lUsuario;
  @FXML
  private Label lPuesto;
  

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    
    this.lUsuario.setText(User.getUsuario());
    this.lPuesto.setText(User.getPuesto());
    
  }  
  
}
