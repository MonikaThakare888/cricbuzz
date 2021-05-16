package cricBuzz.models;

import cricBuzz.models.Batsmen;

import java.util.List;

public class InningBatting {

    public String teamName;
    public List<Batsmen> batsmenList;
    public int totalWickets;
    public int totalExtras ;
    public int totalRuns;

    public InningBatting() {
    }

    public InningBatting(String teamName, List<Batsmen> batsmenList, int totalWickets, int totalExtras, int totalRuns) {
        this.teamName = teamName;
        this.batsmenList = batsmenList;
        this.totalWickets = totalWickets;
        this.totalExtras = totalExtras;
        this.totalRuns = totalRuns;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<Batsmen> getBatsmenList() {
        return batsmenList;
    }

    public void setBatsmenList(List<Batsmen> batsmenList) {
        this.batsmenList = batsmenList;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public void setTotalRuns(int totalRuns) {
        this.totalRuns = totalRuns;
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
        return "InningBatting{" +
                "teamName='" + teamName + '\'' +
                ", batsmenList=" + batsmenList +
                ", totalWickets=" + totalWickets +
                ", totalExtras=" + totalExtras +
                ", totalRuns=" + totalRuns +
                '}';
    }
}
