package br.com.jlgregorio.rentacar.controller;

import br.com.jlgregorio.rentacar.dto.ManufacturerDto;
import br.com.jlgregorio.rentacar.exception.CustomExceptionResponse;
import br.com.jlgregorio.rentacar.service.ManufacturerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Manufacturers", description = "Endpoint para CRUD de Manufacturers")
@RestController
@RequestMapping("/manufacturers/v1")
public class ManufacturerController {

    private  final ManufacturerService manufacturerService;

    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }


    @PostMapping
    @Operation(summary = "Cria um Manufacturer no banco de dados", responses = {
            @ApiResponse(description = "O Manufacturer criado", responseCode = "201", content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ManufacturerDto.class)
            ))
    })
    public ResponseEntity<ManufacturerDto> create(@RequestBody ManufacturerDto dto){
        var created = manufacturerService.create(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Recuperar um Manufacturer mediante o ID informado", responses = {
            @ApiResponse(description = "O Manufacturer localizado, caso ele exista", responseCode = "200",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
            schema = @Schema(implementation = ManufacturerDto.class))),
            @ApiResponse(description = "Manufacturer não encontrado - ID não existe", responseCode = "404",
            content = @Content(mediaType = MediaType.MULTIPART_FORM_DATA_VALUE,
            schema = @Schema(implementation = CustomExceptionResponse.class)))
    })
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
