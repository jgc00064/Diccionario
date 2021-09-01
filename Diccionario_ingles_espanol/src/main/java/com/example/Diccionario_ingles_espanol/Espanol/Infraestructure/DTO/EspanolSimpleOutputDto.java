package com.example.Diccionario_ingles_espanol.Espanol.Infraestructure.DTO;

import com.example.Diccionario_ingles_espanol.Ingles.Domain.Ingles;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
public class EspanolSimpleOutputDto extends EspanolOutputDto{

    int id;

    String palabra;

    String descripcion;

    Date fecha_alta;

    Date fecha_modif;



}
