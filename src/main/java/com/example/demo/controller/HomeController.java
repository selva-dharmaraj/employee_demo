package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


/**
 * HomeController.
 *
 * @author   Selva Dharmaraj
 * @version  $Revision$, 8/16/18
 */
@Controller
public class HomeController {
  //~ Instance-fields --------------------------------------------------------------------------------------------------

  /** logger. */
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * homepage.
   *
   * @return  String
   */
  @RequestMapping("/")
  public String index() {
    logger.info("Redirecting to home page");

    return "homepage";
  }
}
