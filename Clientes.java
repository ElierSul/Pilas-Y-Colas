public class Clientes {
    int ticket;
    String nombre;
    String apellido;

    public Clientes(int ticket, String nombre, String apellido) {
        this.ticket = ticket;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getTicket() {
        return ticket;
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "ticket=" + ticket +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
