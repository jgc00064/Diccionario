package com.example.Diccionario_ingles_espanol.Espanol.Infraestructure.DTO;

import com.example.Diccionario_ingles_espanol.Ingles.Domain.Ingles;
import com.example.Diccionario_ingles_espanol.Ingles.Infraestructure.DTO.InglesOutputDto;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;

import java.util.Date;
import java.util.List;


@Data

public class EspanolOutputDto{


    private int id;

    private String palabra;

    private String descripcion;

    private Date fecha_alta;

    private Date fecha_modif;

    private List<Ingles> Ingles;


}
