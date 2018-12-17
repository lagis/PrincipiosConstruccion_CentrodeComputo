/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

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
public class EquipoTest {
  Equipo equipo = 
      new Equipo("123456789h", "Predator 15", "123456789h",
      "Laptop", "Acer", "Bodega", "Disponible");
  
  
  
  public EquipoTest() {
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
   * Test of getDisponibilidad method, of class Equipo.
   */
  @Test
  public void testGetDisponibilidad() {
    System.out.println("getDisponibilidad");
    String expResult = "Disponible";
    String result = this.equipo.getDisponibilidad();
    assertEquals(expResult, result);
  }

  /**
   * Test of getIdentificador method, of class Equipo.
   */
  @Test
  public void testGetIdentificador() {
    System.out.println("getIdentificador");
    String expResult = "123456789h";
    String result = this.equipo.getIdentificador();
    assertEquals(expResult, result);
  }

  /**
   * Test of getModelo method, of class Equipo.
   */
  @Test
  public void testGetModelo() {
    System.out.println("getModelo");
    String expResult = "Predator 15";
    String result = this.equipo.getModelo();
    assertEquals(expResult, result);
  }

  /**
   * Test of getNumeroSerie method, of class Equipo.
   */
  @Test
  public void testGetNumeroSerie() {
    System.out.println("getNumeroSerie");
    String expResult = "123456789h";
    String result = this.equipo.getNumeroSerie();
    assertEquals(expResult, result);
  }

  /**
   * Test of getTipoEquipo method, of class Equipo.
   */
  @Test
  public void testGetTipoEquipo() {
    System.out.println("getTipoEquipo");
    String expResult = "Laptop";
    String result = this.equipo.getTipoEquipo();
    assertEquals(expResult, result);
  }

  /**
   * Test of getMarca method, of class Equipo.
   */
  @Test
  public void testGetMarca() {
    System.out.println("getMarca");
    String expResult = "Acer";
    String result = this.equipo.getMarca();
    assertEquals(expResult, result);
  }

  /**
   * Test of getResponsableUbicacion method, of class Equipo.
   */
  @Test
  public void testGetResponsableUbicacion() {
    System.out.println("getResponsableUbicacion");
    String expResult = "Bodega";
    String result = this.equipo.getResponsableUbicacion();
    assertEquals(expResult, result);
  }
  
}
