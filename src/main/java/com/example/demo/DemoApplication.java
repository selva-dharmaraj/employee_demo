package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

import com.example.demo.domain.Employee;
import com.example.demo.test.service.EmployeeService;


/**
 * DemoApplication.
 *
 * @author   Selva Dharmaraj
 * @version  $Revision$, 8/13/18
 */
@SpringBootApplication(scanBasePackages = { "com.example.demo" })
public class DemoApplication {
  //~ Instance-fields --------------------------------------------------------------------------------------------------

  /** employeeService. */
  @Autowired
  EmployeeService employeeService;

  /** logger. */
  Logger logger = LoggerFactory.getLogger(getClass());

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * main.
   *
   * @param  args  - method parameter args
   */
  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setup.
   *
   * @return  CommandLineRunner
   */
  @Bean
  public CommandLineRunner setup() {
    return
      (args) -> {
      employeeService.createEmployee(new Employee("first name 1", "last name 1", "Development"));
      employeeService.createEmployee(new Employee("first name 2", "last name 2", "Development"));
      employeeService.createEmployee(new Employee("first name 3", "last name 3", "Development"));
      employeeService.createEmployee(new Employee("first name 4", "last name 4", "Development"));
    };
  }

} // end class DemoApplication
