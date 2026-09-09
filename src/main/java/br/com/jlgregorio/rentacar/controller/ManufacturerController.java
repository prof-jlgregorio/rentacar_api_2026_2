package br.com.jlgregorio.rentacar.controller;

import br.com.jlgregorio.rentacar.entity.ManufacturerEntity;
import br.com.jlgregorio.rentacar.service.ManufacturerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manufacturers/v1")
public class ManufacturerController {

    private  final ManufacturerService manufacturerService;

    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @PostMapping
    public ResponseEntity<ManufacturerEntity> create(@RequestBody ManufacturerEntity entity){
        var created = manufacturerService.create(entity);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ManufacturerEntity> findById(@PathVariable Long id){
        var found = manufacturerService.findById(id);
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<ManufacturerEntity>> findAll(){
        var manufacturers = manufacturerService.findAll();
        return new ResponseEntity<>(manufacturers, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ManufacturerEntity> update(@RequestBody ManufacturerEntity entity){
        var updated = manufacturerService.update(entity);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        manufacturerService.delete(id);
        return new ResponseEntity<>((Object) null, HttpStatus.NO_CONTENT);
    }



}
