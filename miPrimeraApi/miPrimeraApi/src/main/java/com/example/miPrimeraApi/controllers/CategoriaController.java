package com.example.miPrimeraApi.controllers;

import com.example.miPrimeraApi.entities.Categoria;
import com.example.miPrimeraApi.services.BaseService;
import com.example.miPrimeraApi.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaController extends BaseController<Categoria,Long>{

    @Autowired
    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        super(categoriaService);
    }

    @PostMapping("/{id}/subcategorias")
    public Categoria agregarSubcategoria(@PathVariable Long id, @RequestBody Categoria subcategoria) throws Exception{
        return categoriaService.agregarSubcategoria(id, subcategoria);
    }
}
