package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/**
 * WebConfiguration.
 *
 * @author   Selva Dharmaraj
 * @version  $Revision$, 8/16/18
 */
@ComponentScan(basePackages = { "com.example.demo" })
@Configuration
@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer {
  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new WebConfiguration object.
   */
  public WebConfiguration() {
    super();
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addViewControllers(org.springframework.web.servlet.config.annotation.ViewControllerRegistry)
   */
  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/homepage.html");
    registry.addViewController("/info");
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  org.springframework.web.servlet.config.annotation.WebMvcConfigurer#configureDefaultServletHandling(org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer)
   */
  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * viewResolver.
   *
   * @return  ViewResolver
   */
  @Bean
  public InternalResourceViewResolver viewResolver() {
    InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
    internalResourceViewResolver.setPrefix("/WEB-INF/view/");
    internalResourceViewResolver.setSuffix(".html");

    return internalResourceViewResolver;
  }
} // end class WebConfiguration
