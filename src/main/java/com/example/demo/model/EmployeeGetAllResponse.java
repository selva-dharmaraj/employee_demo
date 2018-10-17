package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.domain.Employee;


/**
 * EmployeeGetAllResponse.
 *
 * @author   Selva Dharmaraj
 * @version  $Revision$, 8/13/18
 */
public class EmployeeGetAllResponse {
  //~ Instance-fields --------------------------------------------------------------------------------------------------

  /** employees. */
  List<Employee> employees;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addEmployee.
   *
   * @param  employee  - method parameter employee
   */
  public void addEmployee(Employee employee) {
    if (employees == null) {
      employees = new ArrayList<>();
    }

    employees.add(employee);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getEmployees.
   *
   * @return  List
   */
  public List<Employee> getEmployees() {
    return employees;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setEmployees.
   *
   * @param  employees  - method parameter employees
   */
  public void setEmployees(List<Employee> employees) {
    this.employees = employees;
  }
} // end class EmployeeGetAllResponse
