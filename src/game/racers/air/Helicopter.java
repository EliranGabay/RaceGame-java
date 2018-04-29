/**
 * this class represent the Helicopter as a AerialRacer with all needed components
 * @version 29.42018
 * @author Eliran gabay 203062831
 */
package game.racers.air;

import utilities.EnumContainer.Color;

public class Helicopter extends AerialRacer {

    /**
     * this default constructs a Helicopter
     */
    public Helicopter()
    {
        super("Helicopter #",400,50,Color.BLUE);
        this.setName(this.getName()+getSerialNumber());
    }

    /**
     * this constructs a Helicopter
     * @param name
     * @param maxSpeed
     * @param acceleration
     * @param color
     */
    public Helicopter(String name, double maxSpeed, double acceleration, Color color)
    {
        super(name,maxSpeed,acceleration,color);
    }
}