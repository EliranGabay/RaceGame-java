/**
 * this class represent the Airplane as a racer with all needed components
 * @version 3.4.2018
 * @author Eliran gabay 203062831 & Linoy shriker 204027627
 */
package game.racers.air;

import utilities.EnumContainer;

public class Airplane extends AerialRacer{

    public Airplane()
    {
        super("Airplane #",885,100,EnumContainer.Color.BLACK,3);
        this.setName(this.getName()+getSerialNumber());
    }

    public Airplane(String name, double maxSpeed, double acceleration, EnumContainer.Color color, int numOfWheels)
    {
        super(name,maxSpeed,acceleration,color,numOfWheels);
    }

    @Override
    public String describeSpecific(){return ", Number of Wheels: "+this.wheeled.getNumOfWheels();}
}
