/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrocomputo.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
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
  private ComboBox puestoBox;
  
  private void registrarButtonAction(ActionEvent event) throws IOException{
    
  }
  
  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    
  }  
  
}
