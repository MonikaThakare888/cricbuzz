package cricBuzz;

import cricBuzz.Database.Database;
import cricBuzz.models.Batsmen;
import cricBuzz.models.Bowler;
import cricBuzz.models.InningBatting;
import cricBuzz.models.InningsBowling;

import java.util.ArrayList;
import java.util.List;

public class Match {
  public Match()  {
    }
    Database database = new Database();
    public List<List<String>> listOfOvers(List<String> listOfBallForFirstInning) {
        List<List<String>> listOfOvers = new ArrayList<List<String>>();
        int index = 0;
        int tale = 6;
        for (int i = 0; i < listOfBallForFirstInning.size(); i++) {
          List<String> eachOver = listOfBallForFirstInning.subList(index, tale);
          if(eachOver.contains("WD") &&  eachOver.contains("NB")) {
               tale = tale + 2;
               listOfOvers.add(listOfBallForFirstInning.subList(index, tale));
            }
           else if(eachOver.contains("WD")||  eachOver.contains("NB") ) {

              if (eachOver.contains("WD")) {
                  tale = tale + 1;
                  listOfOvers.add(listOfBallForFirstInning.subList(index, tale));
              }
              if  (eachOver.contains("NB")) {
                  tale = tale + 1;
                  listOfOvers.add(listOfBallForFirstInning.subList(index, tale));
              }
          }
            else{
                listOfOvers.add(listOfBallForFirstInning.subList(index, tale));
            }
            i = tale;
            index = tale;
            tale = tale + 6;
            if(tale >= listOfBallForFirstInning.size()){
                break;
            }
        }
       return listOfOvers;
    }

    public InningBatting calculateBattingRecords(String teamName, List<String> battingOrderOfFirstInning , List<String> listOfBallForFirstInning) {
        int index = 0;
        int totalWickets = 0; int totalRun = 0; int totalExtras = 0;
        List<Batsmen> batsmenList = new ArrayList<>();
        for(int i = 0 ; i < listOfBallForFirstInning.size() ;i++){
        String status = "";
        String wicketType = "";
        int fours = 0;
        int sixes = 0;
        int extras = 0;
        int runs = 0;
        float strikeRate;
        int balls = 0;
        for (int j = i ; j < listOfBallForFirstInning.size(); j++) {
            if (listOfBallForFirstInning.get(j).equals("1") || listOfBallForFirstInning.get(j).equals("2") || listOfBallForFirstInning.get(j).equals("4") ||
                    listOfBallForFirstInning.get(j).equals("6") || listOfBallForFirstInning.get(j).equals("0")) {
                runs = runs + Integer.parseInt(listOfBallForFirstInning.get(j));
                if (listOfBallForFirstInning.get(j).equals("4")) {
                    fours = fours + 1;
                }
                if (listOfBallForFirstInning.get(j).equals("6")) {
                    sixes = sixes + 1;
                }
                balls++;
            }
            if (listOfBallForFirstInning.get(j).equals("CO") || listOfBallForFirstInning.get(j).equals("RO") ||
                    listOfBallForFirstInning.get(j).equals("LBW") || listOfBallForFirstInning.get(j).equals("W")) {
                wicketType = listOfBallForFirstInning.get(j);
                status = "out";
                totalWickets = totalWickets + 1;
                balls++;
                i = j;
                break;
            }
            if (listOfBallForFirstInning.get(j).equals("WD") || listOfBallForFirstInning.get(j).equals("NB") ||
                    listOfBallForFirstInning.get(j).equals("B") || listOfBallForFirstInning.get(j).equals("LB")) {
                extras = extras + 1;
            }
            if(j == listOfBallForFirstInning.size()-1){
                i =j;
            }
        }
            totalRun = runs + totalRun;
            totalExtras = extras + totalExtras;
            strikeRate = (runs/balls)*100;
        Batsmen batsmen = new Batsmen(battingOrderOfFirstInning.get(index++), runs, balls, fours, sixes, strikeRate, wicketType, status);
        batsmenList.add(batsmen);
        if(totalWickets >=4){
                break;
        }
    }
        InningBatting inningBattingRecords = new InningBatting( teamName, batsmenList, totalWickets, totalExtras, totalRun);
        return inningBattingRecords;
    }

