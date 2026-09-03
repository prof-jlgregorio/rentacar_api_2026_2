package br.com.jlgregorio.rentacar.service;

import br.com.jlgregorio.rentacar.entity.ManufacturerEntity;
import br.com.jlgregorio.rentacar.exception.ExceptionMessage;
import br.com.jlgregorio.rentacar.exception.ResourceNotFoundException;
import br.com.jlgregorio.rentacar.repository.ManufacturerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerService(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    public ManufacturerEntity create(ManufacturerEntity entity){
        return manufacturerRepository.save(entity);
    }

    public ManufacturerEntity findById(Long id){
        return manufacturerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(ExceptionMessage.RESOURCE_NOT_FOUND.toString()));
    }

    public ManufacturerEntity update(ManufacturerEntity entity){
        var found = manufacturerRepository.findById(entity.getId()).orElseThrow(
                () -> new ResourceNotFoundException(ExceptionMessage.RESOURCE_NOT_FOUND.toString()));
        found.setCountry(entity.getCountry());
        found.setName(entity.getName());
        return manufacturerRepository.save(found);
    }

    public void delete(Long id){
        var found = manufacturerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(ExceptionMessage.RESOURCE_NOT_FOUND.toString()));
        manufacturerRepository.delete(found);
    }

    public List<ManufacturerEntity> findAll(){
        return manufacturerRepository.findAll();
    }


}
