package org.as.devtechsolution.depatment.mapper;

import org.as.devtechsolution.depatment.dto.DepartmentDto;
import org.as.devtechsolution.depatment.entity.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepatmentMapper {

	public Department departmentDtoToDepartment(DepartmentDto departmentDto);

	public DepartmentDto departmentToDepartmentDto(Department department);




}
