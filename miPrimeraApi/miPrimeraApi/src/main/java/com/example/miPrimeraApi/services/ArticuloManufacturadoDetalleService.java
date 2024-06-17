package com.example.miPrimeraApi.services;

import com.example.miPrimeraApi.entities.ArticuloManufacturadoDetalle;
import com.example.miPrimeraApi.repositories.ArticuloManufacturadoDetalleRepository;
import com.example.miPrimeraApi.repositories.BaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloManufacturadoDetalleService extends BaseService<ArticuloManufacturadoDetalle,Long>{

    @Autowired
    private ArticuloManufacturadoDetalleRepository articuloManufacturadoDetalleRepository;

    public ArticuloManufacturadoDetalleService(ArticuloManufacturadoDetalleRepository articuloManufacturadoDetalleRepository) {
        super(articuloManufacturadoDetalleRepository);
    }

    @Transactional
    public List<ArticuloManufacturadoDetalle> listarPorArticuloManufacturado(Long idArticuloManufacturado) throws Exception{
        try{
            return articuloManufacturadoDetalleRepository.findAllByArticuloManufacturado_Id(idArticuloManufacturado);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<ArticuloManufacturadoDetalle> listarPorArticuloInsumo(Long idArticuloInsumo) throws Exception{
        try{
            return articuloManufacturadoDetalleRepository.findAllByArticuloInsumo_Id(idArticuloInsumo);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
