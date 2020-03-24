package com.kouhao.spring.service;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Service;

/**
 * @author kh
 * @date 2020/3/23 22:30
 */
@Service
public class MessageSourceAwareTest implements MessageSourceAware {

  MessageSource messageSource;

  @Override
  public void setMessageSource(MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  public MessageSource getMessageSource() {
    return messageSource;
  }

  @Bean
  public MessageSource messageSource() {
    System.out.println(12222);
    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasename("i18n/Messages");
    messageSource.setDefaultEncoding("utf-8");
    return messageSource;
  }
}
