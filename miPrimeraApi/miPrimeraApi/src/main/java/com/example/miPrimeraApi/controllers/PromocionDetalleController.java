package com.example.miPrimeraApi.controllers;

import com.example.miPrimeraApi.entities.DetallePedido;
import com.example.miPrimeraApi.entities.PromocionDetalle;
import com.example.miPrimeraApi.services.BaseService;
import com.example.miPrimeraApi.services.PromocionDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/detalles_promociones")
public class PromocionDetalleController extends BaseController<PromocionDetalle,Long>{

    @Autowired
    private PromocionDetalleService promocionDetalleService;

    public PromocionDetalleController(PromocionDetalleService promocionDetalleService) {
        super(promocionDetalleService);
    }

    @GetMapping("/promocion/{id}")
    public ResponseEntity<List<PromocionDetalle>> listarPorPromocion(@PathVariable Long idPromocion) throws Exception{
        List<PromocionDetalle> promocionDetalles = promocionDetalleService.listarPorPromocion(idPromocion);
        return ResponseEntity.ok(promocionDetalles);
    }

    @GetMapping("/articulo/{id}")
    public ResponseEntity<List<PromocionDetalle>> listarPorArticulo(@PathVariable Long idArticulo) throws Exception{
        List<PromocionDetalle> promocionDetalles = promocionDetalleService.listarPorArticulo(idArticulo);
        return ResponseEntity.ok(promocionDetalles);
    }
}
