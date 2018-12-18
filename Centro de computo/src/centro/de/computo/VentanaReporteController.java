/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package centro.de.computo;

import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import logica.DictamenMantenimiento;
import logica.InterfaceDictamenMantenimiento;

/**
 * FXML Controller class.
 *
 * @author PREDATOR 15 G9-78Q
 */
public class VentanaReporteController implements Initializable {

  @FXML
  private TableView<DictamenMantenimiento> tableView;
  @FXML
  private TableColumn<DictamenMantenimiento, Integer> columnNumeroReporte;
  @FXML
  private TableColumn<DictamenMantenimiento, Date> columnFecha;
  @FXML
  private TableColumn<DictamenMantenimiento, String> columnRegion;
  @FXML
  private TableColumn<DictamenMantenimiento, String> columnDependencia;
  @FXML
  private TableColumn<DictamenMantenimiento, String> columnTipoBorrado;
  @FXML
  private TableColumn<DictamenMantenimiento, String> columnObservaciones;
  @FXML
  private TableColumn<DictamenMantenimiento, String> columnTipoDictamen;
  @FXML
  private TableColumn<DictamenMantenimiento, String> columnDescripcion;
  @FXML
  private TableColumn<DictamenMantenimiento, String> columnNumeroSerie;

  private static final InterfaceDictamenMantenimiento almacen
          = new DictamenMantenimiento();

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    this.columnNumeroReporte.setCellValueFactory(new PropertyValueFactory<>("numeroDeReporte"));
    this.columnFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
    this.columnRegion.setCellValueFactory(new PropertyValueFactory<>("region"));
    this.columnDependencia.setCellValueFactory(new PropertyValueFactory<>("entidadAcademica"));
    this.columnTipoBorrado.setCellValueFactory(new PropertyValueFactory<>("tipoBorrado"));
    this.columnObservaciones.setCellValueFactory(new PropertyValueFactory<>("observaciones"));
    this.columnTipoDictamen.setCellValueFactory(new PropertyValueFactory<>("tipoDictamen"));
    this.columnDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
    this.columnNumeroSerie.setCellValueFactory(new PropertyValueFactory<>("idEquipo"));

    try {
      this.llenarLista(VentanaReporteController.almacen.generarReporteMantinimiento());
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,
              "El sistema no está disponible por el momento, inténtelo más tarde");
    }

  }

  private void llenarLista(List<DictamenMantenimiento> lista) {
    tableView.getItems().clear();
    for (DictamenMantenimiento dictamen : lista) {
      tableView.getItems().add(dictamen);
    }
  }

}
