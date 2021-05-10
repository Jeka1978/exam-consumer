package com.epam.examconsumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

@SpringBootApplication
@EnableAsync
@EnableScheduling
@EnableRetry
@EnableCaching


//@ImportResource("classpath:context.xml")
public class ExamConsumerApplication {





  /*  @Bean  example how you can declare bean which is not from your class
    public Friend1 friend1(){
        return new Friend1();
    }
*/















    public static void main(String[] args) {


        ConfigurableApplicationContext context =
                SpringApplication.run(ExamConsumerApplication.class, args);
        ConsumerFlowManager flowManager = context.getBean(ConsumerFlowManager.class);
    }

}
