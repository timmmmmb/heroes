package ch.bfh.tom.history.controller;

import ch.bfh.tom.history.repository.BattleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/history")
public class ShopController {

    @Autowired
    private BattleRepository battleRepository;


}
