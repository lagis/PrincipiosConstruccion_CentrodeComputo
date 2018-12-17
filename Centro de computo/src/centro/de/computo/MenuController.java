/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package centro.de.computo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class.
 * @author PREDATOR 15 G9-78Q
 */

public class MenuController implements Initializable {

  @FXML
  private Button bttPersonal;
  
  @FXML
  private Button bttHardware;
  
  @FXML
  private Button bttEquipo;
  
  /**
   * Initializes the controller class.
   */
  
  @Override
  public void initialize(URL url, ResourceBundle rb) {

  }

  private void abrirVentana(String ventana) {
    Stage stage = new Stage();
    Parent parent;
    try {
      parent = FXMLLoader.load(getClass().getResource(ventana));
      Scene scene = new Scene(parent);
      stage.setScene(scene);
      stage.show();
    } catch (IOException ex) {
      JOptionPane.showMessageDialog(null, 
          "El sistema no está disponible por el momento, inténtelo más tarde");
      Logger.getLogger(RegistrarUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  @FXML
  private void abrirInventarioHardware(ActionEvent event) {
    this.abrirVentana("InventarioHardware.fxml");
    this.cerrarMenu(this.bttHardware);
  }

  @FXML
  private void clickAdministrarPersonal(ActionEvent event) {
    this.abrirVentana("AdministrarUsuarios.fxml");
    this.cerrarMenu(this.bttPersonal);
  }

  @FXML
  private void prestarEquipo(ActionEvent event) {
    
  }

  private void cerrarMenu(Button bt) {
    Stage stage = (Stage) bt.getScene().getWindow();
    stage.close();
  }
  
}
