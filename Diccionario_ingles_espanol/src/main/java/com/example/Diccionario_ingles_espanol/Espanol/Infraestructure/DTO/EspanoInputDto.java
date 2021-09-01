package com.example.Diccionario_ingles_espanol.Espanol.Infraestructure.DTO;

import com.example.Diccionario_ingles_espanol.Espanol.Domain.Espanol;
import com.example.Diccionario_ingles_espanol.Ingles.Domain.Ingles;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
public class EspanoInputDto {


    int id;

    @NotNull
    @Column(unique=true) // Con esta linea hacemos que no se repitan palabras.
    String palabra;

    String descripcion;

    @NotNull

    Date fecha_alta = new Date(); // Con esta linea se actualiza la fecha del dia actual cuando damos de alta una nueva palabra.

    Date fecha_modif = new Date();

    List<Ingles> ingles;

    public Espanol dameEspanol(){

        Espanol e = new Espanol();

        e.setPalabra(this.getPalabra());
        e.setDescripcion(this.getDescripcion());
        e.setFecha_alta(this.getFecha_alta());
        e.setFecha_modif(this.getFecha_modif());
        e.setIngles(this.getIngles());
        return e;
    }

}
