package br.com.jlgregorio.rentacar.controller;

import br.com.jlgregorio.rentacar.dto.VehicleDto;
import br.com.jlgregorio.rentacar.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles/v1")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<VehicleDto> create(@RequestBody VehicleDto dto){
        var created = vehicleService.create(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDto> findById(@PathVariable Long id){
        var found = vehicleService.findById(id);
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<VehicleDto>> findAll(){
        var vehicles = vehicleService.findAll();
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<VehicleDto> update(@RequestBody VehicleDto dto){
        var updated = vehicleService.update(dto);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        vehicleService.delete(id);
        return new ResponseEntity<>((Object) null, HttpStatus.NO_CONTENT);
    }
}
