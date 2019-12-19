package ch.bfh.tom.camp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CampApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampApplication.class, args);
    }

}
