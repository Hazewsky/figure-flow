import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class IsoscelesTrapezoid extends Trapezoid {
    private double minHeight = 3.0, maxHeight = 30.0, minLesserLen = 5.0, maxLesserLen = 50.0;

    private Point center;

    IsoscelesTrapezoid(int number, Point startPoint, Color color){
        this.number = number;
        double scale = ThreadLocalRandom.current().nextDouble(2.0, 5.0);
        this.height = Math.round(ThreadLocalRandom.current().nextDouble(minHeight, maxHeight)*100.0)/100.0;
        this.lesserLen = ThreadLocalRandom.current().nextDouble(minLesserLen, maxLesserLen);
        this.biggerLen = this.lesserLen * scale;

        this.startPoint = startPoint;
        this.color = color;
        this.name = "Isosceles Trapezoid";


        calculatePoints();
        calculateLengths();
        calculateMidsegment();
        calculateDiagonal();
        calculateArea();
        calculatePerimeter();
    }

    @Override
    void calculateArea() {
        this.area = Math.round((biggerLen + lesserLen) / 2 * height*100.0)/100.0;
    }

    @Override
    void calculatePerimeter() {
        for(int i=0; i< lengths.length; i++) {
            this.perimeter += this.lengths[i];
        }
        this.perimeter = Math.round(this.perimeter * 100.0)/100.0;
    }



    @Override
    void calculateMidsegment() {
        this.midsegment = Math.round((lesserLen + biggerLen) / 2 * 100.0)/100.0;
    }

    @Override
    void calculateDiagonal() {
        this.diagonal = Math.round(Math.sqrt((Math.pow(this.lengths[this.lengths.length-1],2)
                + lesserLen * biggerLen))*100.0)/100.0;
    }

    @Override
    void calculatePoints() {
        this.points = new Point[4];
        this.points[0] = startPoint;
        this.points[1] = new Point((int)(this.points[0].x + lesserLen), (this.points[0].y));
        this.points[2] = new Point((int)(this.points[1].x + (biggerLen - lesserLen) / 2),
                (int)(this.points[1].y + lesserLen + this.height));
        this.points[3] =  new Point((int)(this.points[2].x - biggerLen),
               (this.points[2].y));


        xCoords =  new int[points.length];
        yCoords = new int[points.length];
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
    void calculateLengths() {
        this.lengths = new double[this.points.length];
        for(int i =0 ; i<  this.points.length;i++){
            if(points[i] != null)
            this.lengths[i] = (i != this.points.length - 1)?
                    Math.sqrt(Math.pow(points[i].x - points[i+1].x, 2.0) + Math.pow(points[i].y - points[i+1].y, 2.0))
                    : Math.sqrt(Math.pow(points[i].x - points[0].x, 2.0) + Math.pow(points[i].y - points[0].y, 2.0));

        }
    }

    @Override
    String getFullInfo() {
         return "№:" + this.number + "; Figure: " + this.name + "; Color: [" + this.color.getRed()
                 + "|" + this.color.getGreen() +
                "|" + this.color.getBlue() + "]; Midsegment: " +
                this.midsegment + "; Diagonal: " + this.diagonal + "; Area: " +
                this.area + "; Perimeter: " + this.perimeter +
                "; Height: " + this.height + "; Center coords:[" + this.center.x + ":" + this.center.y + "].";
    }

    @Override
    Point getCenter() {
        return this.center;
    }

    @Override
    double getBiggerLen() {
        return this.biggerLen;
    }

    @Override
    double getDiagonal() {
        return this.diagonal;
    }

    @Override
    double getHeight() {
        return this.height;
    }

    @Override
    double getLesserLen() {
        return this.lesserLen;
    }

    @Override
    double getMidsegment() {
        return this.midsegment;
    }
}
