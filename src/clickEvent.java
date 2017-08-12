import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class clickEvent extends JComponent implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        int xCoord = e.getX();
        int yCoord = e.getY();
        if(MainFrame.figuresArray.length != 0) {
            for(Figure fg : MainFrame.figuresArray) {
                switch(fg.id) {
                    //Check intersection based on type of figure and its coordinates
                    case "Circle":
                        if(xCoord >= fg.getCenter().x - ((Circle) fg).getRadius() &&
                                yCoord >= fg.getCenter().y - ((Circle) fg).getRadius() &&
                                xCoord <= fg.getCenter().x + ((Circle) fg).getRadius() &&
                                yCoord <= fg.getCenter().y + ((Circle) fg).getRadius())
                            JOptionPane.showMessageDialog(null, fg.getFullInfo(),
                                    fg.id, JOptionPane.PLAIN_MESSAGE);
                        break;
                    case "Square":
                        if(xCoord >= ((Square)fg).getStartDrawPoint().x &&
                                yCoord >= ((Square)fg).getStartDrawPoint().y &&
                                xCoord <= fg.getCenter().x + ((Square) fg).getShapeLength() &&
                                yCoord <= fg.getCenter().y + ((Square) fg).getShapeLength())
                            JOptionPane.showMessageDialog(null, fg.getFullInfo(),
                                    fg.id, JOptionPane.PLAIN_MESSAGE);
                        break;
                    //Intersection check is based on firstPoint
                    case "Triangle":
                        int triangleX = ((Triangle)fg).points[0].x;
                        int triangleY = ((Triangle)fg).points[0].y;

                        if(xCoord >= fg.getCenter().x - ((Triangle)fg).lengths[1] / 2 &&
                                xCoord <= fg.getCenter().x + ((Triangle)fg).lengths[1]/3 &&
                                yCoord >= fg.getCenter().y - ((Triangle)fg).lengths[0] / 2&&
                                yCoord <= fg.getCenter().y + ((Triangle)fg).lengths[0] / 3
                                )
                            JOptionPane.showMessageDialog(null, fg.getFullInfo(),
                                    fg.id, JOptionPane.PLAIN_MESSAGE);
                        break;
                    case "Trapezoid":
                        int trapezoidX = ((Trapezoid)fg).points[0].x;
                        int trapezoidY = ((Trapezoid)fg).points[0].y;

                        if(xCoord >= ((Trapezoid)fg).points[3].x && xCoord <= ((Trapezoid)fg).points[2].x &&
                                yCoord >= ((Trapezoid)fg).points[0].y && yCoord <= ((Trapezoid)fg).points[2].y)
                            JOptionPane.showMessageDialog(null, fg.getFullInfo(),
                                    fg.id, JOptionPane.PLAIN_MESSAGE);
                        break;
                    default:
                        break;
                }
            }
        }
    }
    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }
}
