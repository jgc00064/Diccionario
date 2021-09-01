package com.example.Diccionario_ingles_espanol.Ingles.Infraestructure.DTO;


import com.example.Diccionario_ingles_espanol.Espanol.Domain.Espanol;
import lombok.Data;

import java.util.Date;

@Data
public class InglesOutputDto extends InglesSimpleOutputDto {


    private int id;

    private String palabra;

    private Date fecha_alta;

    private Date fecha_modif;

    private Espanol espanol;

}
