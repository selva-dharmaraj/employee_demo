package com.example.demo.test.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Employee;
import com.example.demo.model.EmployeeCreateResponse;
import com.example.demo.model.EmployeeGetAllResponse;
import com.example.demo.repository.EmployeeRepository;


/**
 * EmployeeService.
 *
 * @author   Selva Dharmaraj
 * @version  $Revision$, 8/13/18
 */
@Service
public class EmployeeService {
  //~ Instance-fields --------------------------------------------------------------------------------------------------

  /** employeeRepository. */
  @Autowired
  EmployeeRepository employeeRepository;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * createEmployee.
   *
   * @param   employee  - method parameter employee
   *
   * @return  EmployeeCreateResponse
   */
  public EmployeeCreateResponse createEmployee(Employee employee) {
    Employee savedEmployee = employeeRepository.save(employee);

    EmployeeCreateResponse employeeCreateResponse = new EmployeeCreateResponse();
    employeeCreateResponse.setEmployeeId(savedEmployee.getEmployeeId());

    return employeeCreateResponse;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getAllEmployees.
   *
   * @return  EmployeeGetAllResponse
   */
  public EmployeeGetAllResponse getAllEmployees() {
    Iterable<Employee> employees = employeeRepository.findAll();

    EmployeeGetAllResponse employeeGetAllResponse = new EmployeeGetAllResponse();

    employees.forEach(employee -> employeeGetAllResponse.addEmployee(employee));

    return employeeGetAllResponse;
  }
} // end class EmployeeService
