package game.racers.land;

import utilities.EnumContainer;

public class Bicycle extends LandRacer {

    private EnumContainer.BicycleType type;

    public Bicycle()
    {
        super("Bicycle #",270,10,EnumContainer.Color.GREEN,2);
        this.setName(this.getName()+getSerialNumber());
        this.setType(EnumContainer.BicycleType.MOUNTAIN);
    }

    public Bicycle(String name, double maxSpeed, double acceleration, EnumContainer.Color color, int numOfWheels)
    {
        super(name,maxSpeed,acceleration,color,numOfWheels);
    }

    //Getter and Setter
    public EnumContainer.BicycleType getType() {
        return type;
    }

    public void setType(EnumContainer.BicycleType type) {
        this.type = type;
    }

    @Override
    public String describeSpecific(){return ", Number of Wheels: "+this.wheeled.getNumOfWheels()+", Bicycle Type: "+this.getType();}
}
