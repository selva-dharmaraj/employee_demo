package com.example.demo.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.model.ErroResponse;


/**
 * EmployeeControllerExceptionAdvice.
 *
 * @author   Selva Dharmaraj
 * @version  $Revision$, 8/13/18
 */
@ControllerAdvice
public class EmployeeControllerExceptionAdvice extends ResponseEntityExceptionHandler {
  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new EmployeeControllerExceptionAdvice object.
   */
  public EmployeeControllerExceptionAdvice() {
    super();
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * handleJdbcSQLException.
   *
   * @param   ex       - method parameter ex
   * @param   headers  - method parameter headers
   * @param   status   - method parameter status
   * @param   request  - method parameter request
   *
   * @return  ResponseEntity
   */
  @ExceptionHandler({ Exception.class })
  protected ResponseEntity<Object> handleAll(Exception ex, HttpHeaders headers,
      HttpStatus status,
      WebRequest request) {
    ErroResponse erroResponse = new ErroResponse();
    erroResponse.setErrorCode("DB_EROR");
    erroResponse.setErrorDescription(ex.getMessage());
    erroResponse.setErrorTrace(ex.toString());

    return new ResponseEntity<>(erroResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler#handleMethodArgumentNotValid(org.springframework.web.bind.MethodArgumentNotValidException,
   *       org.springframework.http.HttpHeaders, org.springframework.http.HttpStatus,
   *       org.springframework.web.context.request.WebRequest)
   */
  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest request) {
    List<String> errors = new ArrayList<String>();

    for (FieldError error : ex.getBindingResult()
          .getFieldErrors()) {
      errors.add(error.getField() + ": " + error.getDefaultMessage());
    }

    for (ObjectError error : ex.getBindingResult()
          .getGlobalErrors()) {
      errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
    }

    ErroResponse erroResponse = new ErroResponse();
    erroResponse.setErrorCode("400");
    erroResponse.setErrorDescription(ex.getMessage());
    erroResponse.setErrorTrace(ex.toString());
    erroResponse.setErrors(errors);

    return new ResponseEntity<>(
        erroResponse,
        HttpStatus.BAD_REQUEST);
  } // end method handleMethodArgumentNotValid

} // end class EmployeeControllerExceptionAdvice
