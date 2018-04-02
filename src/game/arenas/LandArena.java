package game.arenas;

import game.racers.Car;
import game.racers.Horse;
import utilities.Point;

import java.util.ArrayList;

public class LandArena {
    private ArrayList<Horse> horses;
    private ArrayList<Car> cars;
    private ArrayList<Object> finished;
    private final double FRICTION = 0.5;
    private final int MAX_RACERS = 8;
    private Point start;
    private Point finish;

    //constructor
    public LandArena(Point start, Point finish) {
        this.start = new Point(start);
        this.finish = new Point(finish);
        finished = new ArrayList<Object>();
        horses = new ArrayList<Horse>();
        cars= new ArrayList<Car>();
    }

    //Horse
    public boolean addHorse(Horse horse) {
        for(Horse player : horses)
        {
            if (player.getName().equals(horse.getName()))
            {
                return false;
            }
        }
        if(cars.size()+horses.size()>=MAX_RACERS)return false;
        horses.add(horse);
        return true;
    }

    //Car
    public boolean addCar(Car car) {
        for(Car player : cars)
        {
            if (player.getName().equals(car.getName()))
            {
                return false;
            }
        }
        if(cars.size()+horses.size()>=MAX_RACERS)return false;
        cars.add(car);
        return true;
    }

    //Horse
    public int crossFinishLine(Horse horse) {
        for(Object player :finished)
        {
            if(player.equals(horse))return finished.size();
        }
        finished.add(horse);
        return finished.size(); //return array size and Horse position
    }

    //Car
    public int crossFinishLine(Car car) {
        for(Object player :finished)
        {
            if(player.equals(car))return finished.size();
        }
        finished.add(car);
        return finished.size(); //return array size and Car position
    }

    public boolean hasActiveRacers() {
        boolean hasActive = true;//
        if (finished.size()==horses.size()+cars.size())
            hasActive = false;
        return hasActive;
    }

    public void initRace() {
        for(Horse player : horses) {
            player.initRace(this, start, finish);
        }
        for(Car player : cars) {
            player.initRace(this, start, finish);
        }
    }

    public void playTurn() {
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

    public void printWinners() {
        for(int i=0; i<finished.size();i++) {
            System.out.println("#" + (i + 1) + ":  " +(finished.get(i)));
        }
    }

}