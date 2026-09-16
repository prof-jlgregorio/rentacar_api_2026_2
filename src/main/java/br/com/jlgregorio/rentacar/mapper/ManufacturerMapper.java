package br.com.jlgregorio.rentacar.mapper;


import br.com.jlgregorio.rentacar.dto.ManufacturerDto;
import br.com.jlgregorio.rentacar.entity.ManufacturerEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ManufacturerMapper {

    ManufacturerDto toDto(ManufacturerEntity entity);

    ManufacturerEntity toEntity(ManufacturerDto dto);

    List<ManufacturerDto> toDtoList(List<ManufacturerEntity> entities);

    List<ManufacturerEntity> toEntityList(List<ManufacturerDto> dtos);

}
