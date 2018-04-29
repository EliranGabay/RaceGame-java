/**
 * this class represent the RowBoat as a NavalRacer with all needed components
 * @version 29.42018
 * @author Eliran gabay 203062831
 */
package game.racers.naval;


import utilities.EnumContainer.Color;
import utilities.EnumContainer.BoatType;
import utilities.EnumContainer.Team;

public class RowBoat extends NavalRacer{

    /**
     * * this default constructs a RowBoat
     */
    public RowBoat()
    {
        super("RowBoat #",75,10,Color.RED);
        this.setName(this.getName()+getSerialNumber());
        this.setType(BoatType.SKULLING);
        this.setTeam(Team.DOUBLE);
    }

    /**
     * * this constructs a RowBoat
     * @param name
     * @param maxSpeed
     * @param acceleration
     * @param color
     */
    public RowBoat(String name, double maxSpeed, double acceleration, Color color)
    {
        super(name,maxSpeed,acceleration,color);
        this.setType(BoatType.SKULLING);
        this.setTeam(Team.DOUBLE);
    }
}

