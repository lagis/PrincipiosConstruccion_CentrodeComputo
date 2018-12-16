/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centro.de.computo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

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
  
   public void abrirVentana(String ventana) {
    Stage stageEquipo = new Stage();
    Parent paneEquipo;
    try {
      paneEquipo = FXMLLoader.load(getClass().getResource(ventana));
      Scene sceneEquipo = new Scene(paneEquipo);
      stageEquipo.setScene(sceneEquipo);
      stageEquipo.show();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
  

  @FXML
  private void abrirInventarioHardware(ActionEvent event) {
    this.abrirVentana("InventarioHardware.fxml");
  }

  @FXML
  private void clickAdministrarPersonal(ActionEvent event) {
  }
  
  @FXML
  private void prestarEquipo(ActionEvent event) {
  }
  
}
