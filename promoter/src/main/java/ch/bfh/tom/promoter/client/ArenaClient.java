package ch.bfh.tom.promoter.client;

import ch.bfh.tom.promoter.client.impl.ArenaClientFallback;
import ch.bfh.tom.promoter.model.Party;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "arena-service", fallback = ArenaClientFallback.class)
public interface ArenaClient {
    @RequestMapping(method = RequestMethod.POST, value = "/battle")
    String battle(List<Party> challangers);
}
