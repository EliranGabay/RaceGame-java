package game.racers.air;

import game.racers.Racer;
import game.racers.Wheeled;
import utilities.EnumContainer;

public class AerialRacer extends  Racer{

    Wheeled wheeled=new Wheeled();

    public AerialRacer(String name, double maxSpeed, double acceleration, EnumContainer.Color color)
    {
        super(name,maxSpeed,acceleration,color);
    }

    public AerialRacer(String name, double maxSpeed, double acceleration, EnumContainer.Color color,int numOfWheels)
    {
        super(name,maxSpeed,acceleration,color);
        this.wheeled.setNumOfWheels(numOfWheels);
    }
}
