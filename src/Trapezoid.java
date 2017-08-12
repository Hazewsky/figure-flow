import java.awt.*;

abstract class Trapezoid extends Figure{
    protected double lesserLen, biggerLen, diagonal;
    protected double midsegment , height;
    protected double[] lengths;
    protected Point[] points;
    protected Point startPoint;
    protected int[] xCoords, yCoords;
    Trapezoid(){
        this.id = "Trapezoid";
    }

    abstract void calculateMidsegment();
    abstract void calculatePoints();
    abstract void calculateLengths();
    abstract void calculateDiagonal();

    abstract double getMidsegment();
    abstract double getHeight();
    abstract double getLesserLen();
    abstract double getBiggerLen();
    abstract double getDiagonal();
}
