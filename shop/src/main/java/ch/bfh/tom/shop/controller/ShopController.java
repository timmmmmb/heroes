package ch.bfh.tom.shop.controller;

import ch.bfh.tom.shop.model.Item;
import ch.bfh.tom.shop.repository.ItemRepository;
import ch.bfh.tom.shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public @ResponseBody
    Iterable<Item> list() {
        return itemRepository.findAll();
    }

}
