package org.code_wizards.Inventario_de_una_Tienda_de_Abarrotes.Repository;

import org.code_wizards.Inventario_de_una_Tienda_de_Abarrotes.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductoRepository extends JpaRepository <Producto,Integer> {

}

