package ch.bfh.tom.camp;

import ch.bfh.tom.camp.service.PartyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfiguration.class);
        PartyService partyService = context.getBean(PartyService.class);
        partyService.createParty("Team Tom");
        context.close();
    }
}
