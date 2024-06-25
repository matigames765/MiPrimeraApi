package com.example.miPrimeraApi.services;

import com.example.miPrimeraApi.entities.Categoria;
import com.example.miPrimeraApi.repositories.BaseRepository;
import com.example.miPrimeraApi.repositories.CategoriaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService extends BaseService<Categoria,Long>{

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaService( CategoriaRepository categoriaRepository) {
        super(categoriaRepository);
    }

    @Transactional
    public Categoria agregarSubcategoria(Long idCategoriaPadre, Categoria nuevaSubcategoria) throws Exception{
        try{
            Categoria categoriaPadre = categoriaRepository.findById(idCategoriaPadre).orElse(null);

            if(categoriaPadre != null){
                nuevaSubcategoria.setCategoriaPadre(categoriaPadre);

                categoriaRepository.save(nuevaSubcategoria);

                return nuevaSubcategoria;
            }else{
                return null;
            }
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Transactional
    public List<Categoria> listarPorCategoriaPadre(Long idCategoriaPadre) throws Exception{
        try{
            return categoriaRepository.findAllByCategoriaPadreId(idCategoriaPadre);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
