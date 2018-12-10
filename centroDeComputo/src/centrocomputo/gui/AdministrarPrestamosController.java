/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrocomputo.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Giselle
 */
public class AdministrarPrestamosController implements Initializable {

  @FXML
  private TextField equipoTextField;
  @FXML
  private TextField nombreTextField;
  @FXML
  private DatePicker fechaTextField;
  @FXML
  private TextField matriculaTextField;
  @FXML
  private TextField horaTextField;
  @FXML
  private TextField salonTextField;
  @FXML
  private Button aceptarButton;
  @FXML
  private Button cancelarButton;
  @FXML
  private Button devueltoButton;
  @FXML
  private TableView<?> tablaPrestados;
  @FXML
  private TableColumn<?, ?> columnaFecha;
  @FXML
  private TableColumn<?, ?> columnaEquipo;
  @FXML
  private TableColumn<?, ?> columnaMatricula;
  @FXML
  private TableColumn<?, ?> columnaNombre;
  @FXML
  private TableColumn<?, ?> columnaSalon;
  @FXML
  private TableView<?> tablaPrestamos;
  @FXML
  private TableColumn<?, ?> columnaPrestamosEquipo;
  @FXML
  private TableColumn<?, ?> columnaPrestamosFecha;
  @FXML
  private TableColumn<?, ?> columnaPrestamosHora;
  @FXML
  private TableColumn<?, ?> columnaPrestamosMatricula;
  @FXML
  private TableColumn<?, ?> columnaPrestamosNombre;
  @FXML
  private TableColumn<?, ?> columnaPrestamosSalon;
  @FXML
  private TableColumn<?, ?> columnaPrestamosFechaDevolucion;
  @FXML
  private TableColumn<?, ?> columnaPrestamosHoraDevolucion;

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }  

  @FXML
  private void accionBotonAceptar(ActionEvent event) {
    
  }

  @FXML
  private void accionBotonCancelar(ActionEvent event) {
  }

  @FXML
  private void accionBotonDevuelto(ActionEvent event) {
  }
  
}
