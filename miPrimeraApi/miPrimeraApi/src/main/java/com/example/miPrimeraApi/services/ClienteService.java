package com.example.miPrimeraApi.services;

import com.example.miPrimeraApi.entities.Cliente;
import com.example.miPrimeraApi.repositories.BaseRepository;
import com.example.miPrimeraApi.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService extends BaseService<Cliente, Long>{

    public ClienteService(ClienteRepository clienteRepository) {
        super(clienteRepository);
    }
}
