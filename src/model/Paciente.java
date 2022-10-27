package model;

public class Paciente {
    String DNI;
    String nombre;
    String domicilio;
    String mail;
    String sexo;
    int edad;

    public Paciente(String DNI, String nombre, String domicilio, String mail, String sexo, int edad) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.mail = mail;
        this.sexo = sexo;
        this.edad = edad;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
