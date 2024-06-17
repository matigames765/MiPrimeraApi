package com.example.miPrimeraApi.controllers;

import com.example.miPrimeraApi.entities.ArticuloManufacturado;
import com.example.miPrimeraApi.services.ArticuloManufacturadoService;
import com.example.miPrimeraApi.services.BaseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/articulos_manufacturados")
public class ArticuloManufacturadoController extends BaseController<ArticuloManufacturado,Long>{

    @Autowired
    private ArticuloManufacturadoService articuloManufacturadoService;

    public ArticuloManufacturadoController(ArticuloManufacturadoService articuloManufacturadoService) {
        super(articuloManufacturadoService);
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<List<ArticuloManufacturado>> listarPorCategoria(@PathVariable Long idCategoria) throws Exception{
        List<ArticuloManufacturado> articulosManufacturados = articuloManufacturadoService.listarPorCategoria(idCategoria);
        return ResponseEntity.ok(articulosManufacturados);
    }

    @GetMapping("/unidad_medida/{id}")
    public ResponseEntity<List<ArticuloManufacturado>> listarPorUnidadMedida(@PathVariable Long idUnidadMedida) throws Exception{
        List<ArticuloManufacturado> articulosManufacturados = articuloManufacturadoService.listarPorUnidadMedida(idUnidadMedida);
        return ResponseEntity.ok(articulosManufacturados);
    }
}
