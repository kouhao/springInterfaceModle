package com.kouhao.spring.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * ApplicationContextAware
 *
 * @author kh
 * @date 2020/3/16 16:48
 */
@Service
public class ApplicationContextAwareTest implements ApplicationContextAware {

  ApplicationContext applicationContext;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
    System.out.println(
        "AutowireCapableBeanFactory:" + applicationContext.getAutowireCapableBeanFactory()
            .toString());
  }
}
