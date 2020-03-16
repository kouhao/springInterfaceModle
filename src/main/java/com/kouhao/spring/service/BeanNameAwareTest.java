package com.kouhao.spring.service;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * BeanNameAware 测试例子
 *
 * @author kh
 * @date 2020/3/16 11:17
 */
@Service
public class BeanNameAwareTest implements BeanNameAware {

  private String beanName;

  @Override
  public void setBeanName(String beanName) {
    this.beanName = beanName;
    System.out.println("MyBeanName-setBeanName:"+beanName);
  }

  public String getBeanName() {
    return beanName;
  }
}
