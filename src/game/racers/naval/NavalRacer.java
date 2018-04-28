package game.racers.naval;

import game.racers.Racer;
import utilities.EnumContainer;

public class NavalRacer extends Racer {

    private EnumContainer.RowType type;
    private EnumContainer.Team team;

    public NavalRacer(String name, double maxSpeed, double acceleration, EnumContainer.Color color)
    {
        super(name,maxSpeed,acceleration,color);
    }

    //Getter and Setter
    public EnumContainer.RowType getType() {
        return type;
    }

    public void setType(EnumContainer.RowType type) {
        this.type = type;
    }

    public EnumContainer.Team getTeam() {
        return team;
    }

    public void setTeam(EnumContainer.Team team) {
        this.team = team;
    }

    @Override
    public String describeSpecific(){return " Type: "+this.getType()+", Team: "+this.getTeam();}

}
