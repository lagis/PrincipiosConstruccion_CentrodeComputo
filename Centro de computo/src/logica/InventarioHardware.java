/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.sql.SQLException;
import java.util.List;
import persistencia.EquipoAlmacen;
import persistencia.PersistenciaEquipo;

/**
 * Contiene métodos para manipular un equipo.
 * @author ferc
 */

public class InventarioHardware implements InterfaceInventarioHardware {
  private List<Equipo> inventario;
  private final PersistenciaEquipo persistencia = new EquipoAlmacen();

  public InventarioHardware() {
  }
  
  /**
   * Permite registrar un nuevo equipo en el inventario.
   * @param modelo de tipo Sting que se registra en el nuevo equipo.
   * @param numeroSerie de tipo Sting que se registra en el nuevo equipo.
   * @param tipoEquipo de tipo Sting que se registra en el nuevo equipo.
   * @param marca de tipo Sting que se registra en el nuevo equipo.
   * @param responsableUbicacion de tipo Sting que se registra en el nuevo equipo.
   * @throws SQLException Se arroja esta excepción cuando no es posible guardar el nuevo equipo.
   */
  
  @Override
  public void registrarEquipo(String modelo, String numeroSerie, 
      String tipoEquipo,String marca, String responsableUbicacion) throws SQLException {
    
    this.persistencia.registrarEquipo(modelo, numeroSerie, tipoEquipo, marca, responsableUbicacion);
  }


  @Override
  public List<Equipo> consultarListaEquipo() throws SQLException {
    this.inventario = this.persistencia.consultarListaEquipo();
    return this.inventario;
  }

  /**
   * Permite recuperar un equipo específico.
   * @param id de tipo String sobre el cual se buscará el equipo.
   * @return Regresa un objeto de tipo Equipo, que coincidirpa con el id.
   * @throws SQLException Se arroja esta excepción cuando no es posible guardar el nuevo equipo.
   */
  
  @Override
  public Equipo consultarEquipo(String id) throws SQLException {
    return this.persistencia.consultarEquipo(id);
  }

  /**
   * Cambia el responsable acargo del equipo.
   * @param id String, identificador del equipo.
   * @param nuevaUbicacion String, nueva ubicación del equipo.
   * @throws SQLException Se  arroja si no es posible realizar el cambio.
   */
  
  @Override
  public void cambiarResponsable(String id, String nuevaUbicacion) throws SQLException {
    this.persistencia.cambiarResponsable(id, nuevaUbicacion);
  }

  
}
