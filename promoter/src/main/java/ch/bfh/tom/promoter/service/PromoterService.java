package ch.bfh.tom.promoter.service;

import ch.bfh.tom.promoter.model.Battle;
import ch.bfh.tom.promoter.model.Camp;

public interface PromoterService {

    Battle promoteFight(String campID);
    Camp rewardCamp(Battle battle);
}
