package com.example.miPrimeraApi.repositories;

import com.example.miPrimeraApi.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends BaseRepository<Empleado, Long> {

    List<Empleado> findAllBySucursal_Id(Long idSucursal);
}
