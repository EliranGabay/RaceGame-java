package game.arenas;

import game.racers.RowBoat;
import game.racers.SpeedBoat;
import utilities.Point;

import java.util.ArrayList;

/**
 * this class represent the Naval Arena with all needed components
 * @version 3.4.2018
 * @author Eliran gabay 203062831 & Linoy shriker 204027627
 */
public class NavalArena {
    private ArrayList<RowBoat> rowBoats;
    private ArrayList<SpeedBoat> speedBoats;
    private ArrayList<Object> finished;
    private final double FRICTION = 0.7;
    private final int MAX_RACERS = 5;
    private Point start;
    private Point finish;
    private static int numOfPlayers=0;//count number of players in the race

    /**
     * this constructs a Naval Arena with a specified start and finish parameters
     * and update finished, rowBoats and speedBoats.
     * @param start 
     * @param finish
     */
    public NavalArena(Point start, Point finish) {
        this.start = new Point(start);
        this.finish = new Point(finish);
        finished = new ArrayList<Object>();
        rowBoats = new ArrayList<RowBoat>();
        speedBoats= new ArrayList<SpeedBoat>();
    }

	/**
	 * @param RowBoat
	 * @return false if the RowBoat name exist, true otherwise.
	 */
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
        numOfPlayers++;
        return true;
    }

	/**
	 * @param SpeedBoat
	 * @return false if the SpeedBoat name exist, true otherwise.
	 */
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
        numOfPlayers++;
        return true;
    }

	/**
	 * @param RowBoat
	 * @return finished.size(); array size and RowBoat position
	 */
    //RowBoat
    public int crossFinishLine(RowBoat RowBoat) {// adds racer to finished, returns his place
        for(Object player :finished)
        {
            if(player.equals(RowBoat))return finished.size();
        }
        finished.add(RowBoat);
        return finished.size(); //return array size and RowBoat position
    }

	/**
	 * @param SpeedBoat
	 * @return finished.size(); array size and SpeedBoat position
	 */
    //SpeedBoat
    public int crossFinishLine(SpeedBoat SpeedBoat) {// adds racer to finished, returns his place
        for(Object player :finished)
        {
            if(player.equals(SpeedBoat))return finished.size();
        }
        finished.add(SpeedBoat);
        return finished.size(); //return array size and SpeedBoat position
    }

	/**
	 * @return hasActive  if there are active racers(true/false)
	 */
    public boolean hasActiveRacers() {
        boolean hasActive = true;
        if (finished.size()==numOfPlayers)
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
        int flag=0;
        if (hasActiveRacers()) {
            for(RowBoat player : rowBoats){
                if (player.move(FRICTION).getX()>=this.finish.getX()) {
                    crossFinishLine(player);
                    flag=1;
                }
            }
            for(SpeedBoat player : speedBoats){
                if (player.move(FRICTION).getX()>=this.finish.getX()) {
                    crossFinishLine(player);
                    flag=1;
                }
            }
            if(flag==1)
            {
                for(Object player:finished)//remove the player form the race
                {
                    if(player instanceof RowBoat)rowBoats.remove(player);
                    if(player instanceof SpeedBoat)speedBoats.remove(player);
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
