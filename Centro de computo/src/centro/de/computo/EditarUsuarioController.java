package centro.de.computo;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import logica.InventarioPersonal;
import logica.InventarioPersonalInterface;
import logica.Personal;

/**
 * FXML Controller class.
 *
 * @author marai
 */
public class EditarUsuarioController implements Initializable {

  private InventarioPersonalInterface personal = new InventarioPersonal();
  private Personal persona;
  private final int limite = 50;
  private final int limitePhone = 10;

  @FXML
  private Label labelIdPersonal;
  @FXML
  private TextField tfNuevoNombte;
  @FXML
  private TextField tfNuevoCorreo;
  @FXML
  private TextField tfNuevoTelefono;
  @FXML
  private ChoiceBox cbNuevoPuesto;
  @FXML
  private Button botonGuardar;
  @FXML
  private Button botonCancelar;
  @FXML
  private PasswordField pfPassword;
  @FXML
  private PasswordField pfConfirmar;

  /**
   * Initializes the controller class.
   *
   * @param url parametro por defecto
   * @param rb parametro por defecto
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    this.cbNuevoPuesto.getItems().add("Jefe de centro de computo");
    this.cbNuevoPuesto.getItems().add("Tecnico");
  }

  @FXML
  private void edtitarButtonEvent(ActionEvent event) {
    int idPersonal = Integer.parseInt(this.labelIdPersonal.getText());
    String nombre = this.tfNuevoNombte.getText();
    String correo = this.tfNuevoCorreo.getText();
    String telefono = this.tfNuevoTelefono.getText();
    String puesto = (String) this.cbNuevoPuesto.getValue();
    String contrasenia = this.pfPassword.getText();

    try {
      if (puesto != null && this.validarDatos()) {
        persona = new Personal(idPersonal, nombre, correo, telefono, puesto, contrasenia);
        this.personal.editarPersonal(persona);
        this.cerrarEditar(this.botonGuardar);
        try {
          this.regresarAdministrar();
        } catch (IOException ex) {
          JOptionPane.showMessageDialog(null, "El sistema no está disponible");

        }
      } else {
        JOptionPane.showMessageDialog(null, "Por favor, introzca datos válidos");
        if (!this.validarNombre()) {
          this.tfNuevoNombte.setStyle("-fx-text-inner-color: red;");
        }
        if (!this.validaCorreo()) {
          this.tfNuevoCorreo.setStyle("-fx-text-inner-color: red;");
        }
        if (!this.validarTelefono()) {
          this.tfNuevoTelefono.setStyle("-fx-text-inner-color: red;");
        }
        if (!this.validarContrasenia()) {
          this.pfConfirmar.setStyle("-fx-text-inner-color: red;");
        }
      }
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "No se ´pudo completar la acción");
    }
  }

  @FXML
  private void cancelarButtonEvent(ActionEvent event) {
    try {
      this.regresarAdministrar();
    } catch (IOException ex) {
      Logger.getLogger(EditarUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
    }
    this.cerrarEditar(this.botonCancelar);
  }

  private void cerrarEditar(Button btt) {
    Stage stage = (Stage) btt.getScene().getWindow();
    stage.close();
  }

  private void regresarAdministrar() throws IOException {
    Stage stageEquipo = new Stage();
    Parent paneEquipo;
    paneEquipo = FXMLLoader.load(getClass().getResource("AdministrarUsuarios.fxml"));
    Scene sceneEquipo = new Scene(paneEquipo);
    stageEquipo.setScene(sceneEquipo);
    stageEquipo.show();
  }

  /**
   * Recibe el objeto selecicionado en la ventana anterior.
   * 
   * @param id se refiere al identificador del personal enviado
   */
  @FXML
  public void llenarFormulario(String id) {
    this.labelIdPersonal.setText(id);
    try {
      this.persona = this.personal.obtenerPersonal(Integer.parseInt(id));
      this.tfNuevoNombte.setText(this.persona.getNombre());
      this.tfNuevoCorreo.setText(this.persona.getCorreo());
      this.tfNuevoTelefono.setText(this.persona.getTelefono());
      this.pfPassword.setText(this.persona.getContrasenia());

    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "No se pudieron recuperar los datos.");
    }

  }

  private boolean validarDatos() throws SQLException {
    return this.validarNombre() && this.validaCorreo() && this.validarTelefono()
            && this.validarContrasenia();
  }

  private boolean validarNombre() {
    Pattern patron = Pattern.compile("[a-zA-Z- ]+");
    Matcher encaja = patron.matcher(this.tfNuevoNombte.getText());
    return encaja.matches() && this.tfNuevoNombte.getText().length() <= this.limite;
  }

  private boolean validarTelefono() throws SQLException {
    Pattern patron = Pattern.compile("[0-9]+");
    Matcher encaja = patron.matcher(this.tfNuevoTelefono.getText());
    return encaja.matches() && this.tfNuevoTelefono.getText().length() <= this.limitePhone;
  }

  private boolean validaCorreo() throws SQLException {
    Pattern patron = Pattern.compile("[A-Za-z0-9.@_-]+");
    Matcher encaja = patron.matcher(this.tfNuevoCorreo.getText());
    return encaja.matches() && this.tfNuevoCorreo.getText().length() <= this.limite;
  }

  private boolean validarContrasenia() {
    Pattern patron = Pattern.compile("[^ ]+");
    Matcher encaja = patron.matcher(this.pfPassword.getText());
    return encaja.matches() && this.pfPassword.getText().length() <= this.limite
            && this.pfPassword.getText().equals(this.pfConfirmar.getText());
  }

}
