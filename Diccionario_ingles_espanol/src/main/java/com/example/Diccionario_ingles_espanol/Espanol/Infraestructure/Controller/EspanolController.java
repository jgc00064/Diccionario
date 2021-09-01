package com.example.Diccionario_ingles_espanol.Espanol.Infraestructure.Controller;


import com.example.Diccionario_ingles_espanol.Espanol.Aplication.EspanolServicio;
import com.example.Diccionario_ingles_espanol.Espanol.Infraestructure.DTO.EspanoInputDto;
import com.example.Diccionario_ingles_espanol.Espanol.Infraestructure.DTO.EspanolOutputDto;
import com.example.Diccionario_ingles_espanol.Espanol.Infraestructure.DTO.EspanolSimpleOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController

@RequestMapping("/espanol")
public class EspanolController {

    @Autowired
    EspanolServicio espanolServicio;

    @PostMapping
    public EspanolSimpleOutputDto añadirEspanol(@Valid @RequestBody EspanoInputDto espanolInputDTO) throws Exception{

        return espanolServicio.saveEspanol(espanolInputDTO); // Si no rellenas todos los campos de la tabla en Postman lo recoge como nulo y da fallo el programa. Por lo que hay que rellenar todos los campos de la Emtity.
    }

    @PutMapping("/{palabra}")
    public EspanolSimpleOutputDto modificarEspanol(@Valid @PathVariable String palabra, @RequestBody EspanoInputDto espanolInputDTO) throws Exception {

        return espanolServicio.ModificarEspanol(palabra, espanolInputDTO);
    }

    @DeleteMapping("/{palabra}")
    public void DeleteEspanol(@PathVariable String palabra) throws Exception {

        espanolServicio.Delete(palabra);
    }

    @GetMapping("/{palabra}")
    public List<EspanolOutputDto> consultapalabra(@PathVariable String palabra)throws Exception {

        return espanolServicio.ConsultaEspanol(palabra);
    }


}
