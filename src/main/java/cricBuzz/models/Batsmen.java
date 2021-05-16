package cricBuzz.models;

public class Batsmen  {

    public String name;
    public int runs;
    public int balls;
    public int fours;
    public int sixes;
    public float strikeRate;
    public String wicketType;
    public String Status;

    public Batsmen() {
    }

    public Batsmen(String name, int runs, int balls, int fours, int sixes, float strikeRate, String wicketType, String status) {
        this.name = name;
        this.runs = runs;
        this.balls = balls;
        this.fours = fours;
        this.sixes = sixes;
        this.strikeRate = strikeRate;
        this.wicketType = wicketType;
        Status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
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

    @Override
    public String toString() {
        return "Batsmen{" +
                "name='" + name + '\'' +
                ", runs=" + runs +
                ", balls=" + balls +
                ", fours=" + fours +
                ", sixes=" + sixes +
                ", strikeRate=" + strikeRate +
                ", wicketType='" + wicketType + '\'' +
                ", Status='" + Status + '\'' +
                '}';
    }
}
