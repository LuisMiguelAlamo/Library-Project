/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyconect.model;

/**
 *
 * @author Luis Miguel Alamo Hernández
 */
public class DtoAlumno {

    private String dni;
    private int NumeroRegistro;
    private String Nombre;
    private String apellido1;
    private String apellido2;

    
    public DtoAlumno() {
    }

    public DtoAlumno(String dni, int NumeroRegistro, String Nombre, String apellido1, String apellido2) {
        this.dni = dni;
        this.NumeroRegistro = NumeroRegistro;
        this.Nombre = Nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    

    public int getNumeroRegistro() {
        return NumeroRegistro;
    }

    public void setNumeroRegistro(int NumeroRegistro) {
        this.NumeroRegistro = NumeroRegistro;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

}
