package com.example.miPrimeraApi.repositories;

import com.example.miPrimeraApi.entities.DetallePedido;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetallePedidoRepository extends BaseRepository<DetallePedido,Long>{

    List<DetallePedido> findAllByPedido_Id(Long idPedido);

    List<DetallePedido> findAllByArticulo_Id(Long articulo);
}
