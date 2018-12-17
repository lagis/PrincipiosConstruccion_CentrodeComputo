/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Date;
import java.util.List;
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
public class DictamenMantenimientoTest {
  
  public DictamenMantenimientoTest() {
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
   * Test of getNombre method, of class DictamenMantenimiento.
   */
  @Test
  public void testGetNombre() {
    System.out.println("getNombre");
    DictamenMantenimiento instance = new DictamenMantenimiento();
    String expResult = "";
    String result = instance.getNombre();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getFecha method, of class DictamenMantenimiento.
   */
  @Test
  public void testGetFecha() {
    System.out.println("getFecha");
    DictamenMantenimiento instance = new DictamenMantenimiento();
    Date expResult = null;
    Date result = instance.getFecha();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getRegion method, of class DictamenMantenimiento.
   */
  @Test
  public void testGetRegion() {
    System.out.println("getRegion");
    DictamenMantenimiento instance = new DictamenMantenimiento();
    String expResult = "";
    String result = instance.getRegion();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getTelefono method, of class DictamenMantenimiento.
   */
  @Test
  public void testGetTelefono() {
    System.out.println("getTelefono");
    DictamenMantenimiento instance = new DictamenMantenimiento();
    String expResult = "";
    String result = instance.getTelefono();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getCorreo method, of class DictamenMantenimiento.
   */
  @Test
  public void testGetCorreo() {
    System.out.println("getCorreo");
    DictamenMantenimiento instance = new DictamenMantenimiento();
    String expResult = "";
    String result = instance.getCorreo();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getEntidadAcademica method, of class DictamenMantenimiento.
   */
  @Test
  public void testGetEntidadAcademica() {
    System.out.println("getEntidadAcademica");
    DictamenMantenimiento instance = new DictamenMantenimiento();
    String expResult = "";
    String result = instance.getEntidadAcademica();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getTipoBorrado method, of class DictamenMantenimiento.
   */
  @Test
  public void testGetTipoBorrado() {
    System.out.println("getTipoBorrado");
    DictamenMantenimiento instance = new DictamenMantenimiento();
    String expResult = "";
    String result = instance.getTipoBorrado();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getObservaciones method, of class DictamenMantenimiento.
   */
  @Test
  public void testGetObservaciones() {
    System.out.println("getObservaciones");
    DictamenMantenimiento instance = new DictamenMantenimiento();
    String expResult = "";
    String result = instance.getObservaciones();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getNumeroDeReporte method, of class DictamenMantenimiento.
   */
  @Test
  public void testGetNumeroDeReporte() {
    System.out.println("getNumeroDeReporte");
    DictamenMantenimiento instance = new DictamenMantenimiento();
    int expResult = 0;
    int result = instance.getNumeroDeReporte();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getTipoDictamen method, of class DictamenMantenimiento.
   */
  @Test
  public void testGetTipoDictamen() {
    System.out.println("getTipoDictamen");
    DictamenMantenimiento instance = new DictamenMantenimiento();
    String expResult = "";
    String result = instance.getTipoDictamen();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getDescripcion method, of class DictamenMantenimiento.
   */
  @Test
  public void testGetDescripcion() {
    System.out.println("getDescripcion");
    DictamenMantenimiento instance = new DictamenMantenimiento();
    String expResult = "";
    String result = instance.getDescripcion();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getIdEquipo method, of class DictamenMantenimiento.
   */
  @Test
  public void testGetIdEquipo() {
    System.out.println("getIdEquipo");
    DictamenMantenimiento instance = new DictamenMantenimiento();
    String expResult = "";
    String result = instance.getIdEquipo();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of registrarDictamenString method, of class DictamenMantenimiento.
   */
  @Test
  public void testRegistrarDictamenString() throws Exception {
    System.out.println("registrarDictamenString");
    java.sql.Date fecha = null;
    String region = "";
    String dependencia = "";
    String tipoBorrado = "";
    String observaciones = "";
    String tipoDictamen = "";
    String descripcion = "";
    String idPersonal = "";
    String numeroInventario = "";
    DictamenMantenimiento instance = new DictamenMantenimiento();
    instance.registrarDictamenString(fecha, region, dependencia, tipoBorrado, observaciones, tipoDictamen, descripcion, idPersonal, numeroInventario);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of generarReporteMantinimiento method, of class DictamenMantenimiento.
   */
  @Test
  public void testGenerarReporteMantinimiento() throws Exception {
    System.out.println("generarReporteMantinimiento");
    DictamenMantenimiento instance = new DictamenMantenimiento();
    List<DictamenMantenimiento> expResult = null;
    List<DictamenMantenimiento> result = instance.generarReporteMantinimiento();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }
  
}
