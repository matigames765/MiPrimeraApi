package com.example.miPrimeraApi.services;

import com.example.miPrimeraApi.entities.Factura;
import com.example.miPrimeraApi.repositories.BaseRepository;
import com.example.miPrimeraApi.repositories.FacturaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaService extends BaseService<Factura,Long>{

    @Autowired
    private FacturaRepository facturaRepository;

    public FacturaService(FacturaRepository facturaRepository) {
        super(facturaRepository);
    }

}
