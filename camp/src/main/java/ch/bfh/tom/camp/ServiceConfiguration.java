package ch.bfh.tom.camp;

import ch.bfh.tom.camp.service.impl.DefaultHeroService;
import ch.bfh.tom.camp.service.impl.DefaultPartyService;
import ch.bfh.tom.camp.service.HeroService;
import ch.bfh.tom.camp.service.PartyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {
    @Bean
    public HeroService heroService() {
        return new DefaultHeroService();
    }

    @Bean
    public PartyService campService(HeroService heroService) {
        return new DefaultPartyService(heroService);
    }
}