    public InningsBowling calculateBowlingRecords(String teamName, List<String> bowlingOrderOfFirstInning, List<String> listOfBallForFirstInning){

        int totalWickets = 0; int totalExtras = 0;
        List<Bowler> bowlerList = new ArrayList<>();
        List<List<String>> listOfOvers = listOfOvers( listOfBallForFirstInning);
        for(int i = 0 ; i< bowlingOrderOfFirstInning.size() ; i++) {
            List<String> eachOver = listOfOvers.get(i);
            int fours = 0;
            int sixes = 0;
            int extras = 0;
            int wickets = 0;
            int runsGiven = 0;
            float  economyRate  ;
            for (int j = 0 ; j < eachOver.size(); j++) {
                if(eachOver.get(j).equals("1") ||  eachOver.get(j).equals("2") || eachOver.get(j).equals("4") ||
                        eachOver.get(j).equals("6") ){
                    runsGiven = runsGiven + Integer.parseInt(eachOver.get(j));
                    if(eachOver.get(j).equals("4")){
                        fours = fours + 1;
                    }
                    if(eachOver.get(j).equals("6")){
                        sixes = sixes + 1;
                    }
                }
                if(eachOver.get(j).equals("CO") || eachOver.get(j).equals("RO") ||
                        eachOver.get(j).equals("LBW") || eachOver.get(j).equals("W")) {
                    if(wickets==4){
                        break;
                    }
                    else
                    {
                        wickets = wickets + 1;
                    }
                }
                if(eachOver.get(j).equals("WD") || eachOver.get(j).equals("NB") ||
                        eachOver.get(j).equals("B") || eachOver.get(j).equals("LB")){
                    extras = extras + 1;
                }
            }
            totalWickets = wickets + totalWickets;
            totalExtras = extras + totalExtras;
            economyRate = runsGiven/1;
            Bowler bowler = new Bowler(bowlingOrderOfFirstInning.get(i), 1, runsGiven, wickets, economyRate, fours, sixes, extras);
            bowlerList.add(bowler);
            if(totalWickets==4){
                break;
            }
        }
        return  new InningsBowling( teamName, bowlerList, totalWickets,totalExtras);
    }

    public String tossWinnerTeam(){
        String tossWinnerTeam1 =tossWinner(database.team1 ,database.team2);
        String selected = elected();
        return tossWinnerTeam1 + " win toss, elect to " +selected+" first. ";
    }

        static String tossWinner (String team1, String team2 ){
            if (Math.random() < 0.5) {
                return team1;
            } else {
                return team2;
            }
        }
        static String elected () {
            if (Math.random() < 0.5) {
                return "bat";
            } else {

                return "bowl";
            }
        }

    public void printScorecardBattingRecords(InningBatting firstInningBattingRecords, InningBatting secondInningBattingRecords) {

        System.out.println("*******************************************************************");
        List<Batsmen>  record = firstInningBattingRecords.batsmenList;
        List<Batsmen>  record1 = secondInningBattingRecords.batsmenList;

        for(int i = 0; i< firstInningBattingRecords.batsmenList.size() ; i++ ) {

        System.out.println( "Country "+firstInningBattingRecords.teamName+" Player Name "+record.get(i).name +" Runs "+ record.get(i).runs +" Balls "+ record.get(i).balls+" Fours "+ record.get(i).fours+ " Sixes "+record.get(i).sixes + " StrikeRate "+record.get(i).strikeRate + " WicketType "+record.get(i).wicketType+" Status "+record.get(i).Status );

        }
        for(int i = 0; i< secondInningBattingRecords.batsmenList.size() ; i++ ) {

        System.out.println("Country "+secondInningBattingRecords.teamName+" Player Name "+record1.get(i).name +" Runs "+ record1.get(i).runs +" Balls "+ record1.get(i).balls+" Fours "+ record1.get(i).fours+ " Sixes "+record1.get(i).sixes + " StrikeRate "+record1.get(i).strikeRate + " WicketType "+record1.get(i).wicketType+" Status "+record1.get(i).Status );

        }
        System.out.println("*******************************************************************");
    }

    public void printScorecardBowlingRecords(InningsBowling firstInningBowlingRecords, InningsBowling secondInningBowlingRecords) {

        List<Bowler>  record = firstInningBowlingRecords.bowlerList;
        List<Bowler>  record1 = secondInningBowlingRecords.bowlerList;

        for(int i = 0; i< firstInningBowlingRecords.bowlerList.size() ; i++ ) {

            System.out.println( "Country "+firstInningBowlingRecords.teamName+" Player Name "+record.get(i).name +" Fours "+ record.get(i).fours +" Sixes "+ record.get(i).sixes+" EconomyRate "+ record.get(i).economyRate+ " Overs "+record.get(i).overs + " Extras "+record.get(i).extras + " RunsGiven "+record.get(i).runsGiven+" Wickets "+record.get(i).wickets );

        }
        for(int i = 0; i< secondInningBowlingRecords.bowlerList.size() ; i++ ) {

            System.out.println("Country "+secondInningBowlingRecords.teamName+" Player Name "+record1.get(i).name +" Fours "+ record1.get(i).fours +" Sixes "+ record1.get(i).sixes+" EconomyRate "+ record1.get(i).economyRate+ " Overs "+record1.get(i).overs + " Extras "+record1.get(i).extras + " RunsGiven "+record1.get(i).runsGiven+" Wickets "+record1.get(i).wickets );
        }
        System.out.println("*******************************************************************");
    }

    public void winner(InningBatting firstInningBattingRecords, InningBatting secondInningBattingRecords) {

        if(firstInningBattingRecords.totalRuns > secondInningBattingRecords.totalRuns)
        {
            System.out.println(firstInningBattingRecords.teamName+" is winner ");
        }
        else {
            System.out.println(secondInningBattingRecords.teamName+" is winner ");
        }
    }
}
