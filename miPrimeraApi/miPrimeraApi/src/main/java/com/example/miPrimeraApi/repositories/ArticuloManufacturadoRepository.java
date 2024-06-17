package com.example.miPrimeraApi.repositories;

import com.example.miPrimeraApi.entities.ArticuloInsumo;
import com.example.miPrimeraApi.entities.ArticuloManufacturado;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloManufacturadoRepository extends BaseRepository<ArticuloManufacturado,Long>{

    List<ArticuloManufacturado> findAllByCategoria_Id(Long idCategoria);

    List<ArticuloManufacturado> findAllByUnidadMedida_Id(Long idUnidadMedida);
}
