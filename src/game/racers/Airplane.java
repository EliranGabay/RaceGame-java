package game.racers;

import utilities.Point;

public class Airplane {
    private  String name;
    private Point currentLocation,finish;
    private  Object arena;
    private  double maxSpeed,acceleration,currentSpeed;

    public Airplane(String name, double maxSpeed, double acceleration)
    {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.acceleration = acceleration;
    }

    public Airplane(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Point currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Point getFinish() {
        return finish;
    }

    public void setFinish(Point finish) {
        this.finish = finish;
    }

    public Object getArena() {
        return arena;
    }

    public void setArena(Object arena) {
        this.arena = arena;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    void initRace(Object arena, Point start, Point finish)
    {

    }
}
