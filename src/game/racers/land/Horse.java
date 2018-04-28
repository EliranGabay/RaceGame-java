/**
 * this class represent the Horse as a racer with all needed components
 * @version 3.4.2018
 * @author Eliran gabay 203062831 & Linoy shriker 204027627
 */
package game.racers.land;


import utilities.EnumContainer;

public class Horse extends LandRacer{

    private EnumContainer.Breed breed;

    public Horse()
    {
        super("Horse #",50,3,EnumContainer.Color.BLACK);
        this.setName(this.getName()+getSerialNumber());
        this.setBreed(EnumContainer.Breed.THOROUGHBRED);
    }

    public Horse(String name, double maxSpeed, double acceleration, EnumContainer.Color color)
    {
        super(name,maxSpeed,acceleration,color);
    }

    //Getter and Setter
    public EnumContainer.Breed getBreed() {
        return breed;
    }

    public void setBreed(EnumContainer.Breed breed) {
        this.breed = breed;
    }

    @Override
    public String describeSpecific(){return ", Breed: "+this.getBreed();}
}

