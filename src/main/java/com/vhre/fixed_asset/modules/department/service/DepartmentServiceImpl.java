package com.vhre.fixed_asset.modules.department.service;

import com.vhre.fixed_asset.modules.department.dto.DepartmentRequestDTO;
import com.vhre.fixed_asset.modules.department.dto.DepartmentResponseDTO;
import com.vhre.fixed_asset.modules.department.entity.Department;
import com.vhre.fixed_asset.modules.department.mapper.DepartmentMapper;
import com.vhre.fixed_asset.modules.department.repository.DepartmentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    @Override
    @Transactional
    public DepartmentResponseDTO create(DepartmentRequestDTO requestDTO)
    {
        Department department = departmentMapper.toEntity(requestDTO);
        Department savedDepartment = departmentRepository.save(department);
        return departmentMapper.toDto(savedDepartment);
    }

    @Override
    @Transactional(readOnly = true)
    public DepartmentResponseDTO getById(UUID id)
    {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Departamento no encontrado"));
        return  departmentMapper.toDto(department);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DepartmentResponseDTO> getAll() {
        return departmentRepository.findAll().stream()
                .map(departmentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public DepartmentResponseDTO update(UUID id, DepartmentRequestDTO requestDTO) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Departamento no encontrado"));

        departmentMapper.updateEntity(department, requestDTO);

        Department updatedDepartment = departmentRepository.save(department);
        return departmentMapper.toDto(updatedDepartment);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        if (!departmentRepository.existsById(id)) {
            throw new EntityNotFoundException("Departamento no encontrado");
        }
        departmentRepository.deleteById(id);
    }
}
