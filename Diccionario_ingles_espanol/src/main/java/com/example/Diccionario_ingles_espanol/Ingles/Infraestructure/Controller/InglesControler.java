package com.example.Diccionario_ingles_espanol.Ingles.Infraestructure.Controller;

import com.example.Diccionario_ingles_espanol.Ingles.Aplication.InglesServicio;
import com.example.Diccionario_ingles_espanol.Ingles.Infraestructure.DTO.InglesInputDto;
import com.example.Diccionario_ingles_espanol.Ingles.Infraestructure.DTO.InglesOutputDto;
import com.example.Diccionario_ingles_espanol.Ingles.Infraestructure.DTO.InglesSimpleOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/ingles")

public class InglesControler {

    @Autowired
    InglesServicio inglesServicio;

    @PostMapping
    public InglesSimpleOutputDto añadirIngles(@Valid @RequestBody InglesInputDto inglesInputDTO) throws Exception{

        return inglesServicio.saveIngles(inglesInputDTO); // Si no rellenas todos los campos de la tabla en Postman lo recoge como nulo y da fallo el programa. Por lo que hay que rellenar todos los campos de la Emtity.
    }

    @PutMapping("/{palabra}")
    public InglesSimpleOutputDto modificarIngles(@Valid @PathVariable String palabra, @RequestBody InglesInputDto inglesInputDTO) throws Exception {

        return inglesServicio.ModificarIngles(palabra,inglesInputDTO);
    }

    @DeleteMapping("/{palabra}")
    public void DeleteIngles(@PathVariable String palabra) throws Exception {

        inglesServicio.Delete(palabra);
    }

    @GetMapping("/{palabra}")
    public List<InglesOutputDto> consultapalabra(@PathVariable String palabra, @RequestBody InglesInputDto inglesInputDto)throws Exception {

        return inglesServicio.ConsultaIngles(palabra, inglesInputDto);
    }
}


