package io.marmer.github.demo.novatecsummit2023demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestNovatecSummit2023DemoApplication {

  public static void main(String[] args) {
    SpringApplication.from(NovatecSummit2023DemoApplication::main)
        .with(TestNovatecSummit2023DemoApplication.class).run(args);
  }

}
