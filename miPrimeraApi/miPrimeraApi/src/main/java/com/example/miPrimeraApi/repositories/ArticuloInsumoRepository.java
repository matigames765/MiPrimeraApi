package com.example.miPrimeraApi.repositories;

import com.example.miPrimeraApi.entities.ArticuloInsumo;
import com.example.miPrimeraApi.entities.Categoria;
import com.example.miPrimeraApi.entities.UnidadMedida;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloInsumoRepository extends BaseRepository<ArticuloInsumo,Long>{

    List<ArticuloInsumo> findAllByCategoria_Id(Long idCategoria);

    List<ArticuloInsumo> findAllByUnidadMedida_Id(Long idUnidadMedida);
}
