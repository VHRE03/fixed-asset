package com.vhre.fixed_asset.modules.department.service;

import com.vhre.fixed_asset.modules.department.dto.DepartmentRequestDTO;
import com.vhre.fixed_asset.modules.department.dto.DepartmentResponseDTO;

import java.util.List;
import java.util.UUID;

public interface DepartmentService {
    DepartmentResponseDTO create(DepartmentRequestDTO requestDTO);

    DepartmentResponseDTO getById(UUID id);

    List<DepartmentResponseDTO> getAll();

    DepartmentResponseDTO update(UUID id, DepartmentRequestDTO requestDTO);

    void delete(UUID id);
}
