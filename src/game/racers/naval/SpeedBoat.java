/**
 * this class represent the SpeedBoat as a racer with all needed components
 * @version 3.4.2018
 * @author Eliran gabay 203062831 & Linoy shriker 204027627
 */
package game.racers.naval;


import utilities.EnumContainer;

public class SpeedBoat extends NavalRacer{

    public SpeedBoat()
    {
        super("SpeedBoat #",170,5,EnumContainer.Color.RED);
        this.setName(this.getName()+getSerialNumber());
        this.setType(EnumContainer.RowType.SKULLING);
        this.setTeam(EnumContainer.Team.DOUBLE);
    }

    public SpeedBoat(String name, double maxSpeed, double acceleration, EnumContainer.Color color)
    {
        super(name,maxSpeed,acceleration,color);
    }
}
