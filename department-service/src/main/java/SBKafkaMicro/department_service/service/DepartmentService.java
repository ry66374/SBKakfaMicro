package SBKafkaMicro.department_service.service;

import SBKafkaMicro.department_service.dto.DepartmentDto;

public interface DepartmentService {

    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String code);
}
