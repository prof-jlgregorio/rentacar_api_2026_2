package br.com.jlgregorio.rentacar.service;

import br.com.jlgregorio.rentacar.dto.ManufacturerDto;
import br.com.jlgregorio.rentacar.exception.ExceptionMessage;
import br.com.jlgregorio.rentacar.exception.ResourceNotFoundException;
import br.com.jlgregorio.rentacar.mapper.ManufacturerMapper;
import br.com.jlgregorio.rentacar.repository.ManufacturerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;
    private final ManufacturerMapper manufacturerMapper;

    public ManufacturerService(ManufacturerRepository manufacturerRepository, ManufacturerMapper manufacturerMapper) {
        this.manufacturerRepository = manufacturerRepository;
        this.manufacturerMapper = manufacturerMapper;
    }

    public ManufacturerDto create(ManufacturerDto dto) {
        var entity = manufacturerMapper.toEntity(dto);
        var created = manufacturerRepository.save(entity);
        return manufacturerMapper.toDto(created);
    }

    public ManufacturerDto findById(Long id) {
        var found = manufacturerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(ExceptionMessage.RESOURCE_NOT_FOUND.toString()));
        return manufacturerMapper.toDto(found);
    }

    public ManufacturerDto update(ManufacturerDto dto) {
        var found = manufacturerRepository.findById(dto.id()).orElseThrow(
                () -> new ResourceNotFoundException(ExceptionMessage.RESOURCE_NOT_FOUND.toString()));
        found.setCountry(dto.country());
        found.setName(dto.name());
        var updated = manufacturerRepository.save(found);
        return manufacturerMapper.toDto(updated);
    }

    public void delete(Long id) {
        var found = manufacturerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(ExceptionMessage.RESOURCE_NOT_FOUND.toString()));
        manufacturerRepository.delete(found);
    }

    public List<ManufacturerDto> findAll() {
        var entities = manufacturerRepository.findAll();
        return manufacturerMapper.toDtoList(entities);
    }


}
