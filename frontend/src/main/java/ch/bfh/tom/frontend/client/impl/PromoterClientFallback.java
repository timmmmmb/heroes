package ch.bfh.tom.frontend.client.impl;

import ch.bfh.tom.frontend.client.PromoterClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PromoterClientFallback implements PromoterClient {
    @Override
    public String promoteFight() {
        return "No fight today";
    }
}
