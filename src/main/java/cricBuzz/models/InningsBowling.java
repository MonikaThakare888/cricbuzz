package cricBuzz.models;

import cricBuzz.models.Bowler;

import java.util.List;

public class InningsBowling {

    public String teamName;
    public List<Bowler> bowlerList;
    public int totalWickets;
    public int totalExtras;

    public InningsBowling() {
    }

    public InningsBowling(String teamName, List<Bowler> bowlerList, int totalWickets, int totalExtras) {
        this.teamName = teamName;
        this.bowlerList = bowlerList;
        this.totalWickets = totalWickets;
        this.totalExtras = totalExtras;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<Bowler> getBowlerList() {
        return bowlerList;
    }

    public void setBowlerList(List<Bowler> bowlerList) {
        this.bowlerList = bowlerList;
    }

    public int getTotalWickets() {
        return totalWickets;
    }

    public void setTotalWickets(int totalWickets) {
        this.totalWickets = totalWickets;
    }

    public int getTotalExtras() {
        return totalExtras;
    }

    public void setTotalExtras(int totalExtras) {
        this.totalExtras = totalExtras;
    }

    @Override
    public String toString() {
        return "InningsBowling{" +
                "teamName='" + teamName + '\'' +
                ", bowlerList=" + bowlerList +
                ", totalWickets=" + totalWickets +
                ", totalExtras=" + totalExtras +
                '}';
    }
}
