package ch.bfh.tom.shop.controller;

import ch.bfh.tom.shop.model.Hero;
import ch.bfh.tom.shop.model.Item;
import ch.bfh.tom.shop.repository.HeroRepository;
import ch.bfh.tom.shop.repository.ItemRepository;
import ch.bfh.tom.shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private HeroRepository heroRepository;

    @GetMapping
    public @ResponseBody Iterable<Item> list() {
        return itemRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Item getItemById(@PathVariable String id) {
        return itemRepository.findById(id).get();
    }

    @GetMapping("/applyItem")
    public @ResponseBody Hero applyItem(@RequestParam String heroID, @RequestParam String itemID) {
        return shopService.applyItem(heroID, itemID);
    }
}