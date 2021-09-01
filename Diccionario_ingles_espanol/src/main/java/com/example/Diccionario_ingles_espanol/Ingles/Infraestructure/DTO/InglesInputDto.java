package com.example.Diccionario_ingles_espanol.Ingles.Infraestructure.DTO;

import com.example.Diccionario_ingles_espanol.Espanol.Domain.Espanol;
import com.example.Diccionario_ingles_espanol.Ingles.Domain.Ingles;
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
    private Date fecha_alta;

    private Date fecha_modif;

    private Espanol espanol;
    public Ingles dameIngles() {

        Ingles in = new Ingles();

        in.setPalabra(this.getPalabra());
        in.setFecha_alta(this.getFecha_alta());
        in.setFecha_modif(this.getFecha_modif());
        in.setEspanol(this.getEspanol());
        return in;

    }
}
