package com.example.Diccionario_ingles_espanol.Ingles.Aplication;


import com.example.Diccionario_ingles_espanol.Espanol.Infraestructure.Repositorio.EspanolRepositorio;
import com.example.Diccionario_ingles_espanol.Ingles.Domain.Ingles;
import com.example.Diccionario_ingles_espanol.Ingles.Infraestructure.DTO.InglesInputDto;
import com.example.Diccionario_ingles_espanol.Ingles.Infraestructure.DTO.InglesOutputDto;
import com.example.Diccionario_ingles_espanol.Ingles.Infraestructure.DTO.InglesSimpleOutputDto;
import com.example.Diccionario_ingles_espanol.Ingles.Infraestructure.Repositorio.InglesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InglesServicio implements IInglesServicio{

    @Autowired
    InglesRepositorio inglesRepositorio;

    @Autowired
    EspanolRepositorio espanolRepositorio;

    public InglesSimpleOutputDto saveIngles(InglesInputDto inglesInputDto){

        Ingles in = inglesInputDto.dameIngles(espanolRepositorio, inglesInputDto);

        inglesRepositorio.save(in);

        return in.dameInglesSimpleOutputDto(espanolRepositorio,inglesInputDto);
    }

    public void Delete (String palabra)throws Exception{


        List<Ingles> in = inglesRepositorio.findByPalabra(palabra);

        if (in.size() > 0) {
                Ingles ingl = in.get(0);
                inglesRepositorio.delete(ingl);
                System.out.println("La palabra: "+palabra+" ha sido borrada del diccionario de Ingles.");
        }

        throw new Exception("Esta palabra: ."+palabra+" No está en la lista de palabras en Ingles, pruebe con otra para poder ser borrada.");
    }

    public InglesSimpleOutputDto ModificarIngles(String palabra,InglesInputDto inglesInputDto) throws Exception {

        List<Ingles> inueva = inglesRepositorio.findByPalabra(palabra);// En esta linea obtengo todos los elementos con la palabra que le paso
        if (inueva.size() > 0) { // En esta compuebo si hay alguna palabra
                Ingles in = inueva.get(0); // En esta linea Lista la paso al objeto Ingles y cojo la primera que haya encontrado
                in.actualizaingles(inglesInputDto); //llamo al metodo actualizar
                inglesRepositorio.save(in);
                return in.dameInglesSimpleOutputDto(espanolRepositorio,inglesInputDto);
        }
        else {
                throw new Exception("Esta palabra: " + palabra + " No existe en la lista vuelve a introducir otra para poder ser modificada");

        }
    }

    public List<InglesOutputDto> ConsultaIngles(String palabra,InglesInputDto inglesInputDto)throws Exception{

        if (!inglesRepositorio.findByPalabra(palabra).isEmpty()) {
                List<Ingles> iconsulta = inglesRepositorio.findByPalabra(palabra);

                return iconsulta.stream().map(p -> p.dameInglesOutputDto(espanolRepositorio,inglesInputDto)).collect(Collectors.toList());

        } else
                throw new Exception("La palabra: "+palabra+"no se encuentra en la lista del diccionarion Ingles, no es posible hacer la consulta,\n Pruebe con otra palabra que se encuentre en la lista de Ingles");

    }

}




