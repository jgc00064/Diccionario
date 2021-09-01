package com.example.Diccionario_ingles_espanol.Ingles.Infraestructure.Repositorio;

import com.example.Diccionario_ingles_espanol.Espanol.Domain.Espanol;
import com.example.Diccionario_ingles_espanol.Ingles.Domain.Ingles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InglesRepositorio extends JpaRepository<Ingles,Integer> {

    List<Ingles> findByPalabra(String palabra);

}
