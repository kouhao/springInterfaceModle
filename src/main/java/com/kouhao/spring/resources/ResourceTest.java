package com.kouhao.spring.resources;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author kh
 * @date 2020/3/23 23:28
 */
@Component
public class ResourceTest implements CommandLineRunner {


  @Override
  public void run(String... args) throws Exception {
    System.out.println(args);
  }
}
