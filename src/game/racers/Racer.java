/**
 * this class represent the Racer with all needed components
 * @version 29.42018
 * @author Eliran gabay 203062831
 */
package game.racers;

import game.arenas.Arena;
import utilities.EnumContainer.Color;
import utilities.Fate;
import utilities.Mishap;
import utilities.Point;


public class Racer {

    private static int SERIAL_NUMBER=1;
    private int serialNumber;
    private String name;
    private Point currentLocation,finish;
    private double maxSpeed,acceleration,currentSpeed,failureProbability,tempAcceleration;
    private Color color;
    private Arena arena;
    private Mishap mishap;


    /***
     * this constructs a Racer with a name,acceleration,color
     * @param name
     * @param maxSpeed
     * @param acceleration
     * @param color
     */
    public Racer(String name, double maxSpeed, double acceleration, Color color)
    {
        this.setSerialNumber(SERIAL_NUMBER++);
        this.setName(name);
        this.setMaxSpeed(maxSpeed);
        this.setAcceleration(acceleration);
        this.setColor(color);
        this.tempAcceleration=acceleration;
    }

    //Methods

    /***
     * set the arena and finish point, move to start point.
     * @param arena
     * @param start
     * @param finish
     */
    public void initRace(Arena arena, Point start, Point finish)
    {
        this.setArena(arena);
        this.setCurrentLocation(start);
        this.setFinish(finish);
    }

    /**
     * move function and mishap
     * @param friction
     * @return currentLocation
     */
    public Point move(double friction)
    {
        if (this.currentSpeed < this.maxSpeed) {
            this.setCurrentSpeed(this.currentSpeed + this.acceleration * friction);
        }
        if (this.currentSpeed > this.maxSpeed) {
            this.setCurrentSpeed(this.maxSpeed);
        }
        Point newLocation = new Point((this.currentLocation.getX() + (1 * this.currentSpeed)),
                this.currentLocation.getY());
        this.setCurrentLocation(newLocation);

        if (this.currentLocation.getX() >= this.finish.getX()) {
            this.arena.crossFinishLine(this);
        }

        if(mishap==null)
        {
            if(Fate.breakDown())//create new mishap
            {
                mishap= Fate.generateMishap();
                System.out.print(this.getName()+" Has a new mishap! "+mishap.toString()+"\n");
            }
        }
        else
        { //clear the mishap by turn
            this.setAcceleration(this.getAcceleration()*mishap.getReductionFactor());
            mishap.nextTurn();
            if(mishap.getTurnsToFix()==0) { mishap=null; }
        }

        return this.currentLocation;
    }

    public String describeSpecific(){return "";}////Override method for print custom details

    public String describeRacer(){return "name:"+ this.getName()+", SerialNumber:"+ this.getSerialNumber()+
            ", maxSpeed:"+ this.getMaxSpeed()+ ", acceleration:"+this.tempAcceleration+ ", color:"+ this.getColor()+ describeSpecific();}

    /***
     * Prints all the details about the Racer by describeRacer,describeSpecific;
      */
    public void introduce()
    {
        System.out.print("["+this.className()+"] "+ this.describeRacer()+"\n");
    }

    /**
     * @return Class name
     */
    public String className(){return this.getClass().getSimpleName();}

    //Getter and Setter
    public int getSerialNumber() { return serialNumber; }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
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

    public double getFailureProbability() {
        return failureProbability;
    }

    public void setFailureProbability(double failureProbability) {
        this.failureProbability = failureProbability;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Arena getArena() { return arena; }

    public void setArena(Arena arena) { this.arena = arena; }
}
