import java.util.ArrayList;

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