package ch.bfh.tom.camp;

import ch.bfh.tom.camp.service.CampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CampApplicationRunner implements ApplicationRunner {
    private static ArrayList<String> images = new ArrayList<>();

    private CampService campService;
    @Autowired
    public void context(CampService campService) {
        this.campService = campService;
    }

    @Override
    public void run(ApplicationArguments args) {
        for(int i = 1; i<=40; i++){
            images.add("/images/heroProfiles/"+i+".png");
        }

        campService.createCamp("Team Tom");
        campService.createCamp("Tom Team");
    }

    public static ArrayList<String> getImages() {
        return images;
    }
}
