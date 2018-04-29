/**
 * this class represent the Horse as a LandRacer with all needed components
 * @version 29.42018
 * @author Eliran gabay 203062831
 */
package game.racers.land;


import utilities.EnumContainer.Color;
import utilities.EnumContainer.Breed;

public class Horse extends LandRacer{

    private Breed breed;

    /**
     * this default constructs a Horse
     */
    public Horse()
    {
        super("Horse #",50,3,Color.BLACK);
        this.setName(this.getName()+getSerialNumber());
        this.setBreed(Breed.THOROUGHBRED);
    }

    /**
     * this constructs a Horse
     * @param name
     * @param maxSpeed
     * @param acceleration
     * @param color
     */
    public Horse(String name, double maxSpeed, double acceleration, Color color)
    {
        super(name,maxSpeed,acceleration,color);
        this.setBreed(Breed.THOROUGHBRED);
    }

    //Getter and Setter
    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    @Override
    public String describeSpecific(){return ", Breed: "+this.getBreed();}
}

