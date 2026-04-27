package com.vhre.fixed_asset.modules.department.controller;

import com.vhre.fixed_asset.modules.department.dto.DepartmentRequestDTO;
import com.vhre.fixed_asset.modules.department.dto.DepartmentResponseDTO;
import com.vhre.fixed_asset.modules.department.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/fixed-assets/departments")
@RequiredArgsConstructor
@Tag(name = "Departments", description = "Endpoints para la gestión de Departamentos en el sistema de Activos Fijos")
public class DepartmentController {
    private final DepartmentService departmentService;

    @Operation(summary = "Crear un nuevo departamento", description = "Crea un departamento validando que el centro de costos no exista previamente.")
    @PostMapping
    public ResponseEntity<DepartmentResponseDTO> create(@Valid @RequestBody DepartmentRequestDTO requestDTO) {
        DepartmentResponseDTO response = departmentService.create(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
