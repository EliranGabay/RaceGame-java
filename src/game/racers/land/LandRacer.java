package game.racers.land;

import game.racers.Racer;
import game.racers.Wheeled;
import utilities.EnumContainer;

public class LandRacer  extends Racer {

    Wheeled wheeled=new Wheeled();

    public LandRacer(String name, double maxSpeed, double acceleration, EnumContainer.Color color)
    {
        super(name,maxSpeed,acceleration,color);
    }

    public LandRacer(String name, double maxSpeed, double acceleration, EnumContainer.Color color,int numOfWheels)
    {
        super(name,maxSpeed,acceleration,color);
        this.wheeled.setNumOfWheels(numOfWheels);
    }
}
