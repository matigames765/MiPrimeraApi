package com.example.miPrimeraApi.services;

import com.example.miPrimeraApi.entities.Localidad;
import com.example.miPrimeraApi.repositories.BaseRepository;
import com.example.miPrimeraApi.repositories.LocalidadRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalidadService extends BaseService<Localidad,Long>{

    @Autowired
    private LocalidadRepository localidadRepository;

    public LocalidadService(LocalidadRepository localidadRepository) {
        super(localidadRepository);
    }

    @Transactional
    public List<Localidad> listarPorProvincia(Long idProvincia) throws Exception{
        try{
            return localidadRepository.findAllByProvinciaId(idProvincia);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
