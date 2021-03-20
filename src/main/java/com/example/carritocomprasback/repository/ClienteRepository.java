package com.example.carritocomprasback.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.carritocomprasback.entity.Cliente;
import com.example.carritocomprasback.entity.Producto;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
