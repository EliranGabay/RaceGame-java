/**
 * this class represent the Wheeled with all needed components
 * @version 29.42018
 * @author Eliran gabay 203062831
 */
package game.racers;

public  class Wheeled{

    private int numOfWheels;

    /**
     * this default constructs a Wheeled
     */
    public Wheeled()
    {
        this.setNumOfWheels(0);
    }

    /**
     * this constructs a Wheeled
     * @param numOfWheels
     */
    public Wheeled(int numOfWheels)
    {
        this.setNumOfWheels(numOfWheels);
    }

    //Getter and Setter
    public int getNumOfWheels() { return numOfWheels; }

    public void setNumOfWheels(int numOfWheels) { this.numOfWheels = numOfWheels; }
}
