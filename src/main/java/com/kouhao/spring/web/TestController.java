package com.kouhao.spring.web;

import com.kouhao.spring.service.BeanFactoryAwareTest;
import com.kouhao.spring.service.BeanNameAwareTest;
import com.kouhao.spring.service.EnvironmentAwareTest;
import com.kouhao.spring.service.MessageSourceAwareTest;
import com.kouhao.spring.service.ResourceLoaderAwareTest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Locale;
import java.util.Properties;
import javax.annotation.Resource;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
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

  @Resource
  ResourceLoaderAwareTest resourceLoaderAwareTest;

  @Resource
  MessageSourceAwareTest messageSourceAwareTest;

  /**
   * 获取beanName
   */
  @RequestMapping("/getBeanName")
  public String getBeanName() {
    return beanNameAwareTest.getBeanName();
  }

  /**
   * 获取beanFactory
   */
  @RequestMapping("/getBeanFactory")
  public String getBeanFactory() {
    return beanFactoryAwareTest.getBeanFactory().toString();
  }

  /**
   * 获取Resource信息
   */
  @RequestMapping("/getResource")
  public String getResource() throws IOException {
    ResourceLoader loader = resourceLoaderAwareTest.getLoader();
    InputStream inputStream = loader.getResource("classpath:resource.properties").getInputStream();
    Properties properties = new Properties();
    properties.load(inputStream);
    StringBuilder sb = new StringBuilder();
    for (Iterator <Object> keys = properties.keySet().iterator(); keys.hasNext(); ) {
      String key = keys.next().toString();
      sb.append("key=" + key + ";value=" + properties.getProperty(key));
    }
    return sb.toString();
  }

  /**
   * 获取MessageSource 中的信息
   */
  @RequestMapping("/getMessageSource")
  public String getMessageSource() throws IOException {
    MessageSource messageSource = messageSourceAwareTest
        .getMessageSource();

    String message = messageSource.getMessage("welcome.msg", null, Locale.SIMPLIFIED_CHINESE);
    String message2 = messageSource.getMessage("welcome.msg", null, Locale.US);
    return message;
  }

  @Resource
  EnvironmentAwareTest environmentAwareTest;

  @RequestMapping("/getEnvironment")
  public String getEnvironment() throws IOException {
    Environment environment = environmentAwareTest.getEnvironment();
    String[] profiles = environment.getDefaultProfiles();
    System.out.println(profiles);
    String name = environment.getProperty("test.name");
    return name;
  }
}
