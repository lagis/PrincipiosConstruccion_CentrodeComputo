/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrocomputo.gui;

import centrodecomputo.logica.InterfaceInventarioHardware;
import centrodecomputo.logica.InventarioHardware;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PREDATOR 15 G9-78Q
 */
public class RegistrarEquipoController implements Initializable {

  @FXML
  private TextField tfModelo;
  @FXML
  private TextField Marca;
  @FXML
  private TextField tfNumeroSerie;
  @FXML
  private ChoiceBox cbTipoEquipo;
  @FXML
  private Button bttGuardar;
  @FXML
  private ChoiceBox cbResponsable;
  
  private InterfaceInventarioHardware inventario = new InventarioHardware();

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    this.cbTipoEquipo.getItems().add("Desktop");
    this.cbTipoEquipo.getItems().add("Laptop");
    this.cbTipoEquipo.getItems().add("Cañon");
    this.cbResponsable.getItems().add("CC1");
    this.cbResponsable.getItems().add("CC2");
    this.cbResponsable.getItems().add("CC3");
    this.cbResponsable.getItems().add("CC4");
    
  }  

  @FXML
  private void clickGuardarEquipo(ActionEvent event) {
    
    String modelo = this.tfModelo.getText();
    String numeroSerie = this.tfNumeroSerie.getText();
    String tipoEquipo = (String) this.cbTipoEquipo.getValue();
    String marca = this.Marca.getText();
    String responsableUbicacion = (String) this.cbResponsable.getValue();
  
    this.inventario.registrarEquipo(modelo, numeroSerie, tipoEquipo, marca, responsableUbicacion);
   
  }
  }
