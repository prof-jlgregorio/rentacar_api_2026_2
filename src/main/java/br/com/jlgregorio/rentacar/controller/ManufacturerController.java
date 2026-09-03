package br.com.jlgregorio.rentacar.controller;

import br.com.jlgregorio.rentacar.entity.ManufacturerEntity;
import br.com.jlgregorio.rentacar.service.ManufacturerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
