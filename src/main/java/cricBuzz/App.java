package cricBuzz;

import cricBuzz.Database.Database;
import cricBuzz.models.InningBatting;
import cricBuzz.models.InningsBowling;
import cricBuzz.models.Overs;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        List<Overs> data = new Database().getAllOvers();
        ArrayList<List<String>> list = new ArrayList<List<String>>();
        for (List<String> i : data.stream().map(Overs::getListOfBall).collect(Collectors.toSet())) {
            list.add(i);
        }
        Database database = new Database();
        Match match = new Match();

        String  team1 = database.team1 ;
        String  team2 = database.team2 ;

        String tossWinnerTeam = match.tossWinner(team1, team2);
        String selected = match.elected();

        String firstInningBowlingTeam ;
        String firstInningBattingTeamName ;

        System.out.println(tossWinnerTeam + " win toss, elect to " + selected + " first. ");

        if(tossWinnerTeam.equals(team1)){
            if(selected.equals("bowl")){
                firstInningBowlingTeam = team1;
                firstInningBattingTeamName = team2;
            }
            else {
                firstInningBowlingTeam = team2;
                firstInningBattingTeamName = team1;
            }

        }
        else {
            if(selected.equals("bowl")){
                firstInningBowlingTeam = team2;
                firstInningBattingTeamName = team1;
            }
            else {
                firstInningBowlingTeam = team1;
                firstInningBattingTeamName = team2;
            }
        }
        String secondInningBowlingTeam = firstInningBattingTeamName;
        String secondInningBattingTeamName = firstInningBowlingTeam;

        List<String> listOfBallForFirstInning = list.get(0);
        List<String> listOfBallForSecondInning = list.get(1);

        List<String> battingOrderOfFirstInning = database.getBattingOrderMapData().get(firstInningBattingTeamName);
        List<String> bowlingOrderOfFirstInning = database.getBowlingOrderMapData().get(firstInningBowlingTeam);

        List<String> battingOrderOfSecondInning = database.getBattingOrderMapData().get(secondInningBattingTeamName);
        List<String> bowlingOrderOfSecondInning = database.getBowlingOrderMapData().get(secondInningBowlingTeam);

        InningBatting firstInningBattingRecords = match.calculateBattingRecords( firstInningBattingTeamName,battingOrderOfFirstInning, listOfBallForFirstInning);
        InningsBowling firstInningBowlingRecords = match.calculateBowlingRecords(firstInningBowlingTeam, bowlingOrderOfFirstInning, listOfBallForFirstInning);
        InningBatting secondInningBattingRecords = match.calculateBattingRecords( secondInningBattingTeamName,battingOrderOfSecondInning, listOfBallForSecondInning);
        InningsBowling secondInningBowlingRecords = match.calculateBowlingRecords(secondInningBowlingTeam, bowlingOrderOfSecondInning, listOfBallForSecondInning);

        match.printScorecardBattingRecords(firstInningBattingRecords,secondInningBattingRecords);
        match.printScorecardBowlingRecords(firstInningBowlingRecords,secondInningBowlingRecords);
        match.winner(firstInningBattingRecords,secondInningBattingRecords);
    }
}
