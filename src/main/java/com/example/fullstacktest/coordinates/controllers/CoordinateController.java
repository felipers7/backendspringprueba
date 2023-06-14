package com.example.fullstacktest.coordinates.controllers;

import com.example.fullstacktest.coordinates.dto.CoordinateDTO;
import com.example.fullstacktest.coordinates.entities.Coordinate;
import com.example.fullstacktest.coordinates.services.CoordinateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/coordinates")
public class CoordinateController {

    @Autowired
    private CoordinateService coordinateService;


    @GetMapping(value = "")
    public ResponseEntity<CoordinateDTO> findOne(@RequestParam("latitud") String latitud,
                                              @RequestParam("longitud") String longitud){
        //Llamado al servicio
        Optional<CoordinateDTO> coordinate = coordinateService.findOne(latitud, longitud);

        //retorna entidad si la encuentra o si no, simplemente un 404
        if(coordinate.isEmpty())
            return new ResponseEntity<>(new CoordinateDTO(), HttpStatusCode.valueOf(404));
        return new ResponseEntity<>(coordinate.get(), HttpStatusCode.valueOf(200));

    }

}
