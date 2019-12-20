package com.example.quartzcity.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * <p>Description：Cron  任务</p>
 *
 * @author mojinpeng
 * @version 1.0
 * @date 2019/12/17 14:37
 */
@Slf4j
public class MyCronJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
      log.warn("任务执行了");
    }
}
