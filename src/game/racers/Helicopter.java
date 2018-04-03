package game.racers;

import game.arenas.AerialArena;
import utilities.Point;

/**
 * this class represent the Helicopter as a racer with all needed components
 * @version 3.4.2018
 * @author Eliran gabay 203062831 & Linoy shriker 204027627
 */
public class Helicopter {
    private  String name;
    private Point currentLocation,finish;
    private AerialArena arena;
    private  double maxSpeed,acceleration,currentSpeed;
    private final int MAX_SPEED=150,ACCELERATION=10;

    /**
     * this constructs a helicopter with a specified name,
     * maxSpeed and acceleration.
     * @param name the name of the helicopter
     * @param maxSpeed the max speed of the helicopter
     * @param acceleration the acceleration of the helicopter
     */
    public Helicopter(String name, double maxSpeed, double acceleration)
    {
        this.name = name;
        if(maxSpeed<=MAX_SPEED)this.maxSpeed = maxSpeed;
        else this.maxSpeed=MAX_SPEED;
        if(acceleration<=ACCELERATION)this.acceleration = acceleration;
        else this.acceleration=ACCELERATION;
    }

    /**
     * constructor
     * @param name Helicopter name
     */
    public Helicopter(String name)
    {
        this.name = name;
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

    public AerialArena getArena() {
        return arena;
    }

    private void setArena(AerialArena arena) {
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
    public void initRace(AerialArena arena, Point start, Point finish)
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
    {// accelerate if not at top speed – currSpeed += acceleration*friction.
        if(this.currentSpeed<this.maxSpeed) this.currentSpeed+=this.acceleration*friction;
    	// move forward: currLocation.x += currSpeed (y is always 0 for now)
        this.currentLocation.setX(this.currentLocation.getX()+this.currentSpeed);
        return currentLocation;
    }

    /**
     * @return false while the current location is "smaller" than get finish
     * @return true if the current location is the same as get finish
     */
    public  boolean isFinished()
    {
        if(getCurrentLocation().getX()<getFinish().getX()) return false;
        return true;
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
