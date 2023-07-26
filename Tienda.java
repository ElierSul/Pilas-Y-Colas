import java.util.*;

public class Tienda {
    private static int contadorTicket = 1;
    public static void main(String[] args) {
        Queue<Clientes> colaClientes = new LinkedList<>();
        Queue<Clientes> colaTemp = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int opc;

        do {
            // Mostrar el menú de opciones
            System.out.println("\n--- MENU DE OPCIONES ---\n");
            System.out.println("1. Agregar clientes");
            System.out.println("2. Clientes en la cola");
            System.out.println("3. Atender clientes");
            System.out.println("4. Atender varios clientes");
            System.out.println("0. Salir del programa");
            System.out.print("Ingrese una opción: ");
            opc = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer del scanner

            switch (opc) {
                case 1:
                    System.out.println("\n AGREGANDO CLIENTES A LA COLA \n");
                    System.out.print("Numero de clientes a ingresar: ");
                    int cantidadClientes = sc.nextInt();
                    sc.nextLine(); // Variable para llevar la cuenta del ticket actual

                    for (int i = 0; i < cantidadClientes; i++) {
                        int ticket = contadorTicket;
                        contadorTicket++; // Incrementar el ticket para el próximo cliente

                        System.out.println("Ingrese los datos del cliente #" + (i + 1));
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("Apellido: ");
                        String apellido = sc.nextLine();

                        Clientes cliente = new Clientes(ticket, nombre, apellido);
                        colaClientes.offer(cliente);
                    }
                    break;

                case 2:
                    System.out.println("\n CLIENTES EN LA COLA \n");
                    while (!colaClientes.isEmpty()){
                        colaTemp.offer(colaClientes.poll());
                    }

                    while(!colaTemp.isEmpty()){
                        Clientes clientes = colaTemp.poll();
                        System.out.println(clientes);

                        colaClientes.offer(clientes);
                    }
                    break;

                case 3:
                    System.out.println("\n ATENDER CLIENTE \n");
                    System.out.println("Se atendio al cliente: " + colaClientes.poll());
                    System.out.println("\n Clientes en la cola\n");
                    mostrarCola(colaClientes);
                    break;

                case 4:
                    System.out.println("\n ATENDER VARIOS CLIENTES \n");
                    System.out.println("Ingrese la cantidad de clientes que desea atender en simultaneo");
                    int cantidadAtender = sc.nextInt();
                    sc.nextLine();

                    if (cantidadAtender > colaClientes.size()){
                        System.out.println("El numero de clientes a atender no puede ser mayor a los clientes " +
                                "en la cola.");
                    } else {
                        for (int i = 0; i < cantidadAtender; i++) {
                            System.out.println("Se atendio al cliente: " + colaClientes.poll());
                        }
                    }


                    System.out.println("\n Clientes en la cola");
                    mostrarCola(colaClientes);
                    break;

                case 0:

                    System.out.println("\nSaliendo del programa...");
                    break;

                default:
                    System.out.println("\nOpción inválida. Por favor, ingrese una opción válida.");
            }

        } while (opc != 0);

        sc.close();


    }

    private static void mostrarCola(Queue<Clientes> cola){
        for (Clientes cliente : cola) {
            System.out.println(cliente);
        }
    }
}
