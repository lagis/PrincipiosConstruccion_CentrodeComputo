/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PREDATOR 15 G9-78Q
 */
public class InventarioHardwareTest {

  public InventarioHardwareTest() {
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

  /**
   * Test of registrarEquipo method, of class InventarioHardware.
   */
  @Test
  public void testRegistrarEquipo() {
    /*
    System.out.println("registrarEquipo");
    String modelo = "";
    String numeroSerie = "";
    String tipoEquipo = "";
    String marca = "";
    String responsableUbicacion = "";
    InventarioHardware instance = new InventarioHardware();
    try {
      instance.registrarEquipo(modelo, numeroSerie, tipoEquipo, marca, responsableUbicacion);
    } catch (SQLException ex) {
      Logger.getLogger(InventarioHardwareTest.class.getName()).log(Level.SEVERE, null, ex);
    }
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  
     */
  }

  /**
   * Test of consultarListaEquipo method, of class InventarioHardware.
   */
  @Test
  public void testConsultarListaEquipo() {
    /*
    System.out.println("consultarListaEquipo");
    InventarioHardware instance = new InventarioHardware();
    List<Equipo> expResult = null;
    List<Equipo> result;
    try {
      result = instance.consultarListaEquipo();
      assertEquals(expResult, result);
    } catch (SQLException ex) {
      Logger.getLogger(InventarioHardwareTest.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
     */
  }

  /**
   * Test of consultarEquipo method, of class InventarioHardware.
   */
  @Test
  public void testConsultarEquipo() {
    System.out.println("consultarEquipo");
    String id = "3";
    InventarioHardware instance = new InventarioHardware();
    String expResult = "Desktop";
    Equipo result;
    try {
      result = instance.consultarEquipo(id);
      String res = result.getTipoEquipo();
      assertEquals(expResult, res);
    } catch (SQLException ex) {
      ex.printStackTrace();
      fail("No pasó, bro");
    }

  }

  /**
   * Test of cambiarResponsable method, of class InventarioHardware.
   */
  @Test
  public void testCambiarResponsable() {
    /*
    System.out.println("cambiarResponsable");
    String id = "";
    String nuevaUbicacion = "";
    InventarioHardware instance = new InventarioHardware();
    try {
      instance.cambiarResponsable(id, nuevaUbicacion);
    } catch (SQLException ex) {
      Logger.getLogger(InventarioHardwareTest.class.getName()).log(Level.SEVERE, null, ex);
    }
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
     */
  }

}
