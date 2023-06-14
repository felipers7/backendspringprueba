package com.example.fullstacktest.coordinates.services;

import com.example.fullstacktest.coordinates.dto.CoordinateDTO;
import com.example.fullstacktest.coordinates.entities.Coordinate;
import com.example.fullstacktest.coordinates.repositories.CoordinateRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CoordinateServiceTest {

    @Mock
    private CoordinateRepository coordinateRepository;
    @InjectMocks
    private CoordinateService coordinateService;

    @Before
    public void SetUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void test_service_maps_values_correctly(){
        //Preparación de datos
        Coordinate coordinate = new Coordinate();
        coordinate.setLatitud("-12.123");
        coordinate.setLongitud("-21.321");
        Optional<Coordinate> coordinateOptional = Optional.of(coordinate);
        when(coordinateRepository.findByLatitudAndLongitud("-12.123", "-21.321")).thenReturn(coordinateOptional);
        //Llamado al servicio
        Optional<CoordinateDTO> result = coordinateService.findOne("-12.123", "-21.321");
        //Asserts
        assertEquals(result.get().getLan_input(), coordinate.getLatitud());
        assertEquals(result.get().getLng_input(), coordinate.getLongitud());
    }

    @Test
    public void test_repository_is_called_once(){
        //Preparación de datos
        Coordinate coordinate = new Coordinate();
        coordinate.setLatitud("-12.123");
        coordinate.setLongitud("-21.321");
        Optional<Coordinate> coordinateOptional = Optional.of(coordinate);
        when(coordinateRepository.findByLatitudAndLongitud("-12.123", "-21.321")).thenReturn(coordinateOptional);
        //Llamada al servicio
        Optional<CoordinateDTO> result = coordinateService.findOne("-12.123", "-21.321");
        //Verificación de número de llamadas
        verify(coordinateRepository, times(1)).findByLatitudAndLongitud("-12.123", "-21.321");
    }
    @Test
    public void test_service_return_empty_optional(){
        //Preparación de datos
        when(coordinateRepository.findByLatitudAndLongitud("qqq", "-qqq")).thenReturn(Optional.empty());
        Optional<CoordinateDTO> result = coordinateService.findOne("qqq", "-qqq");
        // Asserts
        assertEquals(result, Optional.empty());

    }

}