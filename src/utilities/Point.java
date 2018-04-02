package utilities;

public class Point {
    private double x;
    private double y;
    private final double MIN_X=0,MAX_X=20000;

    //constructor
    public Point(double x, double y)
    {
        setX(x);
        setY(y);
    }

    //copy constructor
    public Point(Point other)
    {
        setX(other.getX());
        setY(other.getY());
    }

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

    @Override
    public String toString()
    {
       return "("+this.getX()+","+this.getY()+")";
    }

}
