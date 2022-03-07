package com.okg.hello.config;

import com.okg.hello.job.QuartzJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Quartz定时组件配置类，主要用于定义（配置）任务详情和任务触发器
 */
@Configuration
public class QuartzConfig {
    private static final String DEMO_TASK_IDENTITY = "demoTaskQuartz";

    /**
     * 定义任务详情
     *
     * @return
     */
    @Bean
    public JobDetail quartzDetail() {
        //指定job的名称和持久化保存任务
        return JobBuilder.newJob(QuartzJob.class).withIdentity(DEMO_TASK_IDENTITY).storeDurably().build();
    }

    /**
     * 定义触发器
     *
     * @return
     */
    @Bean
    public Trigger quartzTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(15)   // 设置时间间隔，单位为s
//                .withIntervalInHours(2)      // 两小时执行一次
                .repeatForever();            // 无限重复
        return TriggerBuilder.newTrigger().forJob(quartzDetail())// 任务详情
                .withIdentity(DEMO_TASK_IDENTITY)
                .withSchedule(scheduleBuilder)//添加定时调度器时钟
                .build();
    }

}
