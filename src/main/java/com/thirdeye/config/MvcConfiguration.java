package com.thirdeye.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfiguration extends WebMvcConfigurerAdapter {

  /*@Bean
  public MultipartResolver multipartResolver() {
    *//*CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
    commonsMultipartResolver.setMaxUploadSize(5000000); //5 MB
    return commonsMultipartResolver;*//*

    return new StandardServletMultipartResolver();
  }*/

  /*@Bean
  public ServletContextTemplateResolver thymeleafResolver() {
    ServletContextTemplateResolver thymeleafResolver = new ServletContextTemplateResolver();
    thymeleafResolver.setPrefix("/WEB-INF/views/templates/");
    thymeleafResolver.setSuffix(".html");
    thymeleafResolver.setCacheable(false);

    return thymeleafResolver;
  }

  @Bean
  public SpringTemplateEngine thymeleafTemplateEngine() {
    SpringTemplateEngine thymeleafTemplateEngine = new SpringTemplateEngine();
    thymeleafTemplateEngine.setTemplateResolver(thymeleafResolver());

    return thymeleafTemplateEngine;
  }

  @Bean
  public ThymeleafViewResolver thymeleafViewResolver() {
    ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
    thymeleafViewResolver.setTemplateEngine(thymeleafTemplateEngine());
    thymeleafViewResolver.setOrder(1);

    return thymeleafViewResolver;
  }*/
}
