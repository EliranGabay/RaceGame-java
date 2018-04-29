/**
 * this class represent the Arena with all needed components
 * @version 29.42018
 * @author Eliran gabay 203062831
 */
package game.arenas;

import game.racers.Racer;
import game.arenas.exceptions.*;
import utilities.Point;

import java.util.ArrayList;

public class Arena {

    private ArrayList<Racer> activeRacers;
    private ArrayList<Racer> completedRacers;
    private final double FRICTION;
    private final int MAX_RACERS;
    private final static int MIN_Y_GAP=10;
    private double length;

    /***
     * this constructs a Arena with a length,maxRacers,friction
     * @param length
     * @param maxRacers
     * @param friction
     */
    public Arena(double length, int maxRacers, double friction)
    {
        this.setLength(length);
        this.MAX_RACERS=maxRacers;
        this.FRICTION=friction;
        activeRacers=new ArrayList<Racer>();
        completedRacers=new ArrayList<Racer>();
    }

    /**
     * addRacer function
     * @param newRacer
     * @throws RacerTypeException
     * @throws RacerLimitException
     */
    public void addRacer(Racer newRacer) throws RacerTypeException,RacerLimitException
    {
        if (!(racerTypeArena(newRacer))) throw new RacerTypeException(newRacer,this);
        else if (getActiveRacers().size() == getMAX_RACERS()) throw new RacerLimitException(getMAX_RACERS(), newRacer);
        else activeRacers.add(newRacer);
    }

    public boolean racerTypeArena(Racer racer) {return false;}//Override method for check if the racer is appropriate to arena


    public void initRace()
    {
        for (Racer racer : this.activeRacers) { racer.initRace(this,new Point(0,activeRacers.indexOf(racer)*MIN_Y_GAP),new Point(getLength(),activeRacers.indexOf(racer)*MIN_Y_GAP)); }
    }

    /**
     * @return boolean value if has Active Racers
     */
    public boolean hasActiveRacers() { return(activeRacers.size()>0); }

    public void playTurn()
    {
        for(Racer racer: this.activeRacers)racer.move(getFRICTION());
        for(Racer racer: this.completedRacers)activeRacers.remove(racer);
    }

    public void crossFinishLine(Racer racer) { this.completedRacers.add(racer);}

    public void showResults()//print finish racer
    {
        for (Racer racer : this.getCompletedRacers()) {
            int place = this.getCompletedRacers().indexOf(racer) + 1;
            System.out.println("#" + place + " -> " + racer.describeRacer());
        }
    }

    //Getter and Setter
    public double getFRICTION() {
        return FRICTION;
    }

    public int getMAX_RACERS() {
        return MAX_RACERS;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public ArrayList<Racer> getActiveRacers() {
        return activeRacers;
    }

    public ArrayList<Racer> getCompletedRacers() {
        return completedRacers;
    }
}
