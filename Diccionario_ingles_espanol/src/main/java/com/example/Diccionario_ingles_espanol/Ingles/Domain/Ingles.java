package com.example.Diccionario_ingles_espanol.Ingles.Domain;



import com.example.Diccionario_ingles_espanol.Espanol.Domain.Espanol;

import com.example.Diccionario_ingles_espanol.Espanol.Infraestructure.Repositorio.EspanolRepositorio;
import com.example.Diccionario_ingles_espanol.Ingles.Infraestructure.DTO.InglesInputDto;
import com.example.Diccionario_ingles_espanol.Ingles.Infraestructure.DTO.InglesOutputDto;
import com.example.Diccionario_ingles_espanol.Ingles.Infraestructure.DTO.InglesSimpleOutputDto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Ingles{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Column(unique=true)
    private String palabra;

    @NotNull
    private Date fecha_alta=new Date();

    private Date fecha_modif=new Date();

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="id_español")
    private Espanol espanol;

    public InglesOutputDto dameInglesOutputDto(EspanolRepositorio espanolRepositorio, InglesInputDto inglesInputDto) {

        InglesOutputDto e = new InglesOutputDto();

        e.setPalabra(this.getPalabra());
        e.setFecha_alta(this.getFecha_alta());
        e.setFecha_modif(this.getFecha_modif());
        e.setEspanol(espanolRepositorio.findById(inglesInputDto.getId()).get());

        return e;
    }

    public InglesSimpleOutputDto dameInglesSimpleOutputDto(EspanolRepositorio espanolRepositorio, InglesInputDto inglesInputDto) {

        InglesSimpleOutputDto e = new InglesSimpleOutputDto();

        e.setPalabra(this.getPalabra());
        e.setFecha_alta(this.getFecha_alta());
        e.setFecha_modif(this.getFecha_modif());
        e.setEspanol(espanolRepositorio.findById(inglesInputDto.getId()).get());

        return e;
    }


    public void actualizaingles(InglesInputDto i){

        if (i.getPalabra()!= null) setPalabra(i.getPalabra()); // hay que poner el @Data en PersonaOutputDTO para que coja los setter y getter.
        if (i.getFecha_modif()!=null) setFecha_modif(i.getFecha_modif());

    }


}


