/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Equipo;
import logica.InventarioHardware;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import persistencia.EquipoAlmacen;

/**
 *
 * @author PREDATOR 15 G9-78Q
 */
public class InventarioHardwareTest {
  
  public InventarioHardwareTest() {
  }
  
  @Test
  public void testconsultarListaEquipo() {
    InventarioHardware ih = new InventarioHardware();
    EquipoAlmacen ea = new EquipoAlmacen();
    
    try {
      List<Equipo> lista = ih.consultarListaEquipo();
      List<Equipo> listaEsperada = ea.consultarListaEquipo();
      String idPimerElemento = lista.get(1).getIdentificador();
      String idPrimerElementoEsperado = 
          listaEsperada.get(1).getIdentificador();
      assertEquals(idPimerElemento, idPrimerElementoEsperado);
    } catch (SQLException ex) {
      fail("");
    }
    
  }
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
  @Before
  public void setUp() {
  }
  
  @After
  public void tearDown() {
  }

  // TODO add test methods here.
  // The methods must be annotated with annotation @Test. For example:
  //
  // @Test
  // public void hello() {}
}
