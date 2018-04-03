package game.arenas;

import game.racers.Car;
import game.racers.Horse;
import utilities.Point;

import java.util.ArrayList;

/**
 * this class represent the Land Arena with all needed components
 * @version 3.4.2018
 * @author Eliran gabay 203062831 & Linoy shriker 204027627
 */
public class LandArena {
    private ArrayList<Horse> horses;
    private ArrayList<Car> cars;
    private ArrayList<Object> finished;
    private final double FRICTION = 0.5;
    private final int MAX_RACERS = 8;
    private Point start;
    private Point finish;

    /**
     * this constructs a Land Arena with a specified start and finish parameters
     * and update finished, horses and cars.
     * @param start 
     * @param finish
     */
    public LandArena(Point start, Point finish) {
        this.start = new Point(start);
        this.finish = new Point(finish);
        finished = new ArrayList<Object>();
        horses = new ArrayList<Horse>();
        cars= new ArrayList<Car>();
    }

	/**
	 * @param horse
	 * @return false if the horse name exist, true otherwise.
	 */
    //Horse
    public boolean addHorse(Horse horse) {
        for(Horse player : horses)
        {
            if (player.getName().equals(horse.getName()))//if the horse name exist return flase
            {
                return false;
            }
        }
        if(cars.size()+horses.size()>=MAX_RACERS)return false;//make sure the number of cars and horses didnt exceed the max num of racers
        horses.add(horse);//add to array
        return true;
    }

	/**
	 * @param car
	 * @return false if the car name exist, true otherwise.
	 */
    //Car
    public boolean addCar(Car car) {
        for(Car player : cars)
        {
            if (player.getName().equals(car.getName()))//if the car name exist return flase
            {
                return false;
            }
        }
        if(cars.size()+horses.size()>=MAX_RACERS)return false;//make sure the number of cars and horses didnt exceed the max num of racers
        cars.add(car);//add to array
        return true;
    }

	/**
	 * @param horse
	 * @return finished.size(); array size and horse position
	 */
    //Horse
    public int crossFinishLine(Horse horse) {// adds racer to finished, returns his place
        for(Object player :finished)
        {
            if(player.equals(horse))return finished.size();
        }
        finished.add(horse);
        return finished.size(); //return array size and Horse position
    }

	/**
	 * @param car
	 * @return finished.size(); array size and car position
	 */
    //Car
    public int crossFinishLine(Car car) {// adds racer to finished, returns his place
        for(Object player :finished)
        {
            if(player.equals(car))return finished.size();
        }
        finished.add(car);
        return finished.size(); //return array size and Car position
    }

	/**
	 * @return hasActive  if there are active racers(true/false)
	 */
    public boolean hasActiveRacers() {
        boolean hasActive = true;
        if (finished.size()==horses.size()+cars.size())
            hasActive = false;
        return hasActive;// returns if there are active racers
    }

    public void initRace() {// init each racer
        for(Horse player : horses) {
            player.initRace(this, start, finish);
        }
        for(Car player : cars) {
            player.initRace(this, start, finish);
        }
    }

    public void playTurn() {// signal each racer to make a move, remove finished racers
        if (hasActiveRacers()) {
            for(Horse player : horses){
                player.move(FRICTION);
                if (player.isFinished()) {
                    crossFinishLine(player);
                }
            }
            for(Car player : cars){
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