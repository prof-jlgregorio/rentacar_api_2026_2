package br.com.jlgregorio.rentacar.controller;

import br.com.jlgregorio.rentacar.dto.ManufacturerDto;
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
    public ResponseEntity<ManufacturerDto> create(@RequestBody ManufacturerDto dto){
        var created = manufacturerService.create(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ManufacturerDto> findById(@PathVariable Long id){
        var found = manufacturerService.findById(id);
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<ManufacturerDto>> findAll(){
        var manufacturers = manufacturerService.findAll();
        return new ResponseEntity<>(manufacturers, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ManufacturerDto> update(@RequestBody ManufacturerDto dto){
        var updated = manufacturerService.update(dto);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        manufacturerService.delete(id);
        return new ResponseEntity<>((Object) null, HttpStatus.NO_CONTENT);
    }
}
