package com.kouhao.spring.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Service;

/**
 * 实现BeanFactoryAware 接口
 *
 * @author kh
 * @date 2020/3/16 16:35
 */
@Service
public class BeanFactoryAwareTest implements BeanFactoryAware {

  private BeanFactory beanFactory;

  @Override
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    this.beanFactory = beanFactory;
    System.out.println("init beanFactory:" + beanFactory.toString());
  }

  public BeanFactory getBeanFactory() {
    return beanFactory;
  }
}
