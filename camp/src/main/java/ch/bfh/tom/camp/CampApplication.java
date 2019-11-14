package ch.bfh.tom.camp;

import ch.bfh.tom.camp.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CampApplication implements ApplicationRunner {

    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(CampApplication.class, args);
    }

    @Autowired
    public void context(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void run(ApplicationArguments args) {
        PartyService partyService = context.getBean(PartyService.class);
        partyService.createParty("Team Tom");
    }
}
