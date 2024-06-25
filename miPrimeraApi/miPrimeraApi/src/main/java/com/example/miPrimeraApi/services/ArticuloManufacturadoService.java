package com.example.miPrimeraApi.services;

import com.example.miPrimeraApi.entities.ArticuloInsumo;
import com.example.miPrimeraApi.entities.ArticuloManufacturado;
import com.example.miPrimeraApi.repositories.ArticuloManufacturadoDetalleRepository;
import com.example.miPrimeraApi.repositories.ArticuloManufacturadoRepository;
import com.example.miPrimeraApi.repositories.BaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloManufacturadoService extends BaseService<ArticuloManufacturado,Long>{

    @Autowired
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;

    public ArticuloManufacturadoService(ArticuloManufacturadoRepository articuloManufacturadoRepository) {
        super(articuloManufacturadoRepository);
    }

    @Transactional
    public List<ArticuloManufacturado> listarPorCategoria(Long idCategoria) throws Exception{
        try{
            return articuloManufacturadoRepository.findAllByCategoriaId(idCategoria);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<ArticuloManufacturado> listarPorUnidadMedida(Long idUnidadMedida) throws Exception{
        try{
            return articuloManufacturadoRepository.findAllByUnidadMedidaId(idUnidadMedida);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
