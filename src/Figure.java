import java.awt.Color;
import java.awt.Point;
abstract class Figure {
    protected double perimeter;
    protected double area;
    protected Color color;
    protected String name;
    protected String id;
    protected int number;
    abstract void calculatePerimeter();
    abstract void calculateArea();
    abstract String getFullInfo();
    abstract Point getCenter();


}
