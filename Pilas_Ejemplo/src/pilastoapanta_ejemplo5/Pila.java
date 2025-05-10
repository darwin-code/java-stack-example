package pilastoapanta_ejemplo5;

public class Pila {
    private String nombre;
        private double precio;

        public Pila(String nombre, double precio) {
            this.nombre = nombre;
            this.precio = precio;
        }

        public String getNombre() {
            return nombre;
        }

        public double getPrecio() {
            return precio;
        }
}