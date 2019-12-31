package ch.bfh.tom.frontend.client.impl;

import ch.bfh.tom.frontend.client.PromoterClient;
import org.springframework.stereotype.Component;

@Component
public class PromoterClientFallback implements PromoterClient {
    @Override
    public String promoteFight() {
        System.out.println("Using Fallback");
        return "No fight today";
    }
}
