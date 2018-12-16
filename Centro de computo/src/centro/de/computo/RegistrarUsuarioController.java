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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author marai
 */
public class RegistrarUsuarioController implements Initializable {

  @FXML
  private TextField tfIdPersonal;
  
  @FXML
  private TextField tfNombre;
  
  @FXML
  private TextField tfCorreo;
  
  @FXML
  private TextField tfTelefono;
  
  @FXML
  private ChoiceBox cbPuesto;
  
  @FXML
  private PasswordField pfContrasenia;
  
   @FXML
  private PasswordField pfConfirmacion;
   
   @FXML
  private Button bCancelar;
   
   @FXML
  private Button bRegistrar;
   
  
  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    this.cbPuesto.getItems().add("Jefe de centro de computo");
    this.cbPuesto.getItems().add("Tecnico");
  }  
  
}
