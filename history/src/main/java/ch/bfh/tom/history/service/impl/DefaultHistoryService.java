package ch.bfh.tom.history.service.impl;

import ch.bfh.tom.history.repository.BattleRepository;
import ch.bfh.tom.history.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultHistoryService implements HistoryService {

    @Autowired
    private BattleRepository battleRepository;

}
