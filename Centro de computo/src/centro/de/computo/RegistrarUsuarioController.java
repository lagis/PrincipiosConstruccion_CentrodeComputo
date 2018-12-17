/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
public class RegistrarUsuarioController implements Initializable {

  @FXML
  private TextField tfIdPersonal;

  @FXML
  private TextField tfNombre;

  @FXML
  private TextField tfCorreo;

  @FXML
  private TextField tfTelefono;

  @FXML
  private ChoiceBox cbPuesto;

  @FXML
  private PasswordField pfContrasenia;

  @FXML
  private PasswordField pfConfirmacion;

  @FXML
  private Button bCancelar;

  @FXML
  private Button bRegistrar;
  
  private InventarioPersonalInterface inventario = new InventarioPersonal();

  private final int maxCaracteres = 50;
  private final int maxTelefonoCaracteres= 10;
  private final int maxIDCaracteres = 11;
  
  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    this.cbPuesto.getItems().add("Jefe de centro de computo");
    this.cbPuesto.getItems().add("Tecnico");
  }

   @FXML
  private void registrarButtonEvent(ActionEvent event) {
    int idPersonal = Integer.parseInt(this.tfIdPersonal.getText());
    String nombre = this.tfNombre.getText();
    String correo = this.tfCorreo.getText();
    String telefono = this.tfTelefono.getText();
    String puesto = (String) this.cbPuesto.getValue();
    String contrasenia = this.pfContrasenia.getText();
    
    try {
      if (puesto != null && this.validarDatos()){
        Personal nuevoPersonal = new Personal(idPersonal,nombre,correo,telefono,puesto,contrasenia);
        this.inventario.registrarNuevoPersonal(nuevoPersonal);
        this.cerrarRegistroUsuario(this.bRegistrar);
        try {
          this.volverVentanaAdministrar();
        } catch (IOException ex) {
         JOptionPane.showMessageDialog(null,"El sistema no disponible.");
         
        }
      } else {
      JOptionPane.showMessageDialog(null, "Por favor, introzca datos válidos");
      if(!this.validarIdPersonal()){
        this.tfIdPersonal.setStyle("-fx-text-inner-color: red;");
      }
      if(!this.validarNombre()){
        this.tfNombre.setStyle("-fx-text-inner-color: red;");
      }
      if(!this.validaCorreo()){
        this.tfCorreo.setStyle("-fx-text-inner-color: red;");
      }
      if(!this.validarTelefono()){
        this.tfTelefono.setStyle("-fx-text-inner-color: red;");
      }
      if(!this.validarContrasenia()){
        this.pfConfirmacion.setStyle("-fx-text-inner-color: red;");
      }
    }
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, 
            "El sistema no está disponible por el momento, inténtelo más tarde");
    }
  }
  
 @FXML
  private void cancelarButtonEvent(ActionEvent event){
    try {
      this.volverVentanaAdministrar();
    } catch (IOException ex) {
      Logger.getLogger(RegistrarUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
    }
    this.cerrarRegistroUsuario(this.bCancelar);
  }
  
  private void cerrarRegistroUsuario(Button btt){
    Stage stage = (Stage) btt.getScene().getWindow();
    stage.close();
  }
  
  private void volverVentanaAdministrar() throws IOException{
    Stage stageEquipo = new Stage();
    Parent paneEquipo;
    paneEquipo = FXMLLoader.load(getClass().getResource("AdministrarUsuarios.fxml"));
    Scene sceneEquipo = new Scene(paneEquipo);
    stageEquipo.setScene(sceneEquipo);
    stageEquipo.show(); 
  }
  
  private boolean validarDatos() throws SQLException{
   return this.validarIdPersonal() && this.validarNombre() && this.validaCorreo()
           &&  this.validarTelefono() && this.validarContrasenia();
  }
  
    private boolean validarIdPersonal() throws SQLException {
    Pattern patron = Pattern.compile("[0-9]+");
    Matcher encaja = patron.matcher(this.tfIdPersonal.getText());
    return encaja.matches() && this.tfIdPersonal.getText().length() <= this.maxIDCaracteres
            && !this.inventario.comprobarIdPersonal(Integer.parseInt(this.tfIdPersonal.getText()));
  }
  
  private boolean validarNombre() {
    Pattern patron = Pattern.compile("[a-zA-Z]+");
    Matcher encaja = patron.matcher(this.tfNombre.getText());
    return encaja.matches() && this.tfNombre.getText().length() <= this.maxCaracteres;
  }
    private boolean validarTelefono() throws SQLException {
    Pattern patron = Pattern.compile("[0-9]+");
    Matcher encaja = patron.matcher(this.tfTelefono.getText());
    return encaja.matches() && !this.inventario.comprobarTelefono(this.tfTelefono.getText())
            && this.tfTelefono.getText().length() <= this.maxTelefonoCaracteres;
  }
      private boolean validaCorreo() throws SQLException {
    Pattern patron = Pattern.compile("[A-Za-z0-9.@_-]+");
    Matcher encaja = patron.matcher(this.tfCorreo.getText());
    return encaja.matches() && this.tfCorreo.getText().length() <= this.maxCaracteres
            && !this.inventario.comprobarCorreo(this.tfCorreo.getText());
  }
    private boolean validarContrasenia() {
    Pattern patron = Pattern.compile("[^ ]+");
    Matcher encaja = patron.matcher(this.pfContrasenia.getText());
    return encaja.matches() && this.pfContrasenia.getText().length() <= this.maxCaracteres
            && this.pfContrasenia.getText().equals(this.pfConfirmacion.getText());
  }

  
  
  }
