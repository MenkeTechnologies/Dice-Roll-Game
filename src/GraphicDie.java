import java.awt.*;

/**
 * Created by jacobmenke on 4/3/16.
 */

public class GraphicDie extends Die {

   public void drawDie(Graphics g, int x, int y) {
        // Draw a die with upper left corner at (x,y).  The die is
        // 35 by 35 pixels in size.  The val parameter gives the
        // value showing on the die (that is, the number of dots).

        g.setColor(Color.white);
        g.fillRect(x, y, 35, 35);
        g.setColor(Color.black);
        g.drawRect(x, y, 34,34);
        if (getDieValue() > 1)  // upper left dot
            g.fillOval(x+3, y+3, 9, 9);
        if (getDieValue() > 3)  // upper right dot
            g.fillOval(x+23, y+3, 9, 9);
        if (getDieValue() == 6) // middle left dot
            g.fillOval(x+3, y+13, 9, 9);
        if (getDieValue() % 2 == 1) // middle dot (for odd-numbered val's)
            g.fillOval(x+13, y+13, 9, 9);
        if (getDieValue() == 6) // middle right dot
            g.fillOval(x+23, y+13, 9, 9);
        if (getDieValue() > 3)  // bottom left dot
            g.fillOval(x+3, y+23, 9, 9);
        if (getDieValue() > 1)  // bottom right dot
            g.fillOval(x+23, y+23, 9,9);
    }


    }




