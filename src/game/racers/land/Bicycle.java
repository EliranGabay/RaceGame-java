/**
 * this class represent the Bicycle as a LandRacer with all needed components
 * @version 29.42018
 * @author Eliran gabay 203062831
 */
package game.racers.land;

import utilities.EnumContainer.Color;
import utilities.EnumContainer.BicycleType;


public class Bicycle extends LandRacer {

    private BicycleType type;

    /**
     * this default constructs a Bicycle
     */
    public Bicycle()
    {
        super("Bicycle #",270,10, Color.GREEN,2);
        this.setName(this.getName()+getSerialNumber());
        this.setType(BicycleType.MOUNTAIN);
    }

    /**
     * this constructs a Bicycle
     * @param name
     * @param maxSpeed
     * @param acceleration
     * @param color
     * @param numOfWheels
     */
    public Bicycle(String name, double maxSpeed, double acceleration, Color color, int numOfWheels)
    {
        super(name,maxSpeed,acceleration,color,numOfWheels);
        this.setType(BicycleType.MOUNTAIN);
    }

    //Getter and Setter
    public BicycleType getType() {
        return type;
    }

    public void setType(BicycleType type) {
        this.type = type;
    }

    @Override
    public String describeSpecific(){return ", Number of Wheels: "+this.wheeled.getNumOfWheels()+", Bicycle Type: "+this.getType();}
}
