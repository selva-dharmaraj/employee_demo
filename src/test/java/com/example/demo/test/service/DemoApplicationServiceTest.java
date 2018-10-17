package com.example.demo.test.service;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

import org.mockito.MockitoAnnotations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;


/**
 * DemoApplicationServiceTest.
 *
 * @author   Selva Dharmaraj
 * @version  $Revision$, 8/19/18
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class DemoApplicationServiceTest {
  //~ Instance-fields --------------------------------------------------------------------------------------------------

  /** employeeRepository. */
  @Mock
  EmployeeRepository employeeRepository;

  /** employeeService. */
  @InjectMocks
  EmployeeService employeeService;

  /** logger. */
  Logger logger = LoggerFactory.getLogger(getClass());

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * setup.
   */
  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * testGetAllEmployees.
   */
  @Test
  public void testGetAllEmployees() {
    logger.info("\nTesting get all employees service ...");

    List<Employee> employees = new ArrayList<>(3);
    employees.add(new Employee(1, "first1", "last1", "depart1"));
    employees.add(new Employee(2, "first2", "last2", "depart2"));
    employees.add(new Employee(3, "first3", "last3", "depart3"));
    logger.info("\tdecalaring mock (when) condition");
    when(employeeRepository.findAll()).thenReturn(employees);

    logger.info("\tevaluating results...\n");
    assertEquals(
      3,
      employeeService.getAllEmployees()
            .getEmployees()
            .size());

  }

} // end class DemoApplicationServiceTest
