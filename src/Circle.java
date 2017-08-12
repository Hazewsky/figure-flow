import java.awt.*;

public class Circle extends  Figure{
    private double radius = 0;
    private double diameter = 0;
    private Point center = new Point(0,0);

    Circle(int number, Point center, double radius, Color color){
        this.number = number;
        this.color = color;
        this.center = center;
        this.radius = radius;
        this.diameter = 2* radius;
        this.name = "Circle";
        this.id = "Circle";
        calculatePerimeter();
        calculateArea();
    }

    public void calculatePerimeter(){
        if(radius <= 0) return;
        this.perimeter = Math.round((2 * Math.PI * this.radius) * 100.0)/100.0;

    }

    public void calculateArea(){
        if(radius <= 0 ) return;

        this.area= Math.round(Math.PI * Math.pow(this.radius,2)*100.0)/100.0;
    }

    public String getFullInfo(){
        return "№:" + this.number + "; Figure: " + this.name + "; Color: [" + this.color.getRed() + "|" + this.color.getGreen() +
                "|" + this.color.getBlue() + "]; Radius: " +
                this.radius + "; Diameter: " + this.diameter + "; Area: " +
                this.area + "; Perimeter: " + this.perimeter +
                "; Center coords:[" + this.center.x + ":" + this.center.y + "].";
    }
    //get
    public double getRadius(){
        return this.radius;
    }

    public double getDiameter() {
        return this.diameter;
    }

    public Point getCenter() {
        return this.center;
    }
}
