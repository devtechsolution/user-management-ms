package org.as.devtechsolution.depatment.service;

import org.as.devtechsolution.depatment.dto.DepartmentDto;
import org.as.devtechsolution.depatment.entity.Department;
import org.as.devtechsolution.depatment.mapper.DepatmentMapper;
import org.as.devtechsolution.depatment.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class DepartmentService {

	private final DepartmentRepository departmentRepository;
	private final DepatmentMapper depatmentMapper;

	public DepartmentDto saveDepartment(Department department) {
		log.info("Inside saveDepartment of DepartmentService");
		//		final Department save = departmentRepository.save(department);
		//		final DepartmentDto dto = DepartmentDto.builder().departmentId(save.getDepartmentId())
		//				.departmentAddress(save.getDepartmentAddress()).departmentName(save.getDepartmentName()).build();
		//		return dto;
		return depatmentMapper.departmentToDepartmentDto(departmentRepository.save(department));
	}

	public DepartmentDto findDepartmentById(Long departmentId) {
		log.info("Inside saveDepartment of DepartmentService");
		return depatmentMapper.departmentToDepartmentDto(departmentRepository.findByDepartmentId(departmentId));
	}
}