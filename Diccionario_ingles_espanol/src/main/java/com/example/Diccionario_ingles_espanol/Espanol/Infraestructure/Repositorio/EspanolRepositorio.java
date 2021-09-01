package com.example.Diccionario_ingles_espanol.Espanol.Infraestructure.Repositorio;

import com.example.Diccionario_ingles_espanol.Espanol.Domain.Espanol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EspanolRepositorio extends JpaRepository<Espanol,Integer> {

    List<Espanol> findByPalabra(String palabra);
    //List<Espanol>findByPalabralista(String palabra);


}
