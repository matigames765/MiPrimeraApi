package com.example.miPrimeraApi.controllers;


import com.example.miPrimeraApi.entities.Base;
import com.example.miPrimeraApi.services.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseController<E extends Base, ID extends Serializable> {

    protected BaseService<E, ID> baseService;

    public BaseController(BaseService<E, ID> baseService){
        this.baseService = baseService;
    }

    @GetMapping
    public ResponseEntity<List<E>> listar() throws Exception{
        List<E> entities = baseService.listar();
        return ResponseEntity.ok(entities);
    }

    @GetMapping("/{id}")
    public Optional<E> buscarPorId(@PathVariable ID id) throws Exception{
        return baseService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<E> crear(@RequestBody E entity) throws Exception{
        E entidadCreada = baseService.crear(entity);
        return ResponseEntity.ok(entidadCreada);
    }

    @PutMapping
    public ResponseEntity<E> actualizar(@RequestBody E entity) throws Exception{
        E entidadAct = baseService.actualizar(entity);
        return ResponseEntity.ok(entidadAct);
    }

    @DeleteMapping
    public void eliminar(@PathVariable ID id) throws Exception{
        baseService.eliminar(id);
    }
}
