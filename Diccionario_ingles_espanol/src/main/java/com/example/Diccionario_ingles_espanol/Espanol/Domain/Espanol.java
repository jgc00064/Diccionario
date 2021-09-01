package com.example.Diccionario_ingles_espanol.Espanol.Domain;

import com.example.Diccionario_ingles_espanol.Espanol.Infraestructure.DTO.EspanoInputDto;
import com.example.Diccionario_ingles_espanol.Espanol.Infraestructure.DTO.EspanolOutputDto;
import com.example.Diccionario_ingles_espanol.Espanol.Infraestructure.DTO.EspanolSimpleOutputDto;
import com.example.Diccionario_ingles_espanol.Ingles.Domain.Ingles;
import com.example.Diccionario_ingles_espanol.Ingles.Infraestructure.Repositorio.InglesRepositorio;
import com.sun.istack.NotNull;
import lombok.Data;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data

public class Espanol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Column(unique=true) // Con esta linea decimos que no se pueden repetir palabras en la base de datos.
    private String palabra;

    private String descripcion;

    @NotNull
    //@Temporal(TemporalType.DATE)
    private Date fecha_alta = new Date();

    private Date fecha_modif = new Date(); //fecha_modif se pone automatico para que cuando hagamos el put se actualice automaticamente con el dia actual.

    @OneToMany(mappedBy="espanol")
    private List<Ingles> ingles;

    public EspanolOutputDto dameEspanolOutputDto(){

        EspanolOutputDto e = new EspanolOutputDto();

        e.setPalabra(this.getPalabra());
        e.setDescripcion(this.getDescripcion());
        e.setFecha_alta(this.getFecha_alta());
        e.setFecha_modif(this.getFecha_modif());
        e.setIngles(this.getIngles());
        return e;

    }
    public EspanolSimpleOutputDto dameEspanosimplelOutputDto(){

        EspanolSimpleOutputDto e = new EspanolSimpleOutputDto();

        e.setPalabra(this.getPalabra());
        e.setDescripcion(this.getDescripcion());
        e.setFecha_alta(this.getFecha_alta());
        e.setFecha_modif(this.getFecha_modif());
        return e;
    }

    public void actualizaespanol(EspanoInputDto e){

        if (e.getPalabra()!= null) setPalabra(e.getPalabra());
        if (e.getDescripcion()!=null) setDescripcion(e.getDescripcion());
        if (e.getFecha_modif()!=null) setFecha_modif(e.getFecha_modif());

    }

}
