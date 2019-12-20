//package com.example.quartzcity.configs;
//
//import com.example.quartzcity.job.MyCronJob;
//import com.example.quartzcity.job.MyJob;
//import com.example.quartzcity.job.SyncCityJob;
//import org.quartz.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * <p>Description：定时器配置</p>
// *
// * @author mojinpeng
// * @version 1.0
// * @date 2019/12/17 14:39
// */
//@Configuration
//public class QuartzConfiguration {
//
//    // 使用jobdetail包装 job
//    @Bean
//    public JobDetail myJobDetail() {
//        return JobBuilder.newJob(MyJob.class).withIdentity("myJob").storeDurably().build();
//    }
//
//    // 把jobDetail注册到trigger上去
//    @Bean
//    public Trigger myJobTrigger() {
//        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(15).repeatForever();
//        return TriggerBuilder.newTrigger().
//                forJob(myJobDetail())
//                .withIdentity("myJobTrigger")
//                .withSchedule(simpleScheduleBuilder).build();
//    }
//
//
//    /**
//     * cron的定时任务
//     */
//    @Bean
//    public JobDetail myCronJobDetail() {
//        return JobBuilder.newJob(MyCronJob.class).withIdentity("myCronJob").storeDurably().build();
//    }
//
//
//
//    @Bean
//    public Trigger cronJobTrigger() {
//        CronScheduleBuilder cronSchedule = CronScheduleBuilder.cronSchedule("0/30 * * * * ?");
//        return TriggerBuilder.newTrigger().forJob(myCronJobDetail())
//                .withIdentity("myCronJobTrigger")
//                .withSchedule(cronSchedule)
//                .build();
//    }
//
//
//
//    // 使用jobdetail包装 job
//    @Bean
//    public JobDetail cityDetail() {
//        return JobBuilder.newJob(SyncCityJob.class).withIdentity("cityDetail").storeDurably().build();
//    }
//
//    // 把jobDetail注册到trigger上去
//    @Bean
//    public Trigger cityDetailTrigger() {
//        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(60).repeatForever();
//        return TriggerBuilder.newTrigger().
//                forJob(cityDetail())
//                .withIdentity("cityDetailTrigger")
//                .withSchedule(simpleScheduleBuilder).build();
//    }
//
//}
