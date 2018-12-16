/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package centro.de.computo;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ContextMenuEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import logica.Equipo;
import logica.InterfaceInventarioHardware;
import logica.InventarioHardware;

/**
 * FXML Controller class Controlador de InventarioHardware.
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
  private final String numeroPersonal = User.getUsuario();
  private final String mensajeError = 
      "El sistema no está disponible por el momento, inténtelo más tarde";

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    this.tcId.setCellValueFactory(new PropertyValueFactory<>("identificador"));
    this.tcTipoEquipo.setCellValueFactory(new PropertyValueFactory<>("tipoEquipo"));
    this.tcModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
    this.tcNumeroSerie.setCellValueFactory(new PropertyValueFactory<>("numeroSerie"));
    this.tcResponsable.setCellValueFactory(new PropertyValueFactory<>("responsableUbicacion"));
    this.tcEstado.setCellValueFactory(new PropertyValueFactory<>("disponibilidad"));
    this.tcMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));

    Label labelMenu = new Label();

    ContextMenu contextMenu = new ContextMenu();
    MenuItem item1 = new MenuItem("Cambiar responsable");
    item1.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        labelMenu.setText("Cambiar responsable");

        cambiarResponsable(tvInventario.getSelectionModel().getSelectedItem().getModelo(),
            tvInventario.getSelectionModel().getSelectedItem().getIdentificador());
      }
    });

    MenuItem item2 = new MenuItem("Registrar dictamen de mantenimiento");
    item2.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        labelMenu.setText("Registrar dictamen de mantenimiento");
        registrarDictamen(tvInventario.getSelectionModel().getSelectedItem().getIdentificador(),
            numeroPersonal);
      }
    });
    if (User.getPuesto().equalsIgnoreCase("jefe")) {
      contextMenu.getItems().addAll(item1, item2);
    } else {
      contextMenu.getItems().addAll(item2);
      this.bttRegistrarEquipo.setVisible(false);
    }

    tvInventario.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
      @Override
      public void handle(ContextMenuEvent event) {
        contextMenu.show(tvInventario, event.getScreenX(), event.getScreenY());
      }
    });

    try {
      this.llenarLista(this.inventario.consultarListaEquipo());
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,
          this.mensajeError);
    }

  }

  private void llenarLista(List<Equipo> listaEquipo) {
    tvInventario.getItems().clear();
    for (Equipo equipo : listaEquipo) {
      tvInventario.getItems().add(equipo);
    }
  }

  @FXML
  private void clickRegistrar(ActionEvent event) {
    this.abrirVentana("RegistrarEquipo.fxml");
  }

  @FXML
  private void clickConsultar(ActionEvent event) {
    try {
      this.llenarLista(this.inventario.consultarListaEquipo());
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, 
          this.mensajeError);
    }
  }

  private void cambiarResponsable(String modelo, String id) {
    CambiarResponsableController.mandarModeloNumeroSerie(modelo, id);
    this.abrirVentana("CambiarResponsable.fxml");
  }

  private void registrarDictamen(String idEquipo, String numeroPersonal) {
    RegistrarDictamenController.setIdEquipo(idEquipo);
    this.abrirVentana("RegistrarDictamen.fxml");
  }

  private void abrirVentana(String ventana) {
    Stage stageEquipo = new Stage();
    Parent paneEquipo;
    try {
      paneEquipo = FXMLLoader.load(getClass().getResource(ventana));
      Scene sceneEquipo = new Scene(paneEquipo);
      stageEquipo.setScene(sceneEquipo);
      stageEquipo.show();
    } catch (IOException ex) {
      JOptionPane.showMessageDialog(null,
          this.mensajeError);
    }
  }

}
