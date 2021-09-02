package com.example.Diccionario_ingles_espanol.Ingles.Infraestructure.DTO;

import com.example.Diccionario_ingles_espanol.Espanol.Domain.Espanol;
import com.example.Diccionario_ingles_espanol.Espanol.Infraestructure.Repositorio.EspanolRepositorio;
import com.example.Diccionario_ingles_espanol.Ingles.Domain.Ingles;
import com.example.Diccionario_ingles_espanol.Ingles.Infraestructure.Repositorio.InglesRepositorio;
import com.sun.istack.NotNull;
import lombok.Data;


import javax.persistence.Column;
import java.util.Date;

@Data
public class InglesInputDto {

    private int id;

    @NotNull
    @Column(unique=true)//Con esta linea ponemos la restriccion de que no se repita palabras
    private String palabra;

    @NotNull
    private Date fecha_alta=new Date();

    private Date fecha_modif= new Date();

    private Integer id_espanol;
    public Ingles dameIngles(EspanolRepositorio espanolRepositorio, InglesInputDto inglesInputDto) {

        Ingles in = new Ingles();

        in.setPalabra(this.getPalabra());
        in.setFecha_alta(this.getFecha_alta());
        in.setFecha_modif(this.getFecha_modif());
        in.setEspanol(espanolRepositorio.findById(inglesInputDto.getId_espanol()).get());

        return in;

    }
}
