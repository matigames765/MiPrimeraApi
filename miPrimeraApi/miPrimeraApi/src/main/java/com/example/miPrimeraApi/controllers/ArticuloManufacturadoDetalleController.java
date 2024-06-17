package com.example.miPrimeraApi.controllers;

import com.example.miPrimeraApi.entities.ArticuloManufacturadoDetalle;
import com.example.miPrimeraApi.services.ArticuloManufacturadoDetalleService;
import com.example.miPrimeraApi.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/articulos_manufacturados_detalles")
public class ArticuloManufacturadoDetalleController extends BaseController<ArticuloManufacturadoDetalle,Long>{

    @Autowired
    private ArticuloManufacturadoDetalleService articuloManufacturadoDetalleService;

    public ArticuloManufacturadoDetalleController(ArticuloManufacturadoDetalleService articuloManufacturadoDetalleService) {
        super(articuloManufacturadoDetalleService);
    }

    @GetMapping("/articulo_manufacturado/{id}")
    public ResponseEntity<List<ArticuloManufacturadoDetalle>> listarPorArticuloManufacturado(@PathVariable Long idArticuloManufacturado) throws Exception{
        List<ArticuloManufacturadoDetalle> articulosManufacturadoDetalles = articuloManufacturadoDetalleService.listarPorArticuloManufacturado(idArticuloManufacturado);
        return ResponseEntity.ok(articulosManufacturadoDetalles);
    }

    @GetMapping("/articulo_insumo/{id}")
    public ResponseEntity<List<ArticuloManufacturadoDetalle>> listarPorArticuloInsumo(@PathVariable Long idArticuloInsumo) throws Exception{
        List<ArticuloManufacturadoDetalle> articulosManufacturadoDetalles = articuloManufacturadoDetalleService.listarPorArticuloInsumo(idArticuloInsumo);
        return ResponseEntity.ok(articulosManufacturadoDetalles);
    }
}
