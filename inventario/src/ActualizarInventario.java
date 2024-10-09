class ActualizarInventario {
    // Actualiza la información del inventario cuando se vende un producto
    public void actualizarInventario(Producto producto, int cantidadVendida) {
        producto.cantidad -= cantidadVendida;
    }
}