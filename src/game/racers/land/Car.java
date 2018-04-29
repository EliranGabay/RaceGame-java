/**
 * this class represent the Car as a LandRacer with all needed components
 * @version 29.42018
 * @author Eliran gabay 203062831
 */
package game.racers.land;

import utilities.EnumContainer.Color;
import utilities.EnumContainer.Engine;


public class Car extends LandRacer {

    private Engine engine;

    /**
     * this default constructs a Car
     */
    public Car()
    {
        super("Car #",400,20,Color.RED,4);
        this.setName(this.getName()+getSerialNumber());
        this.setEngine(Engine.FOURSTROKE);
    }

    /**
     * this constructs a Car
     * @param name
     * @param maxSpeed
     * @param acceleration
     * @param color
     * @param numOfWheels
     */
    public Car(String name, double maxSpeed, double acceleration, Color color, int numOfWheels)
    {
        super(name,maxSpeed,acceleration,color,numOfWheels);
        this.setEngine(Engine.FOURSTROKE);
    }

    //Getter and Setter
    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String describeSpecific(){return ", Number of Wheels: "+this.wheeled.getNumOfWheels()+", Engine Type: "+this.getEngine();}
}
