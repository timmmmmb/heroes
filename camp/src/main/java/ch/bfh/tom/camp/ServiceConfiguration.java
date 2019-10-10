package ch.bfh.tom.camp;

import ch.bfh.tom.camp.impl.HeroServiceImpl;
import ch.bfh.tom.camp.impl.PartyServiceImpl;
import ch.bfh.tom.camp.service.HeroService;
import ch.bfh.tom.camp.service.PartyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {
    @Bean
    public HeroService heroService() {
        return new HeroServiceImpl();
    }

    @Bean
    public PartyService campService(HeroService heroService) {
        return new PartyServiceImpl(heroService);
    }
}
