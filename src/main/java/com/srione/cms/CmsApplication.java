package com.srione.cms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableJpaRepositories
public class CmsApplication {

    public static Logger LOGGER = LoggerFactory.getLogger(CmsApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class, args);
        System.out.println("hello how are you???");
        for(int i=0;i<11;i++){
            LOGGER.info("welcome to the numeric world--->> "+i+"\n");
        }
    }

}
