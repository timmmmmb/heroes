package ch.bfh.tom.promoter.client;

import ch.bfh.tom.promoter.model.Battle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "history-service")
public interface HistoryClient {
    @PostMapping
    Battle saveBattle(@RequestBody Battle battle);
}
