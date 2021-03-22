package com.example.carritocomprasback.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.carritocomprasback.entity.FechaPromocion;

@Repository
public interface FechaPromocionRepository extends JpaRepository<FechaPromocion, Integer>{

}
