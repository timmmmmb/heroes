package ch.bfh.tom.frontend.client;

import ch.bfh.tom.frontend.model.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "shop-service")
public interface ShopClient {

    @RequestMapping(method = RequestMethod.GET, value = "/shop")
    Iterable<Item> shop();

    @RequestMapping(method = RequestMethod.GET, value = "/shop/{id}")
    Item getShopItem(@PathVariable("id") String id);
}
