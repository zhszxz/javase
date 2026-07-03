package com.bistu.spring6.resourcesLoaderAware;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

//Spring容器context会把自己作为ResourceLoader注入进来
public class TestBean implements ResourceLoaderAware {

    private ResourceLoader resourceLoader;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

}
