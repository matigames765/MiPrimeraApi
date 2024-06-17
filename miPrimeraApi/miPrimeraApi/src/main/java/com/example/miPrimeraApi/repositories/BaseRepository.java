package com.example.miPrimeraApi.repositories;

import com.example.miPrimeraApi.entities.Base;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface BaseRepository <E extends Base, ID extends Serializable> extends JpaRepository<E, ID> {
}
