import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        MetodoOrdenamiento ordenador = new MetodoOrdenamiento();
        int opcion;
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        // Almacenamos los arreglos generados en el objeto ordenador
        int[] arregloPrincipal = null;

        while (!salir) {
            System.out.println("**MENU**");
            System.out.println("1. Mostrar los arreglos");
            System.out.println("2. Mostrar el tiempo de ejecución de los algoritmos de ordenamiento");
            System.out.println("3. Búsqueda de un valor concreto");
            System.out.println("0. Salir");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    arregloPrincipal = ordenador.generarYMostrarArreglos();
                    break;
                case 2:
                    ordenador.generarYOrdenarArreglos(arregloPrincipal);
                    break;
                case 3:
                    System.out.print("Ingrese el valor a buscar: ");
                    int valor = scanner.nextInt();
                    ordenador.busquedaBinariaConTiempo(arregloPrincipal, valor);
                    break;
                case 0:
                    salir = true;
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("Solo las opciones: 0, 1, 2 y 3");
            }
        }
        scanner.close();
    }
}
