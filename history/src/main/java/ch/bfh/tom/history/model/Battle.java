package ch.bfh.tom.history.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Battle {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    private Camp challenger;
    private Camp challengee;
    private Camp winner;
    private String result;

    public Camp getChallenger() {
        return challenger;
    }

    public void setChallenger(Camp challenger) {
        this.challenger = challenger;
    }

    public Camp getChallengee() {
        return challengee;
    }

    public void setChallengee(Camp challengee) {
        this.challengee = challengee;
    }

    public Camp getWinner() {
        return winner;
    }

    public void setWinner(Camp winner) {
        this.winner = winner;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
