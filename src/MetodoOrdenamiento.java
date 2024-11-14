import java.util.Arrays;

public class MetodoOrdenamiento {

    // Método para la búsqueda binaria con medición de tiempo
    public void busquedaBinariaConTiempo(int[] arreglo, int valor) {
        long inicioBusqueda = System.nanoTime();
        int resultado = busquedaBinaria(arreglo, valor);
        long finBusqueda = System.nanoTime();
        long duracionBusqueda = finBusqueda - inicioBusqueda;

        if (resultado != -1) {
            System.out.println("Valor encontrado en la posición: " + resultado);
        } else {
            System.out.println("Valor no encontrado.");
        }        
        System.out.println("Tiempo de ejecución de la búsqueda binaria: " + duracionBusqueda + " nanosegundos");
    }

    // Método de búsqueda binaria normal
    public int busquedaBinaria(int[] arreglo, int valor) {
        int izquierda = 0;
        int derecha = arreglo.length - 1;
        
        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            
            if (arreglo[medio] == valor) {
                return medio; // Valor encontrado
            } else if (arreglo[medio] < valor) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        return -1; // Valor no encontrado
    }

    // Método para generar los arreglos de tamaños definidos
    public int[] generarYMostrarArreglos() {
        int[] arregloBase = generarArreglo(30000); // Generar el arreglo de tamaño 30000
        System.out.println("Arreglo de tamaño 30000: " + Arrays.toString(arregloBase));
        
        // Mostrar los primeros 10 elementos del arreglo
        System.out.println("Arreglo de tamaño 10: " + Arrays.toString(Arrays.copyOf(arregloBase, 10)));
        
        // Mostrar los primeros 100 elementos
        System.out.println("Arreglo de tamaño 100: " + Arrays.toString(Arrays.copyOf(arregloBase, 100)));
        
        // Mostrar los primeros 1000 elementos
        System.out.println("Arreglo de tamaño 1000: " + Arrays.toString(Arrays.copyOf(arregloBase, 1000)));
        
        return arregloBase; // Retornar el arreglo principal para ser utilizado en otras operaciones
    }

    // Método para generar un arreglo aleatorio
    public int[] generarArreglo(int tamano) {
        int[] arreglo = new int[tamano];
        for (int i = 0; i < tamano; i++) {
            arreglo[i] = (int)(Math.random() * 30000) + 1; // Valores entre 1 y 30000
        }
        return arreglo;
    }

    // Métodos de ordenamiento
    public void sortBubbleTradicional(int[] arregloCopia, boolean ascendente) {
        int tamanio = arregloCopia.length;
     
            for (int i = 0; i < tamanio - 1; i++) {
                for (int j = 0; j < tamanio - 1; j++) {
                    if (ascendente ? arregloCopia[j] > arregloCopia[j + 1] : arregloCopia[j] < arregloCopia[j + 1]) {  
                        int aux = arregloCopia[j];
                        arregloCopia[j] = arregloCopia[j + 1];
                        arregloCopia[j + 1] = aux;
                    }
                }
                System.out.println(Arrays.toString(arregloCopia));
            } 
        
    }

    public void sortBySeleccion(int[] arregloCopia, boolean ascendente) { 
        int tamanio = arregloCopia.length;
 
            for (int i = 0; i < tamanio; i++) {
                int indice = i;
                for (int j = i + 1; j < tamanio; j++) {
                    if (ascendente ? arregloCopia[j] < arregloCopia[indice] : arregloCopia[j] > arregloCopia[indice]) {
                        indice = j;                       
                    }     
                }
                if (indice != i) {
                    int aux = arregloCopia[indice];
                    arregloCopia[indice] = arregloCopia[i];
                    arregloCopia[i] = aux;      
                }
                System.out.println(Arrays.toString(arregloCopia));
            }
        
    }
    
    public void sortInsercion(int[] arregloCopia, boolean ascendente) {
        int tamanio = arregloCopia.length;
       
            for (int i = 1; i < tamanio; i++) {
                int aux = arregloCopia[i];
                int j = i - 1;
                while (j >= 0 && (ascendente ? arregloCopia[j] > aux : arregloCopia[j] < aux)) {
                    arregloCopia[j + 1] = arregloCopia[j];
                    j--;
                    System.out.println(Arrays.toString(arregloCopia));
                }
                arregloCopia[j + 1] = aux;
                System.out.println(Arrays.toString(arregloCopia));
            }
        
    }

    public void sortBubbleAvanzado(int[] arregloCopia, boolean ascendente) {
        int tamanio = arregloCopia.length;
            for (int i = 0; i < tamanio; i++) {
                boolean intercambio = false;
                for (int j = 0; j < tamanio - 1 - i; j++) {
                    if (ascendente ? arregloCopia[j] > arregloCopia[j + 1] : arregloCopia[j] < arregloCopia[j + 1]) {
                        int aux = arregloCopia[j];
                        arregloCopia[j] = arregloCopia[j + 1];
                        arregloCopia[j + 1] = aux;
                        intercambio = true;
                    } 
                    System.out.println(Arrays.toString(arregloCopia));
                }
                if (!intercambio) {
                    break;
                }          
            }
    }  

    // Método que ordena los arreglos y mide el tiempo de ejecución
    public void generarYOrdenarArreglos(int[] arreglo) {
        long inicio = System.nanoTime();
        
        // Ordenar usando los distintos métodos
        sortBubbleTradicional(arreglo, true, false);
        sortBySeleccion(arreglo, true, false);
        sortInsercion(arreglo, true, false);
        sortBubbleAvanzado(arreglo, true, false);

        long fin = System.nanoTime();
        long duracion = fin - inicio;
        System.out.println("Tiempo total de ejecución para los 4 métodos de ordenamiento: " + duracion + " nanosegundos");
    }
}