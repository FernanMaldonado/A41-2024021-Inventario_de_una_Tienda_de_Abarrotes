package org.code_wizards.Inventario_de_una_Tienda_de_Abarrotes.Controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import lombok.Data;
import org.code_wizards.Inventario_de_una_Tienda_de_Abarrotes.Entity.Producto;
import org.code_wizards.Inventario_de_una_Tienda_de_Abarrotes.Service.IProductoService;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.logging.Logger;

@Component
@Data
public class IndexController {

    @Autowired
    private IProductoService productoService;

    private List<Producto> productos;
    private Producto productoSelecionado;

    private static final Logger LOGGER = Logger.getLogger(IndexController.class.getName());

    @PostConstruct
    public void init(){
        cargarDatos();
    }
    public void cargarDatos(){
        this.productos = this.productoService.listarProductos();
        this.productos.forEach(producto -> LOGGER.info(producto.toString()));
    }

    public void agregarProducto(){
        this.productoSelecionado = new Producto();
    }

    public void guardarProducto() {
        boolean esNuevo = (this.productoSelecionado.getIdProducto() == null);
        this.productoService.guardarProducto(this.productoSelecionado);

        if (esNuevo) {
            this.productos.add(this.productoSelecionado);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Producto agregado"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Producto actualizado"));
        }

        PrimeFaces.current().executeScript("PF('ventanaModalProducto').hide()");
        PrimeFaces.current().ajax().update("formulario-productos:mensaje-emergente",
                "formulario-productos:tabla-productos");

        this.productoSelecionado = null;
    }

    public void eliminarProducto() {
        // Verificar si hay un producto seleccionado
        if (this.productoSelecionado == null) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Atención", "Debe seleccionar un producto"));
            return;
        }

        // Log del producto que se eliminará
        LOGGER.info("Producto a eliminar: " + this.productoSelecionado);

        // Llamada al servicio de eliminación (supongo que es un servicio)
        this.productoService.eliminarProducto(this.productoSelecionado);

        // Eliminar el producto de la lista
        this.productos.remove(this.productoSelecionado);

        // Limpiar la selección
        this.productoSelecionado = null;

        // Mostrar mensaje de éxito
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Producto eliminado"));

        // Actualizar la interfaz de usuario con AJAX
        PrimeFaces.current().ajax().update("formulario-productos:mensaje-emergente",
                "formulario-productos:tabla-productos");
    }

}
