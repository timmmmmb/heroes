package ch.bfh.tom.frontend.client;

import ch.bfh.tom.frontend.client.impl.PromoterClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "promoter-service", fallback = PromoterClientFallback.class)
public interface PromoterClient {
    @RequestMapping(value = "/promoteFight")
    String promoteFight();
}
