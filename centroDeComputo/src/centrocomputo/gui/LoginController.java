/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrocomputo.gui;

import centrodecomputo.logica.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author marai
 */
public class LoginController implements Initializable {
  
  @FXML
  private TextField textField;
  
  @FXML
  private PasswordField passwordtField;
  
  @FXML
  private void loginButtonAction(ActionEvent event) throws IOException {
    String usuario = textField.getText();
    String contrasenia = passwordtField.getText();
    Alert fail = new Alert(AlertType.INFORMATION);
    
    if (textField.getText().trim().isEmpty() || passwordtField.getText().trim().isEmpty()) {
      fail.setTitle("Campos vacíos");
      fail.setHeaderText("Algunos campos están vacíos, por favor ingrese los datos");
      fail.showAndWait();
    } else {
      Usuario user = new Usuario(usuario, contrasenia);
      if (user.iniciarSesion() == null) {
        fail.setTitle("Usuario no encontrado");
        fail.setHeaderText("Usuario no encontrado");
        fail.showAndWait();
      } else {
        if (user.iniciarSesion().equalsIgnoreCase("Tecnico")) {
          
        } else {
          FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdministrarUsuarios.fxml"));
          Parent root = (Parent) fxmlLoader.load();
          Stage stage = new Stage();
          stage.setScene(new Scene(root));
        }
      }
    }
  }
  

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    
  }  
  
}
