package br.com.jlgregorio.rentacar.service;

import br.com.jlgregorio.rentacar.dto.VehicleDto;
import br.com.jlgregorio.rentacar.exception.ExceptionMessage;
import br.com.jlgregorio.rentacar.exception.ResourceNotFoundException;
import br.com.jlgregorio.rentacar.mapper.VehicleMapper;
import br.com.jlgregorio.rentacar.repository.ManufacturerRepository;
import br.com.jlgregorio.rentacar.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private final VehicleMapper vehicleMapper;

    private final VehicleRepository vehicleRepository;

    private final ManufacturerRepository manufacturerRepository;


    public VehicleService(VehicleMapper vehicleMapper, VehicleRepository vehicleRepository,
                           ManufacturerRepository manufacturerRepository) {
        this.vehicleMapper = vehicleMapper;
        this.vehicleRepository = vehicleRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    public VehicleDto create(VehicleDto dto) {
        var entity = vehicleMapper.toEntity(dto);
        var manufacturer = manufacturerRepository.findById(dto.manufacturer().id()).orElseThrow(
                () -> new ResourceNotFoundException(ExceptionMessage.RESOURCE_NOT_FOUND.toString()));
        entity.setManufacturer(manufacturer);
        var created = vehicleRepository.save(entity);
        return vehicleMapper.toDto(created);
    }

    public VehicleDto findById(Long id) {
        var found = vehicleRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(ExceptionMessage.RESOURCE_NOT_FOUND.toString()));
        return vehicleMapper.toDto(found);
    }

    public VehicleDto update(VehicleDto dto) {
        var found = vehicleRepository.findById(dto.id()).orElseThrow(
                () -> new ResourceNotFoundException(ExceptionMessage.RESOURCE_NOT_FOUND.toString()));
        found.setName(dto.name());
        found.setYear(dto.year());
        found.setColor(dto.color());
        found.setComments(dto.comments());
        var manufacturer = manufacturerRepository.findById(dto.manufacturer().id()).orElseThrow(
                () -> new ResourceNotFoundException(ExceptionMessage.RESOURCE_NOT_FOUND.toString()));
        found.setManufacturer(manufacturer);
        var updated = vehicleRepository.save(found);
        return vehicleMapper.toDto(updated);
    }

    public void delete(Long id) {
        var found = vehicleRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(ExceptionMessage.RESOURCE_NOT_FOUND.toString()));
        vehicleRepository.delete(found);
    }

    public List<VehicleDto> findAll() {
        var entities = vehicleRepository.findAll();
        return vehicleMapper.toDtoList(entities);
    }


}