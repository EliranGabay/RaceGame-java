package utilities;
/**
 * this class represent the Airplane as a racer with all needed components
 * @version 3.4.2018
 * @author Eliran gabay 203062831 & Linoy shriker 204027627
 */
public class Point {
    private double x;
    private double y;
    private final double MIN_X=0,MAX_X=20000;

    /**
     * this constructs a Point with a Location X,Y
     * @param x Location double
     * @param y Location double
     */
    //constructor
    public Point(double x, double y)
    {
        setX(x);
        setY(y);
    }
    /**
     * this copy constructs a Point with a other Point
     * @param other Point containing X,Y Location double
     */
    //copy constructor
    public Point(Point other)
    {
        setX(other.getX());
        setY(other.getY());
    }

    /**
     * ALL SETTERS AND GETTERS PARAMETERS& RETURN VALUES ARE:
     * X,Y
     */
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean setX(double x) {
        if(x>=MIN_X&&x<=MAX_X)
        {
            this.x=x;
            return true;
        }
        return false;
    }

    public boolean setY(double y) {
        if(y>=MIN_X&&y<=MAX_X)
        {
            this.y=y;
            return true;
        }
        return false;
    }

    /**
     * @return the string that contains all necessary info
     */
    @Override
    public String toString()
    {
       return "("+this.getX()+","+this.getY()+")";
    }

}
