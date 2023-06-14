package com.example.fullstacktest.coordinates.dto;

import lombok.Data;

@Data
public class CoordinateDTO {
    private String lan_input;
    private String lng_input;
    private DatoDTO datos;
}
