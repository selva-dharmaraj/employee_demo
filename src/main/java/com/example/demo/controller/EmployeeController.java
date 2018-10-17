package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Employee;
import com.example.demo.model.EmployeeCreateResponse;
import com.example.demo.model.EmployeeGetAllResponse;
import com.example.demo.test.service.EmployeeService;
import com.example.demo.validator.EmployeeServiceRequestValidator;


/**
 * EmployeeController.
 *
 * @author   Selva Dharmaraj
 * @version  $Revision$, 8/13/18
 */
@RequestMapping(value = "/empservice")
@RestController
public class EmployeeController {
  //~ Instance-fields --------------------------------------------------------------------------------------------------

  /** employeeService. */
  @Autowired
  EmployeeService employeeService;

  /** employeeServiceRequestValidator. */
  @Autowired
  EmployeeServiceRequestValidator employeeServiceRequestValidator;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * createEmployee.
   *
   * @param   employee  - method parameter employee
   *
   * @return  ResponseEntity
   */
  @RequestMapping(
    value  = "/employee",
    method = RequestMethod.POST
  )
  public ResponseEntity<EmployeeCreateResponse> createEmployee(@RequestBody @Valid Employee employee) {
    EmployeeCreateResponse createResponse = employeeService.createEmployee(employee);

    return new ResponseEntity<>(createResponse, HttpStatus.CREATED);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getAllEmployees.
   *
   * @return  ResponseEntity
   */
  @RequestMapping(value = "/employees")
  public ResponseEntity<EmployeeGetAllResponse> getAllEmployees() {
    EmployeeGetAllResponse employeeGetAllResponse = employeeService.getAllEmployees();

    return new ResponseEntity<>(employeeGetAllResponse, HttpStatus.OK);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * initBinder.
   *
   * @param  binder  - method parameter binder
   */
  @InitBinder
  protected void initBinder(WebDataBinder binder) {
    binder.setValidator(employeeServiceRequestValidator);
  }

} // end class EmployeeController
