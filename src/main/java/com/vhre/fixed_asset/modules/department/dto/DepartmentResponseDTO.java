package com.vhre.fixed_asset.modules.department.dto;

import com.vhre.fixed_asset.core.utils.auditable_dto.AuditableResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Schema(description = "Respuesta que representa un departamento, incluyendo datos de auditoría")
public class DepartmentResponseDTO extends AuditableResponseDTO {
    @Schema(description = "ID único del departamento", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID id;

    @Schema(description = "Nombre oficial del departamento", example = "Recursos Humanos")
    private String name;

    @Schema(description = "Código del centro de costos", example = "CC-HR-001")
    private String costCenterCode;
}
