/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package centro.de.computo;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import logica.InterfaceInventarioHardware;
import logica.InventarioHardware;

/**
 * FXML Controller class.
 * @author PREDATOR 15 G9-78Q
 */

public class CambiarResponsableController implements Initializable {

  @FXML
  private ChoiceBox cbResponsable;
  @FXML
  private Label labelNumeroSerie;
  @FXML
  private Label labelModelo;
  @FXML
  private Button bttGuardar;
  
  private static String modelo;
  private static String numeroSerie;
  private final InterfaceInventarioHardware inventario = new InventarioHardware();

  /**
   * Initializes the controller class.
   */
  
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    this.labelModelo.setText(CambiarResponsableController.modelo);
    this.labelNumeroSerie.setText(CambiarResponsableController.numeroSerie);
    
    this.cbResponsable.getItems().add("CC1");
    this.cbResponsable.getItems().add("CC2");
    this.cbResponsable.getItems().add("CC3");
    this.cbResponsable.getItems().add("CC4");
    this.cbResponsable.getItems().add("Bodega");
    this.cbResponsable.getItems().add("Fuera de servicio");
    
    
  }
  
  public static void mandarModeloNumeroSerie(
      String modelo, String numeroSerie) {
    CambiarResponsableController.modelo = modelo;
    CambiarResponsableController.numeroSerie = numeroSerie;
  }

  @FXML
  private void clickGuardar(ActionEvent event) {
    if (this.cbResponsable.getValue() != null) {
      try {
        this.inventario.cambiarResponsable(this.labelNumeroSerie.getText(),
            (String) this.cbResponsable.getValue());
        Stage stage = (Stage) bttGuardar.getScene().getWindow();
        stage.close(); 
      } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, 
            "El sistema no está disponible por el momento, inténtelo más tarde");
      }
    } else {
      JOptionPane.showMessageDialog(null, "Seleccione una nueva ubicación");
    }
    
  }
  
}
