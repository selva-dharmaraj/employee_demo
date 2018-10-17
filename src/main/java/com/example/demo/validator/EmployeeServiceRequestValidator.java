package com.example.demo.validator;

import org.springframework.stereotype.Component;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.demo.domain.Employee;


/**
 * EmployeeServiceRequestValidator.
 *
 * @author   Selva Dharmaraj
 * @version  $Revision$, 8/13/18
 */
@Component
public class EmployeeServiceRequestValidator implements Validator {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  org.springframework.validation.Validator#supports(java.lang.Class)
   */
  @Override
  public boolean supports(Class<?> aClass) {
    return Employee.class.getName()
          .equalsIgnoreCase(aClass.getName());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
   */
  @Override
  public void validate(Object o, Errors errors) {
    Employee employee = (Employee) o;
    System.out.println("Validating Employee Object");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "401", "firstName can not be empty!");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "401", "lastName can not be empty!");

  }
} // end class EmployeeServiceRequestValidator
