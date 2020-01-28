package ch.bfh.tom.promoter.client;

import ch.bfh.tom.promoter.model.Battle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "history-service")
public interface HistoryClient {
    @RequestMapping(method = RequestMethod.POST, value = "/")
    void saveBattle(@RequestBody Battle battle);
}
