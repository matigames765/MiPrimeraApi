package com.example.miPrimeraApi.services;

import com.example.miPrimeraApi.entities.Usuario;
import com.example.miPrimeraApi.repositories.BaseRepository;
import com.example.miPrimeraApi.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends BaseService<Usuario,Long>{

    public UsuarioService(UsuarioRepository usuarioRepository) {
        super(usuarioRepository);
    }
}
