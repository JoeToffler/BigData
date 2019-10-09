package com.xahi.reporteddata;

import com.xahi.reporteddata.schedule.ScheduleTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"com.xahi"})
@EnableScheduling
public class DongguanReporteddataApplication implements ApplicationRunner {

    @Autowired
    ScheduleTask scheduleTask;

    @Value("account.accessId")
    public String accessId;

    @Value("account.accessPwd")
    public String accessPwd;

    @Override
    public void run(ApplicationArguments args){
        scheduleTask.uploadHouse();
        scheduleTask.uploadAuth();
        scheduleTask.uploadRecord();
        scheduleTask.uploadTenant();
        scheduleTask.uploadTerminal();
    }

    public static void main(String[] args) {
        SpringApplication.run(DongguanReporteddataApplication.class, args);
    }

}
