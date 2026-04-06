package com.vhre.fixed_asset.modules.department.mapper;

import com.vhre.fixed_asset.modules.department.dto.DepartmentRequestDTO;
import com.vhre.fixed_asset.modules.department.dto.DepartmentResponseDTO;
import com.vhre.fixed_asset.modules.department.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DepartmentMapper {
    // Request DTO to Entity (CREATE)
    Department toEntity(DepartmentRequestDTO dto);

    // Entity to Response DTO (GET)
    DepartmentResponseDTO toDto(Department entity);

    // Update
    void updateEntity(@MappingTarget Department entity, DepartmentRequestDTO dto);
}
