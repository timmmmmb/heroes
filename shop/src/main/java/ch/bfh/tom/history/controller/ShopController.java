package ch.bfh.tom.history.controller;

import ch.bfh.tom.history.model.Item;
import ch.bfh.tom.history.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public @ResponseBody Iterable<Item> list() {
        return itemRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Item getItemById(@PathVariable String id) {
        return itemRepository.findById(id).get();
    }
}
