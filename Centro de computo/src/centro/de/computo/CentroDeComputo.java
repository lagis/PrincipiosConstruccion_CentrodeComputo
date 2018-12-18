/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package centro.de.computo;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Clase inicio del programa.
 * @author PREDATOR 15 G9-78Q
 */
public class CentroDeComputo extends Application {

  @Override
  public void start(Stage primaryStage) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
    Scene scene = new Scene(root);

    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /**
   * Main por defecto.
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

}
