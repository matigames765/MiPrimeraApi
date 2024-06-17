package com.example.miPrimeraApi.controllers;

import com.example.miPrimeraApi.entities.DetallePedido;
import com.example.miPrimeraApi.entities.Empleado;
import com.example.miPrimeraApi.services.BaseService;
import com.example.miPrimeraApi.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController extends BaseController<Empleado,Long>{

    @Autowired
    private EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        super(empleadoService);
    }

    @GetMapping("/sucursal/{id}")
    public ResponseEntity<List<Empleado>> listarPorSucursal(@PathVariable Long idSucursal) throws Exception{
        List<Empleado> empleados = empleadoService.listarPorSucursal(idSucursal);
        return ResponseEntity.ok(empleados);
    }
}
