package cricBuzz.models;

import java.util.List;

public class Overs {
    public String inning;
    public List<String> listOfBall;

    public Overs() {
    }

    public Overs(String inning, List<String> listOfBall) {
        this.inning = inning;
        this.listOfBall = listOfBall;
    }

    public String getInning() {
        return inning;
    }

    public void setInning(String inning) {
        this.inning = inning;
    }

    public List<String> getListOfBall() {
        return listOfBall;
    }

    public void setListOfBall(List<String> listOfBall) {
        this.listOfBall = listOfBall;
    }

    @Override
    public String toString() {
        return "Overs{" +
                "inning='" + inning + '\'' +
                ", ListOfBall=" + listOfBall +
                '}';
    }
}
