// 코드 3-16 com.apress.spring.SpringBootSimpleApplication 클래스 버전12

package com.apress.spring;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootSimpleApplication {
  private static final Logger log = LoggerFactory.getLogger(SpringBootSimpleApplication.class);

  public static void main(String[] args) throws IOException {
    SpringApplication.run(SpringBootSimpleApplication.class, args);
  }

  @Bean
  String info() {
    return "그냥 간단한 문자열 빈입니다.";
  }

  @Autowired
  String info;

  @Bean
  CommandLineRunner myMethod() {
    return args -> {
      log.info("## > CommandLineRunner 구현체...");
      log.info("info 빈에 액세스: " + info);
      for(String arg:args)
	log.info(arg);
    };
  }
}
