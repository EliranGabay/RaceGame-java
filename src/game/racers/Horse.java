package game.racers;

import game.arenas.AerialArena;
import game.arenas.LandArena;
import utilities.Point;

/**
 * this class represent the Horse as a racer with all needed components
 * @version 3.4.2018
 * @author Eliran gabay 203062831 & Linoy shriker 204027627
 */
public class Horse {
    private  String name;
    private Point currentLocation,finish;
    private LandArena arena;
    private  double maxSpeed,acceleration,currentSpeed;
    private final int MAX_SPEED=80,ACCELERATION=7;

    /**
     * this constructs a horse with a specified name,
     * maxSpeed and acceleration.
     * @param name the name of the horse
     * @param maxSpeed the max speed of the horse
     * @param acceleration the acceleration of the horse
     */
    public Horse(String name, double maxSpeed, double acceleration)
    {
        this.name = name;
        this.maxSpeed=maxSpeed;
        this.acceleration=acceleration;
    }

    /**
     * default constructor
     * @param name Horse name
     */
    public Horse(String name)
    {
        this.name = name;
        this.maxSpeed=MAX_SPEED;
        this.acceleration=ACCELERATION;
    }
    
    /**
     * ALL SETTERS AND GETTERS PARAMETERS& RETURN VALUES ARE:
     * name, currentLocation, finish, arena, maxSpeed, acceleration, currentSpeed.
     */

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private Point getCurrentLocation() {
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

    public LandArena getArena() {
        return arena;
    }

    private void setArena(LandArena arena) {
        this.arena = arena;
    }

    private double getMaxSpeed() {
        return maxSpeed;
    }

    private void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    private double getAcceleration() {
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

    /**
     * @param arena
     * @param start
     * @param finish
     * set the arena and finish point, move to start point.
     */
    public void initRace(LandArena arena, Point start, Point finish)
    {
        setArena(arena);
        setCurrentLocation(start);
        setFinish(finish);
    }

    /**
     * @param friction
     * @return the current location
     */
    public Point move(double friction)
    {// accelerate if not at top speed � currSpeed += acceleration*friction.
        if((this.currentSpeed+this.acceleration*friction)<this.maxSpeed) this.currentSpeed+=this.acceleration*friction;
        else setCurrentSpeed(getMaxSpeed());
        // move forward: currLocation.x += currSpeed (y is always 0 for now)
        this.currentLocation.setX(this.currentLocation.getX()+this.currentSpeed);
        return currentLocation;
    }
    
    /**
     * @return the string that contains all necessary info
     */
    @Override
    public String toString()
    {
        return getClass().getSimpleName()+" "+getName()+" ("+getMaxSpeed()+", "+getAcceleration()+")";
    }
}
