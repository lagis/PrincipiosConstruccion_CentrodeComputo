/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package centro.de.computo;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import logica.InterfaceInventarioHardware;
import logica.InventarioHardware;

/**
 * FXML Controller class.
 *
 * @author PREDATOR 15 G9-78Q
 */
public class RegistrarEquipoController implements Initializable {

  @FXML
  private TextField tfModelo;
  @FXML
  private TextField tfMarca;
  @FXML
  private TextField tfNumeroSerie;
  @FXML
  private ChoiceBox cbTipoEquipo;
  @FXML
  private Button bttGuardar;
  @FXML
  private ChoiceBox cbResponsable;

  private InterfaceInventarioHardware inventario = new InventarioHardware();

  private final int longitudMaximaNumeroSerie = 20;
  private final int longitudMaximaMarca = 45;

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
    this.cbResponsable.getItems().add("Bodega");

  }

  @FXML
  private void clickGuardarEquipo(ActionEvent event) {

    String modelo = this.tfModelo.getText();
    String numeroSerie = this.tfNumeroSerie.getText();
    String tipoEquipo = (String) this.cbTipoEquipo.getValue();
    String marca = this.tfMarca.getText();
    String responsableUbicacion = (String) this.cbResponsable.getValue();

    if (this.validarDatos() && this.cbResponsable.getValue() != null
            && this.cbTipoEquipo.getValue() != null) {

      try {
        this.inventario.registrarEquipo(modelo, numeroSerie,
                tipoEquipo, marca, responsableUbicacion);
        Stage stage = (Stage) bttGuardar.getScene().getWindow();
        stage.close();
      } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,
                "Ya existe un equipo con ese número de serie.");
      }
    } else {
      JOptionPane.showMessageDialog(null, "Por favor, introzca datos válidos");
    }

  }

  private boolean validarMarca() {
    Pattern patron = Pattern.compile("[a-zA-Z-0-9- ]+");
    Matcher encaja = patron.matcher(this.tfMarca.getText());
    return encaja.matches() && this.tfMarca.getText().length() <= this.longitudMaximaMarca;
  }

  private boolean validarModelo() {
    Pattern patron = Pattern.compile("[a-zA-Z-0-9- ]+");
    Matcher encaja = patron.matcher(this.tfModelo.getText());
    return encaja.matches() && this.tfNumeroSerie.getText().length() <= this.longitudMaximaMarca;
  }

  private boolean validarNumeroSerie() {
    Pattern patron = Pattern.compile("[a-zA-Z-0-9]+");
    Matcher encaja = patron.matcher(this.tfNumeroSerie.getText());
    return encaja.matches() && this.tfNumeroSerie.getText().length()
            <= this.longitudMaximaNumeroSerie;
  }

  private boolean validarDatos() {
    return this.validarMarca() && this.validarModelo() && this.validarNumeroSerie();
  }
}
