/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrocomputo.gui;

import centrodecomputo.logica.Equipo;
import centrodecomputo.logica.InterfaceInventarioHardware;
import centrodecomputo.logica.InventarioHardware;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PREDATOR 15 G9-78Q
 */
public class InventarioHardwareController implements Initializable {

  @FXML
  private TableView<Equipo> tvInventario;
  @FXML
  private TableColumn<Equipo, Integer> tcId;
  @FXML
  private TableColumn<Equipo, String> tcTipoEquipo;
  @FXML
  private TableColumn<Equipo, String> tcModelo;
  @FXML
  private TableColumn<Equipo, String> tcMarca;
  @FXML
  private TableColumn<Equipo, Integer> tcNumeroSerie;
  @FXML
  private TableColumn<Equipo, String> tcResponsable;
  @FXML
  private TableColumn<Equipo, String> tcEstado;
  @FXML
  private Button bttRegistrarEquipo;
  
  private InterfaceInventarioHardware inventario = new InventarioHardware();

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    this.tcId.setCellValueFactory(new PropertyValueFactory<>("identificador"));
    this.tcTipoEquipo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
    this.tcModelo.setCellValueFactory(new PropertyValueFactory<>("numeroSerie"));
    this.tcNumeroSerie.setCellValueFactory(new PropertyValueFactory<>("tipoEquipo"));
    this.tcResponsable.setCellValueFactory(new PropertyValueFactory<>("responsableUbicacion"));
    this.tcEstado.setCellValueFactory(new PropertyValueFactory<>("disponibilidad"));
    this.tcMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
    
    this.llenarLista(this.inventario.consultarListaEquipo());
    
  }  
  
  public void llenarLista(List<Equipo> listaEquipo){
    tvInventario.getItems().clear();
    for (Equipo equipo : listaEquipo) {
      tvInventario.getItems().add(equipo); 
    }
  }

  @FXML
  private void clickRegistrar(ActionEvent event) {
    try {
        Stage stageEquipo = new Stage();
        Parent paneEquipo = FXMLLoader.load(getClass().getResource("registrarEquipo.fxml"));
        Scene sceneEquipo = new Scene(paneEquipo);
        stageEquipo.setScene(sceneEquipo);
        stageEquipo.show();
        this.llenarLista(this.inventario.consultarListaEquipo());
    } catch (Exception e) {
      e.printStackTrace();
      
    }
  }
  
}
