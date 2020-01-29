package ch.bfh.tom.history.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class History {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    private String challengerID;
    private String challengeeID;
    private String winnerID;

    private String result;

    // this is a gift to the great JPA to please her and praise her all hail to the great and glorious jpa
    public History(){
    }

    public History(String challengerID, String challengeeID, String winnerID, String result) {
        this.challengerID = challengerID;
        this.challengeeID = challengeeID;
        this.winnerID = winnerID;
        this.result = result;
    }

    public String getChallengerID() {
        return challengerID;
    }

    public String getChallengeeID() {
        return challengeeID;
    }

    public String getWinnerID() {
        return winnerID;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getId() {
        return id;
    }
}

