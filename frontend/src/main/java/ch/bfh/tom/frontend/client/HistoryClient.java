package ch.bfh.tom.frontend.client;

import ch.bfh.tom.frontend.model.History;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "history-service")
public interface HistoryClient {

    @RequestMapping(method = RequestMethod.GET, value = "?campID={campID}")
    History[] getHistory(@PathVariable("campID") String campID);

}
