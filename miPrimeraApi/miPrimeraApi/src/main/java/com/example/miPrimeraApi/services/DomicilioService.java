package com.example.miPrimeraApi.services;

import com.example.miPrimeraApi.entities.Domicilio;
import com.example.miPrimeraApi.repositories.BaseRepository;
import com.example.miPrimeraApi.repositories.DomicilioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomicilioService extends BaseService<Domicilio,Long>{

    @Autowired
    private DomicilioRepository domicilioRepository;

    public DomicilioService(DomicilioRepository domicilioRepository) {
        super(domicilioRepository);
    }

    @Transactional
    public List<Domicilio> listarPorLocalidad(Long idLocalidad) throws Exception{
        try{
            return domicilioRepository.findAllByLocalidad_Id(idLocalidad);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
