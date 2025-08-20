package org.code_wizards.Inventario_de_una_Tienda_de_Abarrotes.Service;
import org.code_wizards.Inventario_de_una_Tienda_de_Abarrotes.Entity.Producto;
import java.util.List;

public interface IProductoService {
    public List<Producto> listarProductos();
    public Producto buscarProductoPorId(Integer codigo);
    public void guardarProducto(Producto producto);
    public void eliminarProducto(Producto producto);
}
