package br.com.jlgregorio.rentacar.mapper;


import br.com.jlgregorio.rentacar.dto.VehicleDto;
import br.com.jlgregorio.rentacar.entity.VehicleEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = ManufacturerMapper.class)
public interface VehicleMapper {

    public VehicleDto toDto(VehicleEntity entity);

    public VehicleEntity toEntity(VehicleDto dto);

    public List<VehicleDto> toDtoList(List<VehicleEntity> entities);

    public List<VehicleEntity> toEntityList(List<VehicleDto> dtos);

}
