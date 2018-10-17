package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * Employee.
 *
 * @author   Selva Dharmaraj
 * @version  $Revision$, 8/13/18
 */
@Entity
public class Employee {
  //~ Instance-fields --------------------------------------------------------------------------------------------------

  /** departmentName. */
  String departmentName;

  /** employeeId. */
  @GeneratedValue
  @Id
  Integer employeeId;

  /** firstName. */
  @Column(
    nullable = false,
    unique   = true
  )
  String firstName;

  /** lastName. */
  @Column
  String lastName;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new Employee object.
   */
  public Employee() { }

  /**
   * Creates a new Employee object.
   *
   * @param  firstName       - constructor parameter firstName
   * @param  lastName        - constructor parameter lastName
   * @param  departmentName  - constructor parameter departmentName
   */
  public Employee(String firstName, String lastName, String departmentName) {
    this.firstName      = firstName;
    this.lastName       = lastName;
    this.departmentName = departmentName;
  }

  /**
   * Creates a new Employee object.
   *
   * @param  employeeId      - constructor parameter employeeId
   * @param  firstName       - constructor parameter firstName
   * @param  lastName        - constructor parameter lastName
   * @param  departmentName  - constructor parameter departmentName
   */
  public Employee(Integer employeeId, String firstName, String lastName, String departmentName) {
    this.employeeId     = employeeId;
    this.firstName      = firstName;
    this.lastName       = lastName;
    this.departmentName = departmentName;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getDepartmentName.
   *
   * @return  String
   */
  public String getDepartmentName() {
    return departmentName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getEmployeeId.
   *
   * @return  Integer
   */
  public Integer getEmployeeId() {
    return employeeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getFirstName.
   *
   * @return  String
   */
  public String getFirstName() {
    return firstName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getLastName.
   *
   * @return  String
   */
  public String getLastName() {
    return lastName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setDepartmentName.
   *
   * @param  departmentName  - method parameter departmentName
   */
  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setEmployeeId.
   *
   * @param  employeeId  - method parameter employeeId
   */
  public void setEmployeeId(Integer employeeId) {
    this.employeeId = employeeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setFirstName.
   *
   * @param  firstName  - method parameter firstName
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setLastName.
   *
   * @param  lastName  - method parameter lastName
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
} // end class Employee
