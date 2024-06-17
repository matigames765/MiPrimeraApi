package com.example.miPrimeraApi.services;

import com.example.miPrimeraApi.entities.Empresa;
import com.example.miPrimeraApi.repositories.BaseRepository;
import com.example.miPrimeraApi.repositories.EmpresaRepository;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService extends BaseService<Empresa,Long>{

    public EmpresaService(EmpresaRepository empresaRepository) {
        super(empresaRepository);
    }
}
