/**
 * this class represent the Car as a racer with all needed components
 * @version 3.4.2018
 * @author Eliran gabay 203062831 & Linoy shriker 204027627
 */
package game.racers.land;

import utilities.EnumContainer;

public class Car extends LandRacer {

    private EnumContainer.Engine engine;
    public Car()
    {
        super("Car #",400,20,EnumContainer.Color.RED,4);
        this.setName(this.getName()+getSerialNumber());
        this.setEngine(EnumContainer.Engine.FOURSTROKE);
    }

    public Car(String name, double maxSpeed, double acceleration, EnumContainer.Color color, int numOfWheels)
    {
        super(name,maxSpeed,acceleration,color,numOfWheels);
    }

    //Getter and Setter
    public EnumContainer.Engine getEngine() {
        return engine;
    }

    public void setEngine(EnumContainer.Engine engine) {
        this.engine = engine;
    }

    @Override
    public String describeSpecific(){return ", Number of Wheels: "+this.wheeled.getNumOfWheels()+", Engine Type: "+this.getEngine();}
}
