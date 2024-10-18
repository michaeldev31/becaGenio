
package com.mycompany.modelo;

/**
 *
 * @author micha
 */
public class Estudiante implements Cloneable{
    private String nombre;
    private String apellido;
    private String dni;
    private String correo;
    private String contrasena;
    
    // Constructor
    public Estudiante(String nombre, String apellido, String dni, String correo, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    @Override
    public Estudiante clone() throws CloneNotSupportedException{
        return (Estudiante) super.clone();
    }
} 
