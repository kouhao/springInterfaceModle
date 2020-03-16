package com.kouhao.spring.web;

import com.kouhao.spring.service.BeanFactoryAwareTest;
import com.kouhao.spring.service.BeanNameAwareTest;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kh
 * @date 2020/3/16 16:25
 */
@RestController("/")
public class TestController {

  @Resource
  BeanNameAwareTest beanNameAwareTest;

  @Resource
  BeanFactoryAwareTest beanFactoryAwareTest;

  @RequestMapping("/getBeanName")
  public String getBeanName() {
    return beanNameAwareTest.getBeanName();
  }

  @RequestMapping("/getBeanFactory")
  public String getBeanFactory() {
    return beanFactoryAwareTest.getBeanFactory().toString();
  }
}
