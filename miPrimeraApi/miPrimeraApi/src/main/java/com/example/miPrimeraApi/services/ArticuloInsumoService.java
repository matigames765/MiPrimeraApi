package com.example.miPrimeraApi.services;

import com.example.miPrimeraApi.entities.ArticuloInsumo;
import com.example.miPrimeraApi.entities.ArticuloManufacturado;
import com.example.miPrimeraApi.repositories.ArticuloInsumoRepository;
import com.example.miPrimeraApi.repositories.BaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloInsumoService extends BaseService<ArticuloInsumo,Long>{

    @Autowired
    private ArticuloInsumoRepository articuloInsumoRepository;

    public ArticuloInsumoService(ArticuloInsumoRepository articuloInsumoRepository) {
        super(articuloInsumoRepository);
    }

    @Transactional
    public List<ArticuloInsumo> listarPorCategoria(Long idCategoria) throws Exception{
        try{
            return articuloInsumoRepository.findAllByCategoriaId(idCategoria);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<ArticuloInsumo> listarPorUnidadMedida(Long idUnidadMedida) throws Exception{
        try{
            return articuloInsumoRepository.findAllByUnidadMedidaId(idUnidadMedida);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}
