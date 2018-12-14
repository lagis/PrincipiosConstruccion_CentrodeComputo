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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logica.Personal;
import logica.PersonalInterface;

/**
 * FXML Controller class
 *
 * @author marai
 */
public class LoginController implements Initializable {

  private PersonalInterface personal;
  
  @FXML
  private TextField textField;

  @FXML
  private PasswordField passwordtField;

  @FXML
  private Button loginBoton;

  @FXML
  private void loginButtonAction(ActionEvent event) throws IOException, SQLException {
    String usuario = textField.getText();
    String contrasenia = passwordtField.getText();
    
    if (camposVacios()) {
      enviarMensaje("Campos vacios", "Ingrese datos a los campos.");
    } else {
      this.personal = new Personal(usuario,contrasenia);
      if (personal.comprobarUsuario()) {
        if(personal.comprobarContrasenia()) {
          System.out.println("Funciona.");
          //this.abrirVentana("AdministrarUsuarios.fxml");
          //this.cerrarLogin();
        } else {
          enviarMensaje("Error","Contraseña no valida.");
        }        
      } else {
        enviarMensaje("Error","Usario no encontrado");
      }
    }
  }

  public void abrirVentana(String ventana) {
    Parent panel;
    Stage stage = new Stage();
    try {
      panel = FXMLLoader.load(getClass().getResource(ventana));
      Scene sceneEquipo = new Scene(panel);
      stage.setScene(sceneEquipo);
      stage.show();
    } catch (IOException ex) {
      //TODO
    }
  }
  
  private boolean camposVacios(){
    return textField.getText().trim().isEmpty() || passwordtField.getText().trim().isEmpty();
  }

  public void cerrarLogin() {
    Stage stage = (Stage) loginBoton.getScene().getWindow();
    stage.close();
  }
  
  private void enviarMensaje(String titulo, String mensaje) {
    Alert fail = new Alert(AlertType.INFORMATION);
    fail.setTitle(titulo);
    fail.setHeaderText(mensaje);
    fail.showAndWait();
  }

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {

  }
}
