/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package centro.de.computo;

import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import logica.DictamenMantenimiento;
import logica.InterfaceDictamenMantenimiento;

/**
 * FXML Controller class.
 * @author PREDATOR 15 G9-78Q
 */

public class RegistrarDictamenController implements Initializable {

  @FXML
  private TextField tfTipoDictamen;
  @FXML
  private TextField tfRegion;
  @FXML
  private TextField tfDependencia;
  @FXML
  private TextField tfTipoBorrado;
  @FXML
  private Button bttGuardar;
  @FXML
  private Label labelNumeroSerie;
  @FXML
  private TextArea taObservaciones;
  @FXML
  private TextArea taDescripcion;

  private final int maximoTextField = 45;
  private final int maximoTextArea = 200;

  private final String numeroPersonal = User.getUsuario();
  private static String numeroInventario;

  private InterfaceDictamenMantenimiento inventario = new DictamenMantenimiento();

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    this.labelNumeroSerie.setText(RegistrarDictamenController.numeroInventario);
  }

  @FXML
  private void clickGuardar(ActionEvent event) {
    Date date = new Date();
    java.sql.Date fecha = new java.sql.Date(date.getTime());
    String region = this.tfRegion.getText();
    String dependencia = this.tfDependencia.getText();
    String tipoBorrado = this.tfTipoBorrado.getText();
    String observaciones
        = this.taObservaciones.getText();
    String tipoDictamen = this.tfTipoDictamen.getText();
    String descripcion = this.taDescripcion.getText();

    if (this.validarDatos()) {
      try {
        this.inventario.registrarDictamenString(
            fecha, region, dependencia, tipoBorrado, observaciones,
            tipoDictamen, descripcion,
            numeroPersonal,
            RegistrarDictamenController.numeroInventario);
        Stage stage = (Stage) bttGuardar.getScene().getWindow();
        stage.close();
      } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, 
            "El sistema no está disponible por el momento, inténtelo más tarde");
      }

    } else {
      JOptionPane.showMessageDialog(null, "Introduzca datos válidos");
    }

  }

  private boolean validarTipoDictamen() {
    Pattern patron = Pattern.compile("[a-zA-Z-0-9- ]+");
    Matcher encaja = patron.matcher(this.tfTipoDictamen.getText());
    return encaja.matches() && this.tfTipoDictamen.getText().length() <= this.maximoTextField;
  }

  private boolean validarRegion() {
    Pattern patron = Pattern.compile("[a-zA-Z-0-9- ]+");
    Matcher encaja = patron.matcher(this.tfRegion.getText());
    return encaja.matches() && this.tfRegion.getText().length() <= this.maximoTextField;
  }

  private boolean validarDependencia() {
    Pattern patron = Pattern.compile("[a-zA-Z-0-9- ]+");
    Matcher encaja = patron.matcher(this.tfDependencia.getText());
    return encaja.matches() && this.tfDependencia.getText().length() <= this.maximoTextField;
  }

  private boolean validarTipoBorrado() {
    Pattern patron = Pattern.compile("[a-zA-Z-0-9- ]+");
    Matcher encaja = patron.matcher(this.tfTipoBorrado.getText());
    return encaja.matches() && this.tfTipoBorrado.getText().length() <= this.maximoTextField;
  }

  private boolean validarObservaciones() {
    return this.taObservaciones.getText().length() <= this.maximoTextArea;
  }

  private boolean validarDescripcion() {
    return this.taDescripcion.getText().length() <= this.maximoTextArea;
  }

  private boolean validarDatos() {

    return this.validarTipoDictamen() && this.validarRegion()
        && this.validarDependencia() && this.validarTipoBorrado()
        && this.validarObservaciones() && this.validarDescripcion();
  }

  /**
   * Permite guardar el id del equipo con el que se trabajará.
   * @param idEquipo String.
   */
  
  public static void setIdEquipo(String idEquipo) {
    RegistrarDictamenController.numeroInventario = idEquipo;
  }

}
