/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centro.de.computo;

import java.net.URL;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import logica.Equipo;
import logica.InterfaceEquipo;
import logica.InterfacePrestamo;
import logica.Prestamo;

/**
 * FXML Controller class.
 *
 * @author Giselle
 */
public class AdministrarPrestamosController implements Initializable {

  private InterfaceEquipo equipo = new Equipo();
  private InterfacePrestamo prestamo = new Prestamo();

  @FXML
  private TextField nombreTextField;
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
  private TextField fechaTextField;
  @FXML
  private Button devueltoButton;
  @FXML
  private TableView<Prestamo> tablaPrestados;
  @FXML
  private TableColumn<Prestamo, String> columnaFecha;
  @FXML
  private TableColumn<Prestamo, String> columnaEquipo;
  @FXML
  private TableColumn<Prestamo, String> columnaMatricula;
  @FXML
  private TableColumn<Prestamo, String> columnaNombre;
  @FXML
  private TableColumn<Prestamo, String> columnaSalon;
  @FXML
  private Button actualizarEntregasButton;
  @FXML
  private TableView tablaPrestamos;
  @FXML
  private TableColumn<Prestamo, String> columnaPrestamosEquipo;
  @FXML
  private TableColumn<Prestamo, String> columnaPrestamosFecha;
  @FXML
  private TableColumn<Prestamo, String> columnaPrestamosHora;
  @FXML
  private TableColumn<Prestamo, String> columnaPrestamosMatricula;
  @FXML
  private TableColumn<Prestamo, String> columnaPrestamosNombre;
  @FXML
  private TableColumn<Prestamo, String> columnaPrestamosSalon;
  @FXML
  private TableColumn<Prestamo, String> columnaPrestamosFechaDevolucion;
  @FXML
  private TableColumn<Prestamo, String> columnaPrestamosHoraDevolucion;
  @FXML
  private Button actualizarPrestamosButton;
  @FXML
  private ChoiceBox equipoChoiceBox;
  @FXML
  private TableColumn<?, ?> columnaIdPrestamo;

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {

    try {

      this.equipoChoiceBox.getItems().addAll(this.equipo.obtenerDisponibles());
      this.fechaTextField.setText(this.calcularFecha());
      this.horaTextField.setText(this.calcularHora());

    } catch (SQLException ex) {
      Logger.getLogger(AdministrarPrestamosController.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  @FXML
  private void accionBotonAceptar(ActionEvent event) throws SQLException {
    this.nombreTextField.getText();
    this.matriculaTextField.getText();
    this.equipoChoiceBox.getValue();
    this.salonTextField.getText();

    prestamo.registrarPrestamo(this.nombreTextField.getText(),
            this.matriculaTextField.getText(), this.calcularFecha(),
            this.calcularHora(), this.equipoChoiceBox.getValue().toString(),
            this.salonTextField.getText());
    this.equipoChoiceBox.getItems().clear();
    this.equipoChoiceBox.getItems().addAll(this.equipo.obtenerDisponibles());

    this.limpiarCampos();

  }

  private void limpiarCampos() {
    this.nombreTextField.setText("");
    this.matriculaTextField.setText("");
    this.equipoChoiceBox.setValue("");
    this.salonTextField.setText("");
  }

  @FXML
  private void accionBotonCancelar(ActionEvent event) {
  }

  @FXML
  private void accionBotonDevuelto(ActionEvent event) {
    Prestamo prestado = tablaPrestados.getSelectionModel().getSelectedItem();
    Prestamo llamarMetodo = new Prestamo();
    int id = prestado.getNumeroPrestamo();
    String equipoPrestado = prestado.getEquipo();

    try {
      llamarMetodo.registrarDevolucion(id, this.calcularFecha(),
              this.calcularHora(), equipoPrestado);
      this.equipoChoiceBox.getItems().clear();
      this.equipoChoiceBox.getItems().addAll(this.equipo.obtenerDisponibles());
    } catch (SQLException ex) {
      Logger.getLogger(AdministrarPrestamosController.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  @FXML
  private void accionActualizarEntregasButton(ActionEvent event) {
    this.tablaPrestados.getItems().clear();
    this.llenarTablaPrestados();
  }

  @FXML
  private void accionActualizarPrestamosButton(ActionEvent event) {
    this.tablaPrestamos.getItems().clear();
    this.llenarTabla();
  }

  /**
   * Este método se encarga de añadir todos los registros de los préstamos a la
   * tabla gráfica.
   */
  public void llenarTabla() {
    this.tablaPrestamos.getItems().clear();
    this.columnaPrestamosEquipo.setCellValueFactory(
            new PropertyValueFactory<>("equipo"));
    this.columnaPrestamosNombre.setCellValueFactory(
            new PropertyValueFactory<>("" + "nombreSolicitante"));
    this.columnaPrestamosMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));
    this.columnaPrestamosFecha.setCellValueFactory(new PropertyValueFactory<>("fechaPrestamo"));
    this.columnaPrestamosHora.setCellValueFactory(new PropertyValueFactory<>("horaPrestamo"));
    this.columnaPrestamosFechaDevolucion.setCellValueFactory(new PropertyValueFactory<>(""
            + "fechaDevolucion"));
    this.columnaPrestamosHoraDevolucion.setCellValueFactory(new PropertyValueFactory<>(""
            + "horaDevolucion"));
    this.columnaPrestamosSalon.setCellValueFactory(new PropertyValueFactory<>("salon"));
    List<Prestamo> lista;
    try {
      lista = this.prestamo.obtenerTodosLosPrestamos();
      tablaPrestamos.getItems().clear();
      for (Prestamo prestamo : lista) {
        tablaPrestamos.getItems().add(prestamo);
      }
    } catch (SQLException ex) {
      Logger.getLogger(AdministrarUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
      JOptionPane.showMessageDialog(null, "No se pudieron recuperar los datos");
    }
  }

  /**
   * Este método se encarga de añdir los registros solo de los euipos que etán
   * en estado de "Prestado".
   */
  public void llenarTablaPrestados() {
    this.tablaPrestados.getItems().clear();
    this.columnaIdPrestamo.setCellValueFactory(new PropertyValueFactory<>("numeroPrestamo"));
    this.columnaFecha.setCellValueFactory(new PropertyValueFactory<>("fechaPrestamo"));
    this.columnaEquipo.setCellValueFactory(new PropertyValueFactory<>("equipo"));
    this.columnaMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));
    this.columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombreSolicitante"));
    this.columnaSalon.setCellValueFactory(new PropertyValueFactory<>("salon"));
    List<Prestamo> list;
    try {
      list = this.prestamo.obtenerPrestados();
      tablaPrestados.getItems().clear();
      for (Prestamo prestado : list) {
        tablaPrestados.getItems().add(prestado);
      }
    } catch (SQLException ex) {
      Logger.getLogger(AdministrarUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
      JOptionPane.showMessageDialog(null, "No se pudieron recuperar los datos");
    }
  }

  private String calcularFecha() {
    Calendar dato = new GregorianCalendar();
    String fecha = new String();
    int anio = dato.get(Calendar.YEAR);
    int mes = dato.get(Calendar.MONTH) + 1;
    int dia = dato.get(Calendar.DAY_OF_MONTH);

    fecha = anio + "-" + mes + "-" + dia;

    return fecha;

  }

  private String calcularHora() {
    Calendar dato = new GregorianCalendar();
    String hour = new String();
    int hora = dato.get(Calendar.HOUR_OF_DAY);
    int minuto = dato.get(Calendar.MINUTE);

    hour = hora + ":" + minuto;

    return hour;
  }

  @FXML
  private void accionSeleccionarEquipo(MouseEvent event) {
  }

}
