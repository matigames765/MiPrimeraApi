package com.example.miPrimeraApi.repositories;

import com.example.miPrimeraApi.entities.Categoria;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface CategoriaRepository extends BaseRepository<Categoria,Long>{

    List<Categoria> findAllByCategoriaPadreId(Long idCategoriaPadre);
}
