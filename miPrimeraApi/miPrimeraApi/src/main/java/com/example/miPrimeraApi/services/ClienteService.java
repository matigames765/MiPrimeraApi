package com.example.miPrimeraApi.services;

import com.example.miPrimeraApi.entities.Cliente;
import com.example.miPrimeraApi.entities.Domicilio;
import com.example.miPrimeraApi.repositories.BaseRepository;
import com.example.miPrimeraApi.repositories.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService extends BaseService<Cliente, Long>{

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        super(clienteRepository);
    }

    @Transactional
    public List<Domicilio> listarDomiciliosPorCliente(Long idCliente) throws Exception{
        try{
            Cliente cliente = clienteRepository.findById(idCliente).orElse(null);
            return new ArrayList<>(cliente.getDomicilios());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
