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
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.swing.JOptionPane;
import logica.InventarioPersonal;
import logica.InventarioPersonalInterface;
import logica.Personal;

/**
 * FXML Controller class
 *
 * @author marai
 */
public class AdministrarUsuariosController implements Initializable {

  private InventarioPersonalInterface personal = new InventarioPersonal();

  @FXML
  private TableColumn<Personal, String> columnNumero;

  @FXML
  private TableColumn<Personal, String> columnNombre;

  @FXML
  private TableColumn<Personal, String> columnPuesto;

  @FXML
  private TableColumn<Personal, String> columnTelefono;

  @FXML
  private TableColumn<Personal, String> columnCorreo;

  @FXML
  private TableView<Personal> tabla;

  @FXML
  private Button bRegistrar;

  @FXML
  private Button bEditar;

  @FXML
  private Button bVolver;

  /**
   * Initializes the controller class.
   *
   * @param url
   * @param rb
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    this.columnNumero.setCellValueFactory(new PropertyValueFactory<>("idPersonal"));
    this.columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    this.columnPuesto.setCellValueFactory(new PropertyValueFactory<>("correo"));
    this.columnTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
    this.columnCorreo.setCellValueFactory(new PropertyValueFactory<>("puesto"));
    this.llenarTabla();

  }

  public void llenarTabla() {
    List<Personal> lista;
    try {
      lista = this.personal.verPersonal();
      tabla.getItems().clear();
      for (Personal persona : lista) {
        tabla.getItems().add(persona);
      }
    } catch (SQLException ex) {
      Logger.getLogger(AdministrarUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
      JOptionPane.showMessageDialog(null, "No se pudieron recuperar los datos");
    }
  }

  public void nuevoPersonalEvent(ActionEvent event) {
    try {
      this.abrirVentana("RegistrarUsuario.fxml");
    } catch (IOException ex) {
      Logger.getLogger(AdministrarUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
    }
    this.cerrarVentana(this.bRegistrar);
  }

  public void editarUsuarioEvent(ActionEvent event) {
    try {
      this.abrirVentana("Editar.fxml");
    } catch (IOException ex) {
      Logger.getLogger(AdministrarUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
    }
    this.cerrarVentana(this.bEditar);
  }
  
  public void volverEvent(ActionEvent event) {
    try {
      this.abrirVentana("Login.fxml");
    } catch (IOException ex) {
      Logger.getLogger(AdministrarUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
    }
    this.cerrarVentana(this.bVolver);
  }
  
  public void abrirVentana(String ventana) throws IOException {
    Stage stage = new Stage();
    Parent pane = FXMLLoader.load(getClass().getResource(ventana));
    Scene sceneEquipo = new Scene(pane);
    stage.setScene(sceneEquipo);
    stage.show();
  }

  public void cerrarVentana(Button boton) {
    Stage stage = (Stage) boton.getScene().getWindow();
    stage.close();
  }

}