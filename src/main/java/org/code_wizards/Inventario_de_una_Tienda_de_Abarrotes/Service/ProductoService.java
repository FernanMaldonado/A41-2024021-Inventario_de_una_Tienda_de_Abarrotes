package org.code_wizards.Inventario_de_una_Tienda_de_Abarrotes.Service;
import org.code_wizards.Inventario_de_una_Tienda_de_Abarrotes.Entity.Producto;
import org.code_wizards.Inventario_de_una_Tienda_de_Abarrotes.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService implements IProductoService{
    //Inyecion de Dependencias
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findAll(); // devuelve lo que realmente encontró
    }

    @Override
    public Producto buscarProductoPorId(Integer codigo) {
        return productoRepository.findById(codigo).orElse(null); // devuelve el producto o null si no existe
    }


    @Override
    public void guardarProducto(Producto producto) {
        productoRepository.save(producto);

    }

    @Override
    public void eliminarProducto(Producto producto) {
        productoRepository.delete(producto);
    }
}

