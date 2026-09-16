package br.com.jlgregorio.rentacar.dto;

public record VehicleDto(
        Long id,
        String name,
        int year,
        String color,
        String comments,
        ManufacturerDto manufacturer
) {
}
