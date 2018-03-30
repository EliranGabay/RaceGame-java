package utilities;

public class Point {
    private double x;
    private double y;

    //constructor
    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    //copy constructor
    public Point(Point other)
    {
        this.x = other.getX();
        this.y = other.getY();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x=x;
    }

    public void setY(double y) {
        this.y=y;
    }

}
