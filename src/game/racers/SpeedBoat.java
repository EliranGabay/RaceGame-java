package game.racers;

import game.arenas.AerialArena;
import utilities.Point;

public class SpeedBoat {
    private  String name;
    private Point currentLocation,finish;
    private NavalArena arena;
    private  double maxSpeed,acceleration,currentSpeed;

    //constructor
    public SpeedBoat(String name, double maxSpeed, double acceleration)
    {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.acceleration = acceleration;
    }

    public SpeedBoat(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Point getCurrentLocation() {
        return currentLocation;
    }

    private void setCurrentLocation(Point currentLocation) {
        this.currentLocation=new Point(currentLocation);
    }

    public Point getFinish() {
        return finish;
    }

    private void setFinish(Point finish) {
        this.finish = finish;
    }

    public NavalArena getArena() {
        return arena;
    }

    private void setArena(NavalArena arena) {
        this.arena = arena;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    private void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getAcceleration() {
        return acceleration;
    }

    private void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    private void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public void initRace(NavalArena arena, Point start, Point finish)
    {
        setArena(arena);
        setCurrentLocation(start);
        setFinish(finish);
    }

    public Point move(double friction)
    {
        if(this.currentSpeed<this.maxSpeed) this.currentSpeed+=this.acceleration*friction;
        this.currentLocation.setX(this.currentLocation.getX()+this.currentSpeed);
        return currentLocation;
    }

    public  boolean isFinished()
    {
        if(getCurrentLocation().getX()<getFinish().getX()) return false;
        return true;
    }
}
