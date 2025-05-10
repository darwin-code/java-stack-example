package pilastoapanta_ejemplo5;

import java.util.Stack;

public class PilasToapanta_Ejemplo5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear una pila para almacenar productos
        Stack<Pila> pilaProductos = new Stack<>();

        // Agregar algunos productos a la pila
        agregarProducto(pilaProductos, "Laptop", 1200);
        agregarProducto(pilaProductos, "Telefono movil", 800);
        agregarProducto(pilaProductos, "Tableta", 500);
        agregarProducto(pilaProductos, "Auriculares", 100);

        // Mostrar los productos antes del ordenamiento
        System.out.println("-----------------------------------------");
        System.out.println("Productos antes del ordenamiento:");
        mostrarProductos(pilaProductos);

        // Ordenar los productos por precio utilizando el algoritmo de inserción
        ordenarProductosPorPrecio(pilaProductos);

        // Mostrar los productos después del ordenamiento
        System.out.println("-----------------------------------------");
        System.out.println("\nProductos despues del ordenamiento:");
        mostrarProductos(pilaProductos);

        // Buscar un producto por nombre
        System.out.println("-----------------------------------------");
        String nombreProductoABuscar = "Tableta";
        Pila productoEncontrado = buscarProductoPorNombre(pilaProductos, nombreProductoABuscar);
        if (productoEncontrado != null) {
            System.out.println("\nProducto encontrado: " + productoEncontrado.getNombre() + " - Precio: $" + productoEncontrado.getPrecio());
        } else {
            System.out.println("\nNo se encontro el producto: " + nombreProductoABuscar);
        }
        System.out.println("-----------------------------------------");
    }

    public static void agregarProducto(Stack<Pila> pilaProductos, String nombre, double precio) {
        Pila producto = new Pila(nombre, precio);
        pilaProductos.push(producto);
    }

    public static void ordenarProductosPorPrecio(Stack<Pila> pilaProductos) {
        int n = pilaProductos.size();
        Pila[] arrProductos = pilaProductos.toArray(new Pila[n]);

        for (int i = 1; i < n; i++) {
            Pila key = arrProductos[i];
            int j = i - 1;
            while (j >= 0 && arrProductos[j].getPrecio() > key.getPrecio()) {
                arrProductos[j + 1] = arrProductos[j];
                j = j - 1;
            }
            arrProductos[j + 1] = key;
        }

        pilaProductos.clear();
        for (Pila producto : arrProductos) {
            pilaProductos.push(producto);
        }
    }

    public static Pila buscarProductoPorNombre(Stack<Pila> pilaProductos, String nombre) {
        for (Pila producto : pilaProductos) {
            if (producto.getNombre().equals(nombre)) {
                return producto;
            }
        }
        return null;
    }

    public static void mostrarProductos(Stack<Pila> pilaProductos) {
        for (Pila producto : pilaProductos) {
            System.out.println("Nombre: " + producto.getNombre() + ", Precio: $" + producto.getPrecio());
        }
    }

}
