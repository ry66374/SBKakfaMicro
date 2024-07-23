package SBKafkaMicro.employee_service.service;

import SBKafkaMicro.employee_service.dto.APIResponseDto;
import SBKafkaMicro.employee_service.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(Long employeeId);
}
