import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class MainFrame extends JFrame {
    private static int maxX = 700;
    private static int maxY = maxX;
    private static Figure fig;
    private static FigureTypes chosenType;
    public static Figure[] figuresArray;
    private static double minRadius = 10.0;
    private static double maxRadius = 50.0;
    private static int minLength = (int)minRadius;
    private static int maxLength = (int)maxRadius;
    private clickEvent click;
    MainFrame(){
        super("Geometry task");
        setLayout(new FlowLayout());
        setSize(maxX, maxY);
        setResizable(false);
        click = new clickEvent();
        addMouseListener(click);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }
    public void paint(Graphics g){

        int ranNumberOfFigures = ThreadLocalRandom.current().nextInt(10, maxX / 20);
        figuresArray = new Figure[ranNumberOfFigures];
        g.clearRect(0,0,maxX,maxY);
        for(int i =0; i< figuresArray.length; i++) {
            g.setColor(Color.BLACK);

            int randomFigure = ThreadLocalRandom.current().nextInt(0, FigureTypes.values().length);

            chosenType = FigureTypes.valueOf(FigureTypes.values()[randomFigure].name());

            fig = createRandomFigure(FigureTypes.valueOf(FigureTypes.values()[randomFigure].name()),i);

            if(fig != null) {
                g.setColor(fig.color);
                switch(randomFigure) {
                    case 0:
                        Circle buf = (Circle) fig;
                        g.fillOval((int)(buf.getCenter().x - buf.getRadius()),
                                (int)(buf.getCenter().y - buf.getRadius()),
                                (int)( 2* buf.getRadius()),
                                (int)( 2* buf.getRadius()));

                        break;
                    case 1:
                        Square sq = (Square) fig;

                        g.fillRect(sq.getStartDrawPoint().x, sq.getStartDrawPoint().y,
                                2* sq.getShapeLength(),2*sq.getShapeLength());
                        break;
                    case 2:
                        RightTriangle rt = (RightTriangle) fig;
                        g.fillPolygon(rt.xCoords, rt.yCoords, rt.lengths.length);

                        break;
                    case 3:
                        IsoscelesTrapezoid it = (IsoscelesTrapezoid) fig;
                        g.fillPolygon(it.xCoords,it.yCoords, it.lengths.length);
                        break;
                }

                figuresArray[i] = fig;


            }

        }
        Triangle tr;
        Trapezoid tz;
        Circle buf;
        Square sq;
        g.setFont(new Font("Serif", Font.BOLD, 15));

        for(Figure fg : figuresArray){
            g.setColor(Color.BLACK);
            if(fg!=null) {



                switch (fg.id) {
                    case "Circle":
                        buf = (Circle) fg;
                        g.drawOval((int) (buf.getCenter().x - buf.getRadius()),
                                (int) (buf.getCenter().y - buf.getRadius()),
                                (int) buf.getRadius() * 2, (int) buf.getRadius() * 2);
                        break;
                    case "Square":
                        sq = (Square) fg;
                        g.drawRect(sq.getCenter().x - sq.getShapeLength(),
                                sq.getCenter().y - sq.getShapeLength(),
                                2 * sq.getShapeLength(),
                                2 * sq.getShapeLength());
                        break;
                    case "Triangle":
                        tr = (Triangle) fg;
                        g.drawPolygon(tr.xCoords, tr.yCoords, tr.points.length);
                        break;
                    case "Trapezoid":
                        tz = (Trapezoid) fg;
                        g.drawPolygon(tz.xCoords, tz.yCoords, tz.points.length);
                        break;
                }
                if(fg.color.getGreen() < 100 && fg.color.getBlue() < 100 && fg.color.getRed() < 100)
                    g.setColor(Color.YELLOW);
                g.drawString(Integer.toString(fg.number), fg.getCenter().x, fg.getCenter().y);
                System.out.println(fg.getFullInfo());

            }
        }

    }
    public static Figure createRandomFigure(FigureTypes type, int number){
        Color randomColor = new Color(ThreadLocalRandom.current().nextFloat(),
                ThreadLocalRandom.current().nextFloat(),
                ThreadLocalRandom.current().nextFloat());
        switch (type){
            case CIRCLE:
                double ranRadius = Math.round(
                        ThreadLocalRandom.current().nextDouble(minRadius,maxRadius + 1.0)*100.0)/100.0;
                return new Circle(number, new Point(
                        ThreadLocalRandom.current().nextInt((int)(maxX *0.1), ((int)(MainFrame.maxX -ranRadius ))),
                        ThreadLocalRandom.current().nextInt((int)(maxY * 0.1), ((int)(MainFrame.maxY -ranRadius )))),
                        ranRadius, randomColor);
            case SQUARE:
                int ranLen =
                        ThreadLocalRandom.current().nextInt(minLength,maxLength + 1);
                return new Square(number, ranLen, randomColor,
                        new Point(
                                ThreadLocalRandom.current().nextInt((int)(maxX * 0.1),(int)(MainFrame.maxX  - ranLen)),
                                ThreadLocalRandom.current().nextInt((int)(maxY * 0.1),(int)(MainFrame.maxY - ranLen))
                        ));
            case TRIANGLE:
                Point ranPoint = new Point(ThreadLocalRandom.current().nextInt((int)(maxX * 0.1) ,(int)(maxX * 0.8)),
                        ThreadLocalRandom.current().nextInt((int)(maxY* 0.1),(int)(maxY * 0.8)));
                return new RightTriangle(number, ranPoint, randomColor);

            case TRAPEZOID:
                 Point TrapRanPoint = new Point(ThreadLocalRandom.current().nextInt((int)(maxX * 0.1) ,(int)(maxX * 0.8)),
                        ThreadLocalRandom.current().nextInt((int)(maxY* 0.1),(int)(maxY * 0.8)));

                return new IsoscelesTrapezoid(number, TrapRanPoint, randomColor);


        }
        return null;
    }

}
