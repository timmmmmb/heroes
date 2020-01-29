package ch.bfh.tom.frontend.model;

public class History {
    private String id;
    private String challengerID;
    private String challengeeID;
    private String winnerID;

    private String result;

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

