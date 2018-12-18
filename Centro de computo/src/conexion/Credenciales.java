/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conexion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Contiene los datos para poderrealizar una conexión con la base de datos.
 *
 * @author PREDATOR 15 G9-78Q
 */
class Credenciales {

  private static String usuario;
  private static String contrasenia;
  private static String baseDatos;
  private static String host;
  private static int port;

  public static String getCredencialUno() {
    return Credenciales.usuario;
  }

  public static String getCredencialDos() {
    return Credenciales.contrasenia;
  }

  public static String getCredencialTres() {
    return Credenciales.baseDatos;
  }

  public static String getCredencialCuatro() {
    return Credenciales.host;
  }

  public static int getCredencialCinco() {
    return Credenciales.port;
  }

  public static void iniciarCredenciales() throws SQLException {
    Credenciales.muestraContenido("encryp.txt");

  }

  private static void muestraContenido(String archivo) throws SQLException {

    try (FileReader file = new FileReader(archivo);
        BufferedReader b = new BufferedReader(file)) {

      Credenciales.usuario = b.readLine();
      Credenciales.contrasenia = b.readLine();
      Credenciales.baseDatos = b.readLine();
      Credenciales.host = b.readLine();
      int puerto = Integer.parseInt(b.readLine());
      Credenciales.port = puerto;

      b.close();

    } catch (FileNotFoundException ex) {
      throw new SQLException();
    } catch (IOException ex) {
      throw new SQLException();
    }

  }

  
  
  
  
}