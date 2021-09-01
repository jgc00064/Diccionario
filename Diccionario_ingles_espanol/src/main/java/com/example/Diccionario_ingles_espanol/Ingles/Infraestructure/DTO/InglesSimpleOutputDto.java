package com.example.Diccionario_ingles_espanol.Ingles.Infraestructure.DTO;

import com.example.Diccionario_ingles_espanol.Espanol.Domain.Espanol;
import lombok.Data;

import java.util.Date;

@Data
public class InglesSimpleOutputDto{

    int id;

    String palabra;

    Date fecha_alta;

    Date fecha_modif;

    Espanol espanol;


}
