package com.example.Diccionario_ingles_espanol.Ingles.Aplication;

import com.example.Diccionario_ingles_espanol.Ingles.Infraestructure.DTO.InglesInputDto;
import com.example.Diccionario_ingles_espanol.Ingles.Infraestructure.DTO.InglesOutputDto;
import com.example.Diccionario_ingles_espanol.Ingles.Infraestructure.DTO.InglesSimpleOutputDto;

import java.util.List;

public interface IInglesServicio {

    public InglesSimpleOutputDto saveIngles(InglesInputDto inglesInputDto);

    public void Delete (String palabra)throws Exception;

    public InglesSimpleOutputDto ModificarIngles(String palabra,InglesInputDto inglesInputDto) throws Exception;

    public List<InglesOutputDto> ConsultaIngles(String palabra, InglesInputDto inglesInputDto)throws Exception;
}
