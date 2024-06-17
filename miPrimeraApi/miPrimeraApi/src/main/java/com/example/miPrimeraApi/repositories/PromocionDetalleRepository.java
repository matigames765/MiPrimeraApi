package com.example.miPrimeraApi.repositories;

import com.example.miPrimeraApi.entities.PromocionDetalle;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromocionDetalleRepository extends BaseRepository<PromocionDetalle,Long>{

    List<PromocionDetalle> findAllByPromocion_Id(Long idPromocion);

    List<PromocionDetalle> findAllByArticulo_Id(Long idArticulo);
}
