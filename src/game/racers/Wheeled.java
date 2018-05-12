/**
 * this class represent the Wheeled with all needed components
 * @version 29.42018
 * @author Eliran gabay 203062831
 */
package game.racers;

public class Wheeled {

    private int numOfWheels;

    public Wheeled(int numOfWheels) {
        this.numOfWheels = numOfWheels;
    }

    public String describeSpecific() {
        return ", Number of Wheels: " + this.getNumOfWheels();
    }

    public int getNumOfWheels() {
        return numOfWheels;
    }
}
