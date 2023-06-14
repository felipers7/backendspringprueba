package com.example.fullstacktest.coordinates.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "coordenadas")
@NoArgsConstructor
public class Coordinate {
    //Entity class que usa lomblok para evitar declaración de getters y setters
    //además de asegurar el nombre de las columnas y un constructor sin argumentos
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @Column( name = "latitud")
    private String latitud;
    @Column( name = "longitud")
    private String longitud;
    private String campo1;
    private String campo2;
}
