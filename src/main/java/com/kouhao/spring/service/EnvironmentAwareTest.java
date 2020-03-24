package com.kouhao.spring.service;

import lombok.Getter;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * 实现EnvironmentAware的 例子
 *
 * @author kh
 * @date 2020/3/24 21:35
 */
@Service
@Getter
public class EnvironmentAwareTest implements EnvironmentAware {

  Environment environment;

  @Override
  public void setEnvironment(Environment environment) {
    this.environment = environment;
  }
}
