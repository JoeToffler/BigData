package com.xahi.reporteddata;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"com.xahi"})
@EnableScheduling
public class DongguanReporteddataApplication {
    @Value("account.accessId")
    public String accessId;

    @Value("account.accessPwd")
    public String accessPwd;

    public static void main(String[] args) {
        SpringApplication.run(DongguanReporteddataApplication.class, args);
    }

}
