package ch.bfh.tom.promoter.client;

import ch.bfh.tom.promoter.client.impl.HistoryClientFallback;
import ch.bfh.tom.promoter.model.Battle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "history-service", fallback = HistoryClientFallback.class)
public interface HistoryClient {
    @PostMapping
    void saveBattle(@RequestBody Battle battle);
}
