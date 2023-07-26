import java.util.Scanner;

public class Usuarios {
    String nombre;
    String apellido;
    String alias;
    public Usuarios(){

    }
    public Usuarios(String nombre, String apellido, String alias) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.alias = alias;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getAlias() {
        return alias;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", alias='" + alias + '\'' +
                '}';
    }
}
