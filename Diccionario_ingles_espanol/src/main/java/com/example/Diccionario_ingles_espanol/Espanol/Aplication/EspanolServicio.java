package com.example.Diccionario_ingles_espanol.Espanol.Aplication;


import com.example.Diccionario_ingles_espanol.Espanol.Domain.Espanol;
import com.example.Diccionario_ingles_espanol.Espanol.Infraestructure.DTO.EspanoInputDto;
import com.example.Diccionario_ingles_espanol.Espanol.Infraestructure.DTO.EspanolOutputDto;
import com.example.Diccionario_ingles_espanol.Espanol.Infraestructure.DTO.EspanolSimpleOutputDto;
import com.example.Diccionario_ingles_espanol.Espanol.Infraestructure.Repositorio.EspanolRepositorio;

import com.example.Diccionario_ingles_espanol.Ingles.Infraestructure.Repositorio.InglesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EspanolServicio implements IEspanolServicio {

    @Autowired
    EspanolRepositorio espanolRepositorio;

    @Autowired
    InglesRepositorio inglesRepositorio;

    public List<EspanolOutputDto> findAll(){

        return espanolRepositorio.findAll().stream().map(p->p.dameEspanolOutputDto()).collect(Collectors.toList());

    }

    public EspanolSimpleOutputDto saveEspanol(EspanoInputDto espanoInputDto){

        Espanol es = espanoInputDto.dameEspanol();

        espanolRepositorio.save(es);

        return es.dameEspanosimplelOutputDto();
    }


    public void Delete (String palabra)throws Exception{


        List<Espanol> es = espanolRepositorio.findByPalabra(palabra);

        if (es.size() > 0) {
            Espanol e = es.get(0);
            espanolRepositorio.delete(e);
            System.out.println("La palabra: "+palabra+" ha sido borrada del diccionario");
        }

        else {

            throw new Exception("Esta palabra: ." + palabra + " No está en la lista, pruebe con otra para poder ser borrada.");
        }
    }

    public EspanolSimpleOutputDto ModificarEspanol(@Valid String palabra, EspanoInputDto espanoInputDto) throws Exception {

        List<Espanol> enueva = espanolRepositorio.findByPalabra(palabra);
        if (enueva.size() > 0) {
            Espanol e = enueva.get(0);
            e.actualizaespanol(espanoInputDto);
            espanolRepositorio.save(e);
            return e.dameEspanosimplelOutputDto();
        }
        else{
             throw  new Exception("Esta palabra: " + palabra + " No existe en la lista vuelve a introducir otra para poder ser modificada");
        }
    }

    public List<EspanolOutputDto> ConsultaEspanol(String palabra)throws Exception{

        if (!espanolRepositorio.findByPalabra(palabra).isEmpty()) { //isEmpty es un método que comprueba si el tamaño de la lista es =0
            List<Espanol> econsulta = espanolRepositorio.findByPalabra(palabra);

            return econsulta.stream().map(p -> p.dameEspanolOutputDto()).collect(Collectors.toList());

        } else
               throw new Exception("La palabra: "+palabra+"no se encuentra en la lista para poder hacer la consulta");

    }

}
