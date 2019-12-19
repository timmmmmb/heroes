package ch.bfh.tom.arena;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ArenaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArenaApplication.class, args);
    }

}
