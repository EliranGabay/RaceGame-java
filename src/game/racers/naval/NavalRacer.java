/**
 * this class represent the NavalRacer with all needed components extends Racer
 * @version 29.42018
 * @author Eliran gabay 203062831
 */
package game.racers.naval;

import game.racers.Racer;
import utilities.EnumContainer.Color;
import utilities.EnumContainer.BoatType;
import utilities.EnumContainer.Team;

public class NavalRacer extends Racer {

    private BoatType type;
    private Team team;

    /**
     * this constructs a NavalRacer of Racer
     * @param name
     * @param maxSpeed
     * @param acceleration
     * @param color
     */
    public NavalRacer(String name, double maxSpeed, double acceleration, Color color)
    {
        super(name,maxSpeed,acceleration,color);
    }

    //Getter and Setter
    public BoatType getType() {
        return type;
    }

    public void setType(BoatType type) {
        this.type = type;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String describeSpecific(){return " Type: "+this.getType()+", Team: "+this.getTeam();}

}
