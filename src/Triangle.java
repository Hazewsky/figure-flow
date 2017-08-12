import java.awt.*;

abstract class Triangle extends Figure {
    Triangle(){
        this.id = "Triangle";
    }
    protected int xCoords [] = new int [3];
    protected int yCoords [] = new int[3];
    protected Point topPoint;
    protected Point[] points;
    protected double height;
    protected double[] lengths;
    abstract double getHeight();

    abstract void calculatePoints();
    abstract void calculateLenghts();
}
