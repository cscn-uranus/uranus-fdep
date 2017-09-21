package com.cscn.uranus.fdep;

import com.cscn.uranus.fdep.annotation.ExcludeFromTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@ExcludeFromTest
@SpringBootApplication
public class FdepApplication extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(FdepApplication.class);
  }

  public static void main(String[] args) {
    SpringApplication.run(FdepApplication.class, args);
  }
}
