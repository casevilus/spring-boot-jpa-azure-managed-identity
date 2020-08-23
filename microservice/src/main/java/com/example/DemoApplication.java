package com.example; /**
 * @author can
 * @date 8/17/20
 */

import com.example.configuration.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class DemoApplication {
    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    @Autowired
    ApplicationContext applicationContext;

    public static void main(String[] args){
        ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

        AppConfig appConfig = ctx.getBean(AppConfig.class);
        appConfig.blobServiceClient();


    }
}
