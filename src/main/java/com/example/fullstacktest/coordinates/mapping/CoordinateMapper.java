package com.example.fullstacktest.coordinates.mapping;

import com.example.fullstacktest.coordinates.dto.CoordinateDTO;
import com.example.fullstacktest.coordinates.entities.Coordinate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
public interface CoordinateMapper {

    //Mapper que utiliza la librería mapstruct con el fin de generar un DTO
    //con la estructura requerida y no enviar la id.
    CoordinateMapper INSTANCE = Mappers.getMapper(CoordinateMapper.class);
    @Mappings({
            @Mapping(source = "latitud", target = "lan_input"),
            @Mapping(source = "longitud", target = "lng_input"),
            @Mapping(source = "campo1", target = "datos.campo1"),
            @Mapping(source = "campo2", target = "datos.campo2")
    })
    CoordinateDTO toCoordinateDTO(Coordinate coordinate);
}
