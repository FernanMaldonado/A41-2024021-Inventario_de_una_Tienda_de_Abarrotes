package org.code_wizards.Inventario_de_una_Tienda_de_Abarrotes.Repository;

import org.code_wizards.Inventario_de_una_Tienda_de_Abarrotes.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer> {
    Optional<Cliente> findByCorreoAndContrasena(String correo, String contrasena);
}
