/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrocomputo.gui;

import centrodecomputo.logica.JefeCentroComputo;
import centrodecomputo.logica.Personal;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 * FXML Controller class
 *
 * @author marai
 */
public class AdministrarUsuariosController implements Initializable {
  
  @FXML
  private TableColumn<Personal,String> columnNumero;
  
  @FXML
  private TableColumn<Personal,String> columnNombre;

  @FXML
  private TableColumn<Personal,String> columnPuesto;
  
  @FXML
  private TableColumn<Personal,String> columnTelefono;
  
  @FXML
  private TableColumn<Personal,String> columnCorreo;
  
  @FXML
  private TableView<Personal> tabla;
  
  JefeCentroComputo jefe = new JefeCentroComputo();
  

  /**
   * Initializes the controller class.
   * @param url
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
   this.columnNumero.setCellValueFactory(new PropertyValueFactory<>("idPersonal"));
   this.columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
   this.columnPuesto.setCellValueFactory(new PropertyValueFactory<>("correo"));
   this.columnTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
   this.columnCorreo.setCellValueFactory(new PropertyValueFactory<>("puesto"));
   this.llenarTabla(jefe.verPersonal());
  }
  
  public void llenarTabla(List<Personal> lista) {
    tabla.getItems().clear();
    for (Personal persona : lista) {
      tabla.getItems().add(persona);
    }
  }
  
}
