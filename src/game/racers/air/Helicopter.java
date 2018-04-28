/**
 * this class represent the Helicopter as a racer with all needed components
 * @version 3.4.2018
 * @author Eliran gabay 203062831 & Linoy shriker 204027627
 */
package game.racers.air;

import utilities.EnumContainer;

public class Helicopter extends AerialRacer {

    public Helicopter()
    {
        super("Helicopter #",400,50,EnumContainer.Color.BLUE);
        this.setName(this.getName()+getSerialNumber());
    }

    public Helicopter(String name, double maxSpeed, double acceleration, EnumContainer.Color color)
    {
        super(name,maxSpeed,acceleration,color);
    }
}