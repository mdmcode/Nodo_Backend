import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*
        Desarrolla un sistema para gestionar el inventario de una tienda.
        El sistema debe permitir agregar productos con su nombre, precio,
        cantidad disponible, y categoría.
        Además, debe actualizar el inventario cada vez que se realice una venta,
        y permitir consultar productos por categorías o precios.
         */
        // Creamos el inventario como un ArrayList de productos
        ArrayList<Producto> inventario = new ArrayList<>();

        // Productos de prueba
        Producto producto1 = new Producto("Camisa", 100.0, 10, "Ropa");
        Producto producto2 = new Producto("Pantalón", 200.0, 5, "Ropa");
        Producto producto3 = new Producto("Zapatos", 300.0, 3, "Calzado");

        // Agregamos los productos al inventario
        inventario.add(producto1);
        inventario.add(producto2);
        inventario.add(producto3);

        // Actualizamos el inventario si se vende un producto
        ActualizarInventario actualizarInventario = new ActualizarInventario();
        actualizarInventario.actualizarInventario(producto1, 2);

        // Mostramos la cantidad de productos restantes
        System.out.println("Cantidad de camisas restantes: " + producto1.cantidad);
        System.out.println("Cantidad de pantalones restantes: " + producto2.cantidad);
        System.out.println("Cantidad de zapatos restantes: " + producto3.cantidad);

        // Mostramos productos de la categoría "Ropa"
        BuscarProducto buscarProducto = new BuscarProducto();

        System.out.println("\nProductos de la categoría Ropa:");
        buscarProducto.buscarPorCategoria(inventario, "Ropa");

        // Mostramos productos con precio 200.0
        System.out.println("\nProductos con precio 200.0:");
        buscarProducto.buscarPorPrecio(inventario, 200.0);

        // Mostramos todos los productos del inventario con su información
        for (Producto producto : inventario) {
            System.out.println("\nNombre: " + producto.nombre);
            System.out.println("Precio: " + producto.precio);
            System.out.println("Cantidad: " + producto.cantidad);
            System.out.println("Categoría: " + producto.category);
            System.out.println();
        }
    }
}

class Producto {
    // Atributos
    String nombre;
    double precio;
    int cantidad;
    String category;

    // Constructor
    public Producto(String nombre, double precio, int cantidad, String category) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.category = category;
    }
}

class ActualizarInventario {
    // Actualiza la información del inventario cuando se vende un producto
    public void actualizarInventario(Producto producto, int cantidadVendida) {
        producto.cantidad -= cantidadVendida;
    }
}

class BuscarProducto {
    // Busca un producto por categoría
    public void buscarPorCategoria(ArrayList<Producto> inventario, String categoria) {
        // Recorremos el inventario
        for (Producto producto : inventario) {
            // Si el producto pertenece a la categoria buscada, mostramos su información
            if (producto.category.equals(categoria)) {
                System.out.println("Nombre: " + producto.nombre);
                System.out.println("Precio: " + producto.precio);
                System.out.println("Cantidad: " + producto.cantidad);
                System.out.println("Categoría: " + producto.category);
                System.out.println();
            }
        }
    }

    // Busca un producto por precio
    public void buscarPorPrecio(ArrayList<Producto> inventario, double precio) {
        // Recorremos el inventario
        for (Producto producto : inventario) {
            // Si el producto tiene el precio buscado, mostramos su información
            if (producto.precio == precio) {
                System.out.println("Nombre: " + producto.nombre);
                System.out.println("Precio: " + producto.precio);
                System.out.println("Cantidad: " + producto.cantidad);
                System.out.println("Categoría: " + producto.category);
                System.out.println();
            }
        }
    }
}