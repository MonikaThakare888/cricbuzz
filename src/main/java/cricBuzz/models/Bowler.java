package cricBuzz.models;

public class Bowler  {

    public String name;
    public int overs;
    public int runsGiven;
    public int wickets;
    public float  economyRate;
    public int fours ;
    public int sixes ;
    public int  extras;

    public Bowler() {
    }

    public Bowler(String name, int overs, int runsGiven, int wickets, float economyRate, int fours, int sixes, int extras) {
        this.name = name;
        this.overs = overs;
        this.runsGiven = runsGiven;
        this.wickets = wickets;
        this.economyRate = economyRate;
        this.fours = fours;
        this.sixes = sixes;
        this.extras = extras;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getExtras() {
        return extras;
    }

    public void setExtras(int extras) {
        this.extras = extras;
    }

    @Override
    public String toString() {
        return "Bowler{" +
                "name='" + name + '\'' +
                ", overs=" + overs +
                ", runsGiven=" + runsGiven +
                ", wickets=" + wickets +
                ", economyRate=" + economyRate +
                ", fours=" + fours +
                ", sixes=" + sixes +
                ", extras=" + extras +
                '}';
    }
}
