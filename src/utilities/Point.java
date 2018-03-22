package utilities;

public class Point {
    private static  double x;
    private static  double y;

    public Point(double x,double y)
    {
        setX(x);
        setY(y);
    }

    public double getX() {
        return x;
    }

    private void setX(double x) {
        Point.x = x;
    }

    public double getY() {
        return y;
    }

    private void setY(double y) {
        Point.y = y;
    }

}
