package com.example.Diccionario_ingles_espanol.Espanol.Aplication;

import com.example.Diccionario_ingles_espanol.Espanol.Infraestructure.DTO.EspanoInputDto;
import com.example.Diccionario_ingles_espanol.Espanol.Infraestructure.DTO.EspanolOutputDto;
import com.example.Diccionario_ingles_espanol.Espanol.Infraestructure.DTO.EspanolSimpleOutputDto;

import java.util.List;

public interface IEspanolServicio {

    public List<EspanolOutputDto> findAll();

    public EspanolSimpleOutputDto saveEspanol(EspanoInputDto espanoInputDto);
    public void Delete (String palabra)throws Exception;
    public EspanolSimpleOutputDto ModificarEspanol(String palabra,EspanoInputDto espanoInputDto) throws Exception;

    public List<EspanolOutputDto> ConsultaEspanol(String palabra)throws Exception;

}
