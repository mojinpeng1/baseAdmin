package com.example.quartzcity.quartz;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;
/**
 * <p>Description：同步城市信息</p>
 *
 * @author mojinpeng
 * @version 1.0
 * @date 2019/12/16 17:24
 */
public class CityQuartz extends SpringBeanJobFactory implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
