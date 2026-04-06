package com.vhre.fixed_asset.modules.department.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Objeto de transferencia de datos para crear o actualizar un departamento")
public record DepartmentRequestDTO(
        @Schema(description = "Nombre oficial del departamento", example = "Recursos Humanos", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank(message = "El nombre del departamento es obligatorio")
        @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres")
        String name,

        @Schema(description = "Código del centro de costos asignado", example = "CC-HR-001", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank(message = "El código del centro de costos es obligatorio")
        String costCenterCode
) {
}
