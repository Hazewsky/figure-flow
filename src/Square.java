import java.awt.Color;
import java.awt.Point;
public class Square extends Figure {
    private int shapeLength;
    private Point center;
    private Point startDrawPoint;
    private Point endDrawPoint;
    Square(int number, int lengthOfShape, Color color, Point center){
        this.number = number;
        this.shapeLength = lengthOfShape;
        this.name = "Square";
        this.id = "Square";
        this.color = color;
        this.center = center;
        this.startDrawPoint = new Point(this.center.x - this.shapeLength, this.center.y - this.shapeLength);
        this.endDrawPoint = new Point(this.center.x + this.shapeLength, this.center.y + this.shapeLength);
        this.calculatePerimeter();
        this.calculateArea();
    }

    public String getFullInfo(){
        return "№:" + this.number + "; Figure: " + this.name + "; Color: [" + this.color.getRed() + "|" + this.color.getGreen() +
                "|" + this.color.getBlue() + "]; Length of shape: " + this.shapeLength +
                "; Perimeter: " + this.perimeter + " Area: " + this.area +
                "; Center coords:[" + this.center.x + ":" + this.center.y + "].";
    }
    public void calculateArea(){
        this.area = Math.pow(shapeLength, 2);
    }

    public void calculatePerimeter(){
        this.perimeter = 4.0 * this.shapeLength;
    }

    public int getShapeLength(){
        return this.shapeLength;
    }
    public Point getStartDrawPoint(){
        return this.startDrawPoint;
    }

    public Point getCenter() {
        return this.center;
    }
}
