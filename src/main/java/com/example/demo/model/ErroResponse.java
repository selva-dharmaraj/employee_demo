package com.example.demo.model;

import java.util.List;


/**
 * ErroResponse.
 *
 * @author   Selva Dharmaraj
 * @version  $Revision$, 8/13/18
 */
public class ErroResponse {
  //~ Instance-fields --------------------------------------------------------------------------------------------------

  /** errorCode. */
  String errorCode;

  /** errorDescription. */
  String errorDescription;

  /** errors. */
  List<String> errors;

  /** errorTrace. */
  String errorTrace;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getErrorCode.
   *
   * @return  String
   */
  public String getErrorCode() {
    return errorCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getErrorDescription.
   *
   * @return  String
   */
  public String getErrorDescription() {
    return errorDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getErrors.
   *
   * @return  List
   */
  public List<String> getErrors() {
    return errors;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getErrorTrace.
   *
   * @return  String
   */
  public String getErrorTrace() {
    return errorTrace;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setErrorCode.
   *
   * @param  errorCode  - method parameter errorCode
   */
  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setErrorDescription.
   *
   * @param  errorDescription  - method parameter errorDescription
   */
  public void setErrorDescription(String errorDescription) {
    this.errorDescription = errorDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setErrors.
   *
   * @param  errors  - method parameter errors
   */
  public void setErrors(List<String> errors) {
    this.errors = errors;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setErrorTrace.
   *
   * @param  errorTrace  - method parameter errorTrace
   */
  public void setErrorTrace(String errorTrace) {
    this.errorTrace = errorTrace;
  }
} // end class ErroResponse
