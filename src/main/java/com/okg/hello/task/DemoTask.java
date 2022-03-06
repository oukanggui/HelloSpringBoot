package com.okg.hello.task;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务类，需要继承QuartzJobBean，定时任务时间到时，会执行改定时任务
 */
@Slf4j
@Component //DemoTask任务类交给spring容器管理
public class DemoTask extends QuartzJobBean {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("DemoTask执行：" + sdf.format(new Date()));
    }
}