/**
 * this class represent the SpeedBoat as a NavalRacer with all needed components
 * @version 29.42018
 * @author Eliran gabay 203062831
 */
package game.racers.naval;


import utilities.EnumContainer.Color;
import utilities.EnumContainer.Team;
import utilities.EnumContainer.BoatType;


public class SpeedBoat extends NavalRacer{

    /**
     * this default constructs a SpeedBoat
     */
    public SpeedBoat()
    {
        super("SpeedBoat #",170,5, Color.RED);
        this.setName(this.getName()+getSerialNumber());
        this.setType(BoatType.SKULLING);
        this.setTeam(Team.DOUBLE);
    }

    /**
     * this constructs a SpeedBoat
     * @param name
     * @param maxSpeed
     * @param acceleration
     * @param color
     */
    public SpeedBoat(String name, double maxSpeed, double acceleration, Color color)
    {
        super(name,maxSpeed,acceleration,color);
        this.setType(BoatType.SKULLING);
        this.setTeam(Team.DOUBLE);
    }
}
