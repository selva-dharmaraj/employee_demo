package com.example.demo.test.util;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * OrderClass.
 *
 * @author   Selva Dharmaraj
 * @version  $Revision$, 8/19/18
 */
public class OrderedSpringJUnit4ClassRunner extends SpringJUnit4ClassRunner {
  //~ Static-fields/initializers ---------------------------------------------------------------------------------------

  /** logger. */
  private static final Logger logger = LoggerFactory.getLogger(OrderedSpringJUnit4ClassRunner.class);

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new OrderClass object.
   *
   * @param   klass  - constructor parameter klass
   *
   * @throws  InitializationError
   */
  public OrderedSpringJUnit4ClassRunner(Class<?> klass) throws InitializationError {
    super(klass);
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  org.junit.runners.BlockJUnit4ClassRunner#computeTestMethods()
   */
  @Override
  protected List<FrameworkMethod> computeTestMethods() {
    logger.info("Sorting test methods....");

    return super.computeTestMethods()
          .stream()
          .sorted(Comparator.comparingInt((FrameworkMethod fm) ->
                  fm.getAnnotation(Order.class)
                  .order()))
          .collect(Collectors.toList());
  }
} // end class OrderedSpringJUnit4ClassRunner
