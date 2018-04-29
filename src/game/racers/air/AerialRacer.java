/**
 * this class represent the AerialRacer with all needed components extends Racer
 * @version 29.42018
 * @author Eliran gabay 203062831
 */
package game.racers.air;

import game.racers.Racer;
import game.racers.Wheeled;
import utilities.EnumContainer.Color;

public class AerialRacer extends  Racer{

    Wheeled wheeled=new Wheeled();

    /**
     * this constructs a AerialRacer of Racer
     * @param name
     * @param maxSpeed
     * @param acceleration
     * @param color
     */
    public AerialRacer(String name, double maxSpeed, double acceleration, Color color)
    {
        super(name,maxSpeed,acceleration,color);
    }

    /**
     * this constructs a AerialRacer of Wheels Racer
     * @param name
     * @param maxSpeed
     * @param acceleration
     * @param color
     * @param numOfWheels
     */
    public AerialRacer(String name, double maxSpeed, double acceleration, Color color,int numOfWheels)
    {
        super(name,maxSpeed,acceleration,color);
        this.wheeled.setNumOfWheels(numOfWheels);
    }
}
