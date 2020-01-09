package ch.bfh.tom.frontend.client;

import ch.bfh.tom.frontend.client.impl.PromoterClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "promoter-service", fallback = PromoterClientFallback.class)
public interface PromoterClient {
    @RequestMapping(method = RequestMethod.GET, value = "/promoteFight?campID={campID}")
    String promoteFight(@PathVariable("campID") String campID);
}
