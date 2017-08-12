import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class RightTriangle extends Triangle {
    private double hypotenuse;
    private int minLen = 20;
    private int maxLen = 100;
    private Point center;

    RightTriangle(int number, Point topPoint, Color color){

        this.points = new Point[3];
        this.lengths = new double [this.points.length];
        this.number = number;
        this.color = color;
        this.topPoint = this.points[0] = topPoint;


        calculatePoints();
        calculateLenghts();
        calculateHypotenuse();
        calculateArea();
        calculatePerimeter();

        this.name = "Right triangle";



    }

    @Override
    void calculatePoints() {
        for(int i =1; i <=2 ; i++) {
            this.points[i] =  (i==1)
                    ? new Point(this.points[i-1].x, this.points[i-1].y +  ThreadLocalRandom.current().nextInt(minLen, maxLen))
                    : new Point(this.points[i-1].x + ThreadLocalRandom.current().nextInt(minLen, maxLen),this.points[i-1].y);

        }
        for(int i =0; i< this.points.length; i++){
            xCoords[i] = this.points[i].x;
            yCoords[i] = this.points[i].y;
        }
        int totalX = 0, totalY = 0;
        for(Point p :points){
            totalX += p.x;
            totalY += p.y;
        }

        this.center =  new Point(totalX / points.length,
                totalY/ points.length);

    }

    @Override
    void calculateLenghts() {
        //with hypotenuse
        for(int i =0 ; i<  this.points.length;i ++){
            this.lengths[i] = (i != this.points.length - 1)?
                    Math.sqrt(Math.pow(points[i].x - points[i+1].x, 2.0) + Math.pow(points[i].y - points[i+1].y, 2.0))
                    : Math.sqrt(Math.pow(points[i].x - points[0].x, 2.0) + Math.pow(points[i].y - points[0].y, 2.0));
        }

    }

    double getHeight(){
        return this.lengths[0];
    }
    @Override
    void calculatePerimeter() {
        this.perimeter = Math.round((this.lengths[0] + this.lengths[1]+ this.lengths[2])*100.0)/100.0;
    }

    @Override
    void calculateArea() {
        this.area = this.lengths[0] * this.lengths[1] / 2;
    }

    @Override
    Point getCenter() {
        return this.center;
    }

    @Override
    String getFullInfo() {
        return "№:" + this.number + "; Figure: " + this.name + "; Color: [" + this.color.getRed() + "|" + this.color.getGreen() +
                "|" + this.color.getBlue() + "]; Hypotenuse: " +
                this.hypotenuse + "; Area: " +
                this.area + "; Perimeter: " + this.perimeter +
                "; Center coords:[" + this.center.x + ":" + this.center.y + "].";
    }
    void calculateHypotenuse(){
        this.hypotenuse = Math.round(Math.sqrt(Math.pow(this.lengths[0],2) + Math.pow(this.lengths[1],2))*100.0)/100.0;
    }
    double getHypotenuse(boolean calculated){
        if(calculated) return this.hypotenuse;
        else return Math.round(this.lengths[2]*100.0)/100.0;
    }
}
