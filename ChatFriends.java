import java.util.Scanner;
import java.util.Stack;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ChatFriends {

    public static void main(String[] args) {

        Stack<Usuarios> pilaUsuarios = new Stack<>();
        Stack<Usuarios> pilaTemp = new Stack<>();
        Stack<String> pilaAux = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int opc;
        sc.nextLine();

        do{
            System.out.println("\n MENU DE OPCIONES \n" +
                    "1. Agregar usuarios al chat\n" +
                    "2. Ver usuarios en la pila\n" +
                    "3. Eliminar un usuario del chat\n" +
                    "4. Eliminar multiples usuarios del chat\n" +
                    "0. Salir");
            opc = sc.nextInt();
            sc.nextLine();


            switch (opc){

                case 1:
                    System.out.println("\n AGREGANDO USUARIOS AL CHAT \n");
                    System.out.println("Numero de usuarios a ingresar: ");
                    int cantidadUsuarios = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < cantidadUsuarios; i++) {
                        System.out.println("\n Ingrese los datos del usuario: " + (i+1));
                        System.out.println("Nombre: ");
                        String nombres = sc.nextLine();
                        System.out.println("Apellidos: ");
                        String apellidos = sc.nextLine();
                        System.out.println("Alias: ");
                        String aliass = sc.nextLine();

                        Usuarios usuarios = new Usuarios(nombres, apellidos, aliass);
                        pilaUsuarios.push(usuarios);
                    }

                    break;

                case 2:
                    System.out.println("\n USUARIOS EN EL CHAT \n");
                    while (!pilaUsuarios.isEmpty()){
                        pilaTemp.push(pilaUsuarios.pop());
                    }

                    while(!pilaTemp.isEmpty()){
                        Usuarios usuarios = pilaTemp.pop();
                        System.out.println(usuarios);

                        pilaUsuarios.push(usuarios);
                    }
                    break;

                case 3:
                    System.out.println("\n ELIMINAR USUARIO DEL CHAT \n");
                    System.out.println("Se elimino correctamente a: " +pilaUsuarios.pop());
                    break;

                case 4:
                    System.out.println("\n ELIMINANDO MULTIPLES USUARIOS \n");
                    System.out.println("Ingrese la cantidad de usuarios que desea eliminar \n");
                    int cantidad = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < cantidad; i++) {
                        System.out.println("Alias: " + (i+1));
                        String aliasEliminar = sc.nextLine();

                        while (!pilaUsuarios.isEmpty()) {
                            Usuarios usuarioActual = pilaUsuarios.pop();
                            if (!usuarioActual.getAlias().equalsIgnoreCase(aliasEliminar)) {
                                pilaTemp.push(usuarioActual);
                            }
                        }

                        // Restaurar usuarios no coincidentes a pilaUsuarios y mostrar la pila
                        while (!pilaTemp.isEmpty()) {
                            pilaUsuarios.push(pilaTemp.pop());
                        }

                        // Mostrar la pila después de la eliminación
                        System.out.println("\nUsuarios en la pila después de la eliminación: \n");
                        mostrarPila(pilaUsuarios);
                    }
                    break;

                case 0:
                    System.out.println("\n SALIENDO DEL SISTEMA \n");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }
        }while(opc != 0);
        sc.close();
    }

    private static void mostrarPila(Stack<Usuarios> pila){
        for (Usuarios usuario : pila) {
            System.out.println(usuario);
        }
    }

}