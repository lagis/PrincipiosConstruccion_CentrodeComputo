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
  @FXML
  private Button bttReporte;
  
  /**
   * Initializes the controller class.
   */
  
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    
    if (User.getPuesto().equalsIgnoreCase("tecnico")) {
      this.abrirOpcionesTecnico();
    }

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
    }
  }

  @FXML
  private void abrirInventarioHardware(ActionEvent event) {
    this.abrirVentana("InventarioHardware.fxml");
  }

  @FXML
  private void clickAdministrarPersonal(ActionEvent event) {
    this.abrirVentana("AdministrarUsuarios.fxml");
    this.cerrarMenu(this.bttPersonal);
  }

  @FXML
  private void prestarEquipo(ActionEvent event) {
    this.abrirVentana("AdministrarPrestamos.fxml");
  }
  
  @FXML
  private void generarReporte(ActionEvent event) {
    this.abrirVentana("VentanaReporte.fxml");
  }

  private void cerrarMenu(Button bt) {
    Stage stage = (Stage) bt.getScene().getWindow();
    stage.close();
  }
  
  private void abrirOpcionesTecnico(){
    this.bttPersonal.setVisible(false);
    this.bttEquipo.setVisible(false);
    
    
  }
  
}
