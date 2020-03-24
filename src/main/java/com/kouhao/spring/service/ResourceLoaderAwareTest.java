package com.kouhao.spring.service;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

/**
 * 获取资源加载器，可以获得外部资源文件
 *
 * @author kh
 * @date 2020/3/23 21:57
 */
@Service
public class ResourceLoaderAwareTest implements ResourceLoaderAware {

  private ResourceLoader loader;

  @Override
  public void setResourceLoader(ResourceLoader resourceLoader) {
    this.loader = resourceLoader;
  }

  public ResourceLoader getLoader() {
    return loader;
  }
}
