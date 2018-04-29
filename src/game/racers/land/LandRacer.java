/**
 * this class represent the LandRacer with all needed components extends Racer
 * @version 29.42018
 * @author Eliran gabay 203062831
 */
package game.racers.land;

import game.racers.Racer;
import game.racers.Wheeled;
import utilities.EnumContainer.Color;

public class LandRacer  extends Racer {

    Wheeled wheeled=new Wheeled();

    /**
     * this constructs a LandRacer
     * @param name
     * @param maxSpeed
     * @param acceleration
     * @param color
     */
    public LandRacer(String name, double maxSpeed, double acceleration, Color color)
    {
        super(name,maxSpeed,acceleration,color);
    }

    /**
     * this constructs a LandRacer of Wheels Racer
     * @param name
     * @param maxSpeed
     * @param acceleration
     * @param color
     * @param numOfWheels
     */
    public LandRacer(String name, double maxSpeed, double acceleration, Color color,int numOfWheels)
    {
        super(name,maxSpeed,acceleration,color);
        this.wheeled.setNumOfWheels(numOfWheels);
    }
}
