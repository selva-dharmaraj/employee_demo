package com.example.demo.test.controller;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import org.springframework.web.context.WebApplicationContext;

import com.example.demo.DemoApplication;
import com.example.demo.test.util.Order;
import com.example.demo.test.util.OrderedSpringJUnit4ClassRunner;


/**
 * DemoApplicationTests.
 *
 * @author   Selva Dharmaraj
 * @version  $Revision$, 8/19/18
 */
@ContextConfiguration(classes = DemoApplication.class)
@RunWith(OrderedSpringJUnit4ClassRunner.class)
@SpringBootTest
public class DemoApplicationControllerTest {
  //~ Instance-fields --------------------------------------------------------------------------------------------------

  /** logger. */
  Logger logger = LoggerFactory.getLogger(getClass());

  /** mocMvc. */
  private MockMvc mockMvc;

  /** webApplicationContext. */
  @Autowired
  private WebApplicationContext webApplicationContext;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * contextLoads.
   */
  @Before
  public void contextLoads() {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
          .build();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * testAddEmployee.
   *
   * @throws  Exception
   */
  @Order(order = 2)
  @Test
  public void testAddEmployee() throws Exception {
    logger.info("\nTesting add employee");
    mockMvc.perform(
        MockMvcRequestBuilders.post("/empservice/employee")
              .contentType(MediaType.APPLICATION_JSON)
              .content(
                  "{ \"firstName\": \"Selva\", \"lastName\": \"Dharmaraj\", \"departmentName\": \"Development\" }")
              .accept(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.employeeId").exists())
        .andDo(print());
    logger.info("Testing add employee\n");
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * testValidateGetAllEmployees.
   *
   * @throws  Exception
   */
  @Order(order = 1)
  @Test
  public void testGetAllEmployees() throws Exception {
    logger.info("\nTesting get all employees");
    mockMvc.perform(MockMvcRequestBuilders.get("/empservice/employees")
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath(
              "$.employees",
              hasSize(4)))
        .andDo(print());
    logger.info("Testing get all employees\n");
  }

} // end class DemoApplicationControllerTest
