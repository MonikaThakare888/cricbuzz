package cricBuzz.models;

public class Player {

    String teamName;
    String name ;
    int totalRuns;
    int balls;
    int fours;
    int sixes;
    float strikeRate;
    String wicketType;
    String Status;
    int overs;
    int runsGiven;
    int wickets;
    float economyRate;
    int extrasGiven;

    public Player() {
    }

    public Player( String teamName, String name, int totalRuns, int balls, int fours, int sixes,
                  float strikeRate, String wicketType, String status, int overs,
                  int runsGiven, int wickets, float economyRate, int extrasGiven) {
        this.teamName = teamName;
        this.name = name;
        this.totalRuns = totalRuns;
        this.balls = balls;
        this.fours = fours;
        this.sixes = sixes;
        this.strikeRate = strikeRate;
        this.wicketType = wicketType;
        this.Status = status;
        this.overs = overs;
        this.runsGiven = runsGiven;
        this.wickets = wickets;
        this.economyRate = economyRate;
        this.extrasGiven = extrasGiven;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public void setTotalRuns(int totalRuns) {
        this.totalRuns = totalRuns;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public int getFours() {
        return fours;
    }

    public void setFours(int fours) {
        this.fours = fours;
    }

    public int getSixes() {
        return sixes;
    }

    public void setSixes(int sixes) {
        this.sixes = sixes;
    }

    public float getStrikeRate() {
        return strikeRate;
    }

    public void setStrikeRate(float strikeRate) {
        this.strikeRate = strikeRate;
    }

    public String getWicketType() {
        return wicketType;
    }

    public void setWicketType(String wicketType) {
        this.wicketType = wicketType;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public int getOvers() {
        return overs;
    }

    public void setOvers(int overs) {
        this.overs = overs;
    }

    public int getRunsGiven() {
        return runsGiven;
    }

    public void setRunsGiven(int runsGiven) {
        this.runsGiven = runsGiven;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public float getEconomyRate() {
        return economyRate;
    }

    public void setEconomyRate(float economyRate) {
        this.economyRate = economyRate;
    }

    public int getExtrasGiven() {
        return extrasGiven;
    }

    public void setExtrasGiven(int extrasGiven) {
        this.extrasGiven = extrasGiven;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", totalRuns=" + totalRuns +
                ", balls=" + balls +
                ", fours=" + fours +
                ", sixes=" + sixes +
                ", strikeRate=" + strikeRate +
                ", wicketType='" + wicketType + '\'' +
                ", Status='" + Status + '\'' +
                ", overs=" + overs +
                ", runsGiven=" + runsGiven +
                ", wickets=" + wickets +
                ", economyRate=" + economyRate +
                ", extrasGiven=" + extrasGiven +
                '}';
    }
}
