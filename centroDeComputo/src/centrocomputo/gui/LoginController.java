/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrocomputo.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author marai
 */
public class LoginController implements Initializable {
  
  @FXML
  private TextField usuarioTextField;
  
  @FXML
  private TextField contraseniaTextField;
  
  @FXML
  private void loginButtonAction(ActionEvent event){
    String usuario = usuarioTextField.getText();
    String contrasenia = contraseniaTextField.getText();
    
    
  }
  

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }  
  
}
