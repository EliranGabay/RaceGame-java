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
            if (player.getName().equals(RowBoat.getName()))
            {
                return false;
            }
        }
        if(speedBoats.size()+rowBoats.size()>MAX_RACERS)return false;
        rowBoats.add(RowBoat);
        return true;
    }

    //SpeedBoat
    public boolean addSpeedBoat(SpeedBoat SpeedBoat) {
        for(SpeedBoat player : speedBoats)
        {
            if (player.getName().equals(SpeedBoat.getName()))
            {
                return false;
            }
        }
        if(speedBoats.size()+rowBoats.size()>MAX_RACERS)return false;
        speedBoats.add(SpeedBoat);
        return true;
    }

    //RowBoat
    public int crossFinishLine(RowBoat RowBoat) {
        for(Object player :finished)
        {
            if(player.equals(RowBoat))return finished.size();
        }
        finished.add(RowBoat);
        return finished.size(); //return array size and RowBoat position
    }

    //SpeedBoat
    public int crossFinishLine(SpeedBoat SpeedBoat) {
        for(Object player :finished)
        {
            if(player.equals(SpeedBoat))return finished.size();
        }
        finished.add(SpeedBoat);
        return finished.size(); //return array size and SpeedBoat position
    }

    public boolean hasActiveRacers() {
        boolean hasActive = true;//
        if (finished.size()==rowBoats.size()+speedBoats.size())
            hasActive = false;
        return hasActive;
    }

    public void initRace() {
        for(RowBoat player : rowBoats) {
            player.initRace(this, start, finish);
        }
        for(SpeedBoat player : speedBoats) {
            player.initRace(this, start, finish);
        }
    }

    public void playTurn() {
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

    public void printWinners() {
        for(int i=0; i<finished.size();i++) {
            if(finished.get(i) instanceof RowBoat)System.out.println("#" + (i + 1) + ":  " +((RowBoat) finished.get(i)).getName());
            if(finished.get(i) instanceof SpeedBoat)System.out.println("#" + (i + 1) + ":  " +((SpeedBoat) finished.get(i)).getName());
        }
    }

}
