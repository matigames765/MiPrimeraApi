package com.example.miPrimeraApi.repositories;

import com.example.miPrimeraApi.entities.Base;
import com.example.miPrimeraApi.entities.Provincia;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinciaRepository extends BaseRepository<Provincia, Long>{

    List<Provincia> findAllByPaisId(Long idPais);

}
