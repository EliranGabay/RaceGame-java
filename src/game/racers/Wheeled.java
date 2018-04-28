package game.racers;

public  class Wheeled{

    private int numOfWheels;

    public Wheeled()
    {
        this.setNumOfWheels(0);
    }
    public Wheeled(int numOfWheels)
    {
        this.setNumOfWheels(numOfWheels);
    }

    //Getter and Setter
    public int getNumOfWheels() { return numOfWheels; }

    public void setNumOfWheels(int numOfWheels) { this.numOfWheels = numOfWheels; }
}
