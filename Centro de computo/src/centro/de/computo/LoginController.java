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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
import javax.swing.JOptionPane;
import logica.Personal;
import logica.PersonalInterface;

/**
 * FXML Controller class
 *
 * @author marai
 */

public class LoginController implements Initializable {

  private PersonalInterface personal = new Personal();
  
  @FXML
  private TextField textField;

  @FXML
  private PasswordField passwordtField;

  @FXML
  private Button loginBoton;
  
  public final int longMax = 20;

  
  
  @FXML
  private void loginButtonAction(ActionEvent event) throws IOException, SQLException {
    String usuario = textField.getText();
    String contrasenia = passwordtField.getText();
    
    if (this.validarPassowrd() && this.validarUser()) {

      if (this.personal.comprobarPersonal(Integer.parseInt(usuario), contrasenia)) {
        System.out.println("Inicio");
        User.enviarUsuario(usuario);
        String puesto = this.personal.obtenerPuesto(Integer.parseInt(usuario));
        User.enviarPuesto(puesto);
        this.abrirVentana("Menu.fxml");
        this.cerrarLogin();
      } else {
        JOptionPane.showMessageDialog(null, "Contraseña y/o usuario inválidos");
      }
    } else {
      JOptionPane.showMessageDialog(null, "Por favor, introzca datos válidos");
    }
  }

  public void abrirVentana(String ventana) {
    Stage stageEquipo = new Stage();
    Parent paneEquipo;
    try {
      paneEquipo = FXMLLoader.load(getClass().getResource(ventana));
      Scene sceneEquipo = new Scene(paneEquipo);
      stageEquipo.setScene(sceneEquipo);
      stageEquipo.show();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  
  private boolean validarPassowrd(){
    Pattern patron = Pattern.compile("[^ ]+");
    Matcher encaja = patron.matcher(this.passwordtField.getText());
    return encaja.matches() && this.passwordtField.getText().length() <= this.longMax;
  }
  
  private boolean validarUser(){
    Pattern patron = Pattern.compile("[0-9]+");
    Matcher encaja = patron.matcher(this.textField.getText());
    return encaja.matches() && this.textField.getText().length() <= this.longMax;
  }
  
  
  private boolean camposVacios(){
    return textField.getText().trim().isEmpty() 
        && passwordtField.getText().trim().isEmpty();
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
