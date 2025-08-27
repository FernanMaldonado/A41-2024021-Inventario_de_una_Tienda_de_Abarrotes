package org.code_wizards.Inventario_de_una_Tienda_de_Abarrotes.Service;

import org.code_wizards.Inventario_de_una_Tienda_de_Abarrotes.Entity.Cliente;

import java.util.List;

public interface IClienteService {
    List<Cliente> listarClientes();
    void guardarCliente(Cliente cliente);
    Cliente login(String email, String contrasena);
}
