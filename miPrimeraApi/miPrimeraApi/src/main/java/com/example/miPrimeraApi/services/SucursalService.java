package com.example.miPrimeraApi.services;

import com.example.miPrimeraApi.entities.Categoria;
import com.example.miPrimeraApi.entities.Promocion;
import com.example.miPrimeraApi.entities.Provincia;
import com.example.miPrimeraApi.entities.Sucursal;
import com.example.miPrimeraApi.repositories.BaseRepository;
import com.example.miPrimeraApi.repositories.SucursalRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SucursalService extends BaseService<Sucursal,Long>{

    @Autowired
    private SucursalRepository sucursalRepository;

    public SucursalService(SucursalRepository sucursalRepository) {
        super(sucursalRepository);
    }

    @Transactional
    public List<Sucursal> listarPorEmpresa(Long idEmpresa) throws Exception{
        try{
            return sucursalRepository.findAllByEmpresaId(idEmpresa);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<Categoria> listarCategoriasPorSucursal(Long idSucursal) throws Exception{
        try{
            Sucursal sucursal = sucursalRepository.findById(idSucursal).orElse(null);
            return new ArrayList<>(sucursal.getCategorias());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<Promocion> listarPromocionesPorSucursal(Long idSucursal) throws Exception{
        try{
            Sucursal sucursal = sucursalRepository.findById(idSucursal).orElse(null);
            return new ArrayList<>(sucursal.getPromociones());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
