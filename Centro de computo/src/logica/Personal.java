package logica;

/**
 * Contiene métodos para administrar al personal.
 * @author marai
 */

public class Personal {
  private int idPersonal;
  private String nombre;
  private String correo;
  private String telefono;
  private String puesto;
  private String contrasenia;

  public Personal(int idPersonal, String nombre, String correo, String telefono, String puesto, String contrasenia) {
    this.idPersonal = idPersonal;
    this.nombre = nombre;
    this.correo = correo;
    this.telefono = telefono;
    this.puesto = puesto;
    this.contrasenia = contrasenia;
  }

  public Personal(String idPersonal, String contrasenia) {
    this.idPersonal = Integer.parseInt(idPersonal);
    this.contrasenia = contrasenia;
  }

  public int getIdPersonal() {
    return idPersonal;
  }

  public String getNombre() {
    return nombre;
  }

  public String getCorreo() {
    return correo;
  }

  public String getTelefono() {
    return telefono;
  }

  public String getPuesto() {
    return puesto;
  }

  public String getContrasenia() {
    return contrasenia;
  }
  
}
