/**
 * this class represent the Airplane as a AerialRacer with all needed components
 * @version 29.42018
 * @author Eliran gabay 203062831
 */
package game.racers.air;

import utilities.EnumContainer;

public class Airplane extends AerialRacer{

    /**
     * this default constructs a Airplane
     */
    public Airplane()
    {
        super("Airplane #",885,100,EnumContainer.Color.BLACK,3);
        this.setName(this.getName()+getSerialNumber());
    }

    /**
     * this constructs a Airplane
     * @param name
     * @param maxSpeed
     * @param acceleration
     * @param color
     * @param numOfWheels
     */
    public Airplane(String name, double maxSpeed, double acceleration, EnumContainer.Color color, int numOfWheels)
    {
        super(name,maxSpeed,acceleration,color,numOfWheels);
    }

    @Override
    public String describeSpecific(){return ", Number of Wheels: "+this.wheeled.getNumOfWheels();}
}
