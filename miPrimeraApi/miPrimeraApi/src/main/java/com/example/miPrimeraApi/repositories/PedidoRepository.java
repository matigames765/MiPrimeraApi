package com.example.miPrimeraApi.repositories;

import com.example.miPrimeraApi.entities.Factura;
import com.example.miPrimeraApi.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido, Long> {

    List<Pedido> findAllByDomicilioId(Long idDomicilio);

    List<Pedido> findAllByEmpleadoId(Long idEmpleado);

    List<Pedido> findAllBySucursalId(Long idSucursal);

    List<Pedido> findAllByClienteId(Long idCliente);

}
