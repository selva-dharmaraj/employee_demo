package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.Employee;


/**
 * EmployeeRepository.
 *
 * @author   Selva Dharmaraj
 * @version  $Revision$, 8/13/18
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> { }
