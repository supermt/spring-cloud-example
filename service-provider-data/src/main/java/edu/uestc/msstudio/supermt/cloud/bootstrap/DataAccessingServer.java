package edu.uestc.msstudio.supermt.cloud.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DataAccessingServer
{

    public static void main(String[] args)
    {
        SpringApplication.run(DataAccessingServer.class, args);
    }
    
}
