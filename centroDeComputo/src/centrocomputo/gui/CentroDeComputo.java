/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrocomputo.gui;

import centrodecomputo.logica.Equipo;
import centrodecomputo.logica.InterfaceInventarioHardware;
import centrodecomputo.logica.InventarioHardware;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author PREDATOR 15 G9-78Q
 */
public class CentroDeComputo extends Application {
  
  @Override
  public void start(Stage primaryStage) {
    Button btn = new Button();
    btn.setText("Say 'Hello World'");
    btn.setOnAction(new EventHandler<ActionEvent>() {
      
      @Override
      public void handle(ActionEvent event) {
        System.out.println("Hello World!");
      }
    });
    
    StackPane root = new StackPane();
    root.getChildren().add(btn);
    
    Scene scene = new Scene(root, 300, 250);
    
    primaryStage.setTitle("Hello World!");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
    InterfaceInventarioHardware iih = new InventarioHardware();
   // iih.registrarEquipo("predator 117", "apr-g17", "laptop", "acer", "cc1");
    List<Equipo> le = iih.consultarListaEquipo();
    System.out.println(" terminó");
    
    
    //System.out.println(le.get(2).consultarId());
  }
  
}
