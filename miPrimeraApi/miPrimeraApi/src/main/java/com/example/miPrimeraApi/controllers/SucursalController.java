package com.example.miPrimeraApi.controllers;

import com.example.miPrimeraApi.entities.Categoria;
import com.example.miPrimeraApi.entities.Promocion;
import com.example.miPrimeraApi.entities.PromocionDetalle;
import com.example.miPrimeraApi.entities.Sucursal;
import com.example.miPrimeraApi.services.BaseService;
import com.example.miPrimeraApi.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sucursales")
public class SucursalController extends BaseController<Sucursal,Long>{

    @Autowired
    private SucursalService sucursalService;

    public SucursalController(SucursalService sucursalService) {
        super(sucursalService);
    }

    @GetMapping("/empresa/{id}")
    public ResponseEntity<List<Sucursal>> listarPorEmpresa(@PathVariable Long idEmpresa) throws Exception{
        List<Sucursal> sucursales = sucursalService.listarPorEmpresa(idEmpresa);
        return ResponseEntity.ok(sucursales);
    }

    @GetMapping("/promocion/{id}")
    public ResponseEntity<List<Promocion>> listarPromocionesPorSucursal(@PathVariable Long idSucursal) throws Exception{
        List<Promocion> promociones = sucursalService.listarPromocionesPorSucursal(idSucursal);
        return ResponseEntity.ok(promociones);
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<List<Categoria>> listarCategoriasPorSucursal(@PathVariable Long idSucursal) throws Exception{
        List<Categoria> categorias = sucursalService.listarCategoriasPorSucursal(idSucursal);
        return ResponseEntity.ok(categorias);
    }


}
