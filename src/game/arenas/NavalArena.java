package game.arenas;

import game.racers.RowBoat;
import game.racers.SpeedBoat;
import utilities.Point;

import java.util.ArrayList;

public class NavalArena {
    private ArrayList<RowBoat> rowBoats;
    private ArrayList<SpeedBoat> speedBoats;
    private ArrayList<Object> finished;
    private final double FRICTION = 0.7;
    private final int MAX_RACERS = 5;
    private Point start;
    private Point finish;

    //constructor
    public NavalArena(Point start, Point finish) {
        this.start = new Point(start);
        this.finish = new Point(finish);
        finished = new ArrayList<Object>();
        rowBoats = new ArrayList<RowBoat>();
        speedBoats= new ArrayList<SpeedBoat>();
    }

    //RowBoat
    public boolean addRowBoat(RowBoat RowBoat) {
        for(RowBoat player : rowBoats)
        {
            if (player.getName().equals(RowBoat.getName()))//if the rowboat name exist return flase
            {
                return false;
            }
        }
        if(speedBoats.size()+rowBoats.size()>=MAX_RACERS)return false;//make sure the number of rowboats and speedboats didnt exceed the max num of racers
        rowBoats.add(RowBoat);//add to array
        return true;
    }

    //SpeedBoat
    public boolean addSpeedBoat(SpeedBoat SpeedBoat) {
        for(SpeedBoat player : speedBoats)
        {
            if (player.getName().equals(SpeedBoat.getName()))//if the speedboat name exist return flase
            {
                return false;
            }
        }
        if(speedBoats.size()+rowBoats.size()>=MAX_RACERS)return false;//make sure the number of rowboats and speedboats didnt exceed the max num of racers
        speedBoats.add(SpeedBoat);//add to array
        return true;
    }

    //RowBoat
    public int crossFinishLine(RowBoat RowBoat) {// adds racer to finished, returns his place
        for(Object player :finished)
        {
            if(player.equals(RowBoat))return finished.size();
        }
        finished.add(RowBoat);
        return finished.size(); //return array size and RowBoat position
    }

    //SpeedBoat
    public int crossFinishLine(SpeedBoat SpeedBoat) {// adds racer to finished, returns his place
        for(Object player :finished)
        {
            if(player.equals(SpeedBoat))return finished.size();
        }
        finished.add(SpeedBoat);
        return finished.size(); //return array size and SpeedBoat position
    }

    public boolean hasActiveRacers() {
        boolean hasActive = true;
        if (finished.size()==rowBoats.size()+speedBoats.size())
            hasActive = false;
        return hasActive;// returns if there are active racers
    }

    public void initRace() {// init each racer
        for(RowBoat player : rowBoats) {
            player.initRace(this, start, finish);
        }
        for(SpeedBoat player : speedBoats) {
            player.initRace(this, start, finish);
        }
    }

    public void playTurn() {// signal each racer to make a move, remove finished racers
        if (hasActiveRacers()) {
            for(RowBoat player : rowBoats){
                player.move(FRICTION);
                if (player.isFinished()) {
                    crossFinishLine(player);
                }
            }
            for(SpeedBoat player : speedBoats){
                player.move(FRICTION);
                if (player.isFinished()) {
                    crossFinishLine(player);
                }
            }
        }
    }

    public void printWinners() {//print the winners
        for(int i=0; i<finished.size();i++) {
            System.out.println("#" + (i + 1) + ":  " +(finished.get(i)));
        }
    }

}
