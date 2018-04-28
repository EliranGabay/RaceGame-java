package game.racers;

import utilities.EnumContainer;
import utilities.Point;

public class Racer {

    private static int SERIAL_NUMBER=0;
    private int serialNumber;
    private String name;
    private Point currentLocation,finish;
    private double maxSpeed,acceleration,currentSpeed,failureProbability;
    private EnumContainer.Color color;
    //private Arena arena;

    public Racer(String name, double maxSpeed, double acceleration, EnumContainer.Color color)
    {
        this.setSerialNumber(SERIAL_NUMBER++);
        this.setName(name);
        this.setMaxSpeed(maxSpeed);
        this.setAcceleration(acceleration);
        this.setColor(color);
    }

    //Methods
    /*public void initRace(Arena arena, Point start, Point finish)
    {
        this.setArena(arena);
        this.setCurrentLocation(start);
        this.setFinish(finish);
    }*/

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

        // *has a chance for failure

        return this.currentLocation;
    }

    public String describeSpecific(){return "";}

    public String describeRacer(){return "name:"+ this.getName()+", SerialNumber:"+ this.getSerialNumber()+
            ", maxSpeed:"+ this.getMaxSpeed()+ ", acceleration:"+this.getAcceleration()+ ", color:"+ this.getColor()+ describeSpecific();}

    public void introduce()
    {
        System.out.print("["+this.className()+"] "+ this.describeRacer()+"\n");
    }

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

    public EnumContainer.Color getColor() {
        return color;
    }

    public void setColor(EnumContainer.Color color) {
        this.color = color;
    }

    /*public Arena getArena() { return arena; }

    public void setArena(Arena arena) { this.arena = arena; }*/
}
